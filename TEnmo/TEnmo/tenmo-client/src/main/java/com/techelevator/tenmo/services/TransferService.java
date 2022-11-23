package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.model.UserCredentials;
import com.techelevator.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class TransferService {
    public static final String API_BASE_URL = "http://localhost:8080/";
    private RestTemplate restTemplate = new RestTemplate();

    private String authToken = null;

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getTransferTypeString(int transferTypeID){
        String result = null;
        if (transferTypeID == 1){
            result = "Request";
        }else if (transferTypeID ==2){
            result = "Send";
        }return result;
    }
    public String getTransferStatusString(int transferStatusID){
        String result = null;
        if (transferStatusID == 2){
            result = "Approved";
        }else {
            result = "Not approved";
        }return result;
    }

    public void getTransferInformationByTransferId(int transferId) {
        Transfer transfer = null;
        try {
            ResponseEntity<Transfer> response =
                    restTemplate.exchange(API_BASE_URL+"transfer/"+transferId, HttpMethod.GET, makeAuthEntity(),Transfer.class);
            transfer = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        if (transfer.getAmount()!= null) {
            System.out.println("TransferId: " + transfer.getTransferId() + "\nTransferType: " + getTransferTypeString(transfer.getTransferTypeId()) +
                    "\nTransfer Status: " + getTransferStatusString(transfer.getTransferStatusId()) +
                    "\nSent From User: " + transfer.getAccountFrom() +
                    "\nSent To User: " + transfer.getAccountTo() + "\nAmount Sent: " + transfer.getAmount() + "\n");
        }else System.out.println("no transfers found");
    }

    public Transfer addTransfer(int transferTypeId, int transferStatusId, int accountFromId, int accountToId, BigDecimal amount) {
        Transfer transfer = new Transfer();
        transfer.setTransferStatusId(transferStatusId);
        transfer.setTransferTypeId(transferTypeId);
        transfer.setAccountFrom(accountFromId);
        transfer.setAccountTo(accountToId);
        transfer.setAmount(amount);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Transfer> entity = new HttpEntity<>(transfer, headers);
        transfer = restTemplate.postForObject(API_BASE_URL+"transfer", entity, Transfer.class);
    return transfer;
    }

    public Transfer[] getAllTransfers() {
        RestTemplate restTemplate = new RestTemplate();
        Transfer[] transfers = null;
        transfers = restTemplate.getForObject(API_BASE_URL+"transfer",Transfer[].class);
        return transfers;
    }

        private HttpEntity<Void> makeAuthEntity () {
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(authToken);
            return new HttpEntity<>(headers);
        }

}
