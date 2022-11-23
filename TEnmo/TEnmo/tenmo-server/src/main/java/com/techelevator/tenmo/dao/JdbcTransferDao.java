package com.techelevator.tenmo.dao;


import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransferDao implements TransferDao{

    private JdbcTemplate jdbcTemplate;
    JdbcAccountDao accountDao;

    public JdbcTransferDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Transfer> getAllTransfers() {
        List<Transfer> transfers = new ArrayList<>();
    String sql = "SELECT username, balance, account_id, account_from, account_to, amount, transfer_id, transfer_type_desc, transfer_type_id, transfer_status_desc, transfer_status_id\n" +
            "\tFROM public.vw_get_all_transaction_history;";
    SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
    while (results.next()){
        transfers.add(mapToTransfer(results));
    }
    return transfers;
    }

    @Override
    public Transfer createTransfer(Transfer transfer) {
        Transfer newTransfer = new Transfer();
        newTransfer.setTransferTypeId(transfer.getTransferTypeId());
        newTransfer.setTransferStatusId(transfer.getTransferStatusId());
        newTransfer.setAccountFrom(transfer.getAccountFrom());
        newTransfer.setAccountTo(transfer.getAccountTo());
        newTransfer.setAmount(transfer.getAmount());

        String sql ="INSERT INTO public.transfer(\n" +
                "\ttransfer_type_id, transfer_status_id, account_from, account_to, amount)\n" +
                "\tVALUES (?, ?, ?, ?, ?) RETURNING transfer_id;";
        int transferId = jdbcTemplate.queryForObject(sql, int.class,newTransfer.getTransferTypeId(),newTransfer.getTransferStatusId(), newTransfer.getAccountFrom(),newTransfer.getAccountTo(),newTransfer.getAmount());
        newTransfer.setTransferId(transferId);
        System.out.println(newTransfer);
        return newTransfer;
    }

    @Override
    public Transfer getTransferById(int transferId) {
        Transfer transfer = new Transfer();
        String sql = "SELECT username, balance, account_id, account_from, account_to, amount, transfer_id, transfer_type_desc, transfer_type_id, transfer_status_desc, transfer_status_id\n" +
                "\tFROM public.vw_get_all_transaction_history WHERE transfer_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transferId);
        if(results.next()) {
            transfer = mapToTransfer(results);
        }
        return transfer;
    }

    @Override
    public List<Transfer> listOfAllTransactions() {
        List<Transfer> transfers = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT username, balance, account_id, account_from, account_to, amount, transfer_id, transfer_type_desc, transfer_type_id,\n" +
                "transfer_status_desc, transfer_status_id" +
                "FROM vw_Get_All_Transaction_History;");
        while (results.next()) {
            transfers.add(mapToTransfer(results));
        }
        return transfers;
    }

    @Override
    public Transfer transactionInformationByAccountId(int accountId){
        Transfer transfer = null;
        String sql = "SELECT username, balance, account_from, account_to, account_id, amount, transfer_id, transfer_type_desc, transfer_type_id,\n" +
                "transfer_status_desc, transfer_status_id, transfer_id\n" +
                "FROM vw_Get_All_Transaction_History\n" +
                "WHERE account_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId);
        if(results.next()) {
            transfer = mapToTransfer(results);
        }
        return transfer;
    }


    @Override
    public Transfer transactionInformationByStatusId(int transferStatusId) {
        Transfer transfer = null;
        String sql = "SELECT username, balance, account_from, account_to, amount, transfer_id, transfer_type_desc, transfer_type_id,\n" +
                "transfer_status_desc, transfer_status_id, transfer_id\n" +
                "FROM vw_Get_All_Transaction_History\n" +
                "WHERE transfer_status_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transferStatusId);
        if(results.next()) {
            transfer = mapToTransfer(results);
        }
        return transfer;
    }

    private Transfer mapToTransfer(SqlRowSet results) {
        try {
            Transfer transfer = new Transfer();

            transfer.setTransferId(results.getInt("transfer_id"));
            transfer.setTransferTypeId(results.getInt("transfer_type_id"));
            transfer.setTransferStatusId(results.getInt("transfer_status_id"));
            transfer.setAccountFrom(results.getInt("account_from"));
            transfer.setAccountTo(results.getInt("account_to"));
            transfer.setAmount(results.getBigDecimal("amount"));

            return transfer;

        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }


}