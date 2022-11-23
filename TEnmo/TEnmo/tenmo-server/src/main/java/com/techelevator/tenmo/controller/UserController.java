package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.JdbcUserDao;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.web.bind.annotation.*;
import com.techelevator.tenmo.dao.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class UserController {
    //create userDao
    JdbcUserDao userDao;
    //create account Dao
    private JdbcAccountDao accountDao;
    //create transfer Dao
    private JdbcTransferDao transferDao;


    //constructor
    public UserController(JdbcUserDao userDao){
        this.userDao = userDao;
    }

    //get all users
    @RequestMapping(path = "user", method =RequestMethod.GET)
    public List<User> getAllUsers(){
        return userDao.findAll();
    }

    //get a single user based on id
    @RequestMapping(path = "user/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable int userId) {
        User user = userDao.getUserById(userId);
        return user;
    }
    //get transaction based on userID
    @RequestMapping(path = "/user/{userId}/transaction", method = RequestMethod.GET)
    public List<Transfer> getTransfersBasedOnUserId(@PathVariable int userID){
        User user = userDao.getUserById(userID);
        List <Transfer> transfers = transferDao.listOfAllTransactions();
        return transfers;
    }


}
