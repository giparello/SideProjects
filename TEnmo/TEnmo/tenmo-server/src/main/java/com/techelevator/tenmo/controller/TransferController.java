package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.techelevator.tenmo.dao.*;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TransferController {

    private TransferDao transferDao;
    private UserDao userDao;
    private AccountDao accountDao;

    public TransferController(TransferDao transferDao){
        this.transferDao = transferDao;
    }


    @RequestMapping(path = "transfer", method = RequestMethod.POST)
    public Transfer addTransfer(@RequestBody Transfer transfer) {
        if (transfer != null) {
            transferDao.createTransfer(transfer);
        }
        return transfer;
    }


    @RequestMapping(path = "transfer", method = RequestMethod.GET)
    public List<Transfer> getAllTransfers(){
        return transferDao.getAllTransfers();
    }

    @RequestMapping(path = "transfer/{transferId}", method = RequestMethod.GET)
    public Transfer getTransferByTransferId(@PathVariable int transferId){
        return transferDao.getTransferById(transferId);
    }

}
