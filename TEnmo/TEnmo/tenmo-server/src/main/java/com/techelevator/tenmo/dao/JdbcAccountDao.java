package com.techelevator.tenmo.dao;
import com.techelevator.tenmo.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class JdbcAccountDao implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public BigDecimal getAccountBalance(int userId) {
        Account account = null;
        String sql = "SELECT balance FROM account WHERE user_id = ?;";
        BigDecimal result = jdbcTemplate.queryForObject(sql, BigDecimal.class, userId);
        return result;
    }

    @Override
    public Account getAccountByAccountId(int accountId) {
        Account account = null;
        String sql = "SELECT * FROM account WHERE account_id =?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId);
        if(results.next()) {
            account = mapRowToAccount(results);
        }
        return account;
    }

    @Override
    public Account getAccountByUserId(int userId) {
        Account account = null;
        String sql = "SELECT * FROM account WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()) {
            account = mapRowToAccount(results);
        }
        return account;
    }

    @Override
    public boolean updateAccount(int userId, Account account) {
        String sql = "UPDATE account SET balance = ? " +
                "WHERE account.user_id = ?;";
        int numberOfRows =
                jdbcTemplate.update(sql, account.getAccountBalance(), account.getUserId());
        return numberOfRows == 1;
    }
    private Account mapRowToAccount(SqlRowSet result) {
        Account account = new Account();
        account.setAccountId(result.getInt("account_id"));
        account.setUserId(result.getInt("user_id"));
        account.setAccountBalance(result.getBigDecimal("balance"));
        return account;

    }

}









