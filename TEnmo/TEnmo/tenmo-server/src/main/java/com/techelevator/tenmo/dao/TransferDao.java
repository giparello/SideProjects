package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.math.BigDecimal;
import java.util.List;

public interface TransferDao {

    // Read Transaction
    Transfer transactionInformationByAccountId(int accountId);
    Transfer transactionInformationByStatusId(int transferStatusId);
    List<Transfer> listOfAllTransactions();

    Transfer createTransfer(Transfer transfer);
    Transfer getTransferById(int transferId);
    List<Transfer> getAllTransfers();


}