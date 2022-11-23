package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;

import java.math.BigDecimal;


public interface AccountDao {


    BigDecimal getAccountBalance(int userId);
    Account getAccountByAccountId(int accountId);
    Account getAccountByUserId(int userid);
    boolean updateAccount(int userId, Account account);

}