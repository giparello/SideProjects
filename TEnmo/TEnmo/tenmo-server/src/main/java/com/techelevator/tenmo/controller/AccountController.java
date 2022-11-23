package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.techelevator.tenmo.dao.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;


@RestController
public class AccountController {

    private AccountDao accountDao;

    public AccountController(AccountDao accountDao){
        this.accountDao = accountDao;
    }
    // http://localhost:8080/


    @RequestMapping(path = "account/user/{userId}", method = RequestMethod.GET)
    public Account getAccountByUserId(@PathVariable int userId) {
        return accountDao.getAccountByUserId(userId);
    }

    // This returns the account balance
    @RequestMapping(path = "account/user/{userId}/balance",method = RequestMethod.GET)
    public BigDecimal getAccountBalance(@PathVariable int userId){
        return accountDao.getAccountBalance(userId);
    }



    @RequestMapping(path = "account/user/{userId}", method = RequestMethod.PUT)
    public void updateAccount(@PathVariable int userId, @RequestBody Account account) {
        if (userId != account.getUserId()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id of path does not match data", null);
        }
        accountDao.updateAccount(account.getUserId(), account);
    }


}