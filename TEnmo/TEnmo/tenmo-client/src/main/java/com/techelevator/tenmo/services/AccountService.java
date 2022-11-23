package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class AccountService {

    public static final String ACCOUNT_BASE_URL = "http://localhost:8080";
    private RestTemplate restTemplate = new RestTemplate();
    private String authToken = null;

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }



    private HttpEntity <Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);
    }

    public BigDecimal getBalance(int accountNumber) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(ACCOUNT_BASE_URL + "/account/user/" + accountNumber+"/balance", BigDecimal.class);
    }

    public Account getAccount(int accountNumber) {
        Account account = null;
        try {
            account = restTemplate.getForObject(ACCOUNT_BASE_URL + "account/user/"+ accountNumber, Account.class);
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return account;
    }

    public void updateAccount(int accountNumber, BigDecimal newBalance) {
        RestTemplate restTemplate = new RestTemplate();
        Account account = getAccount(accountNumber);
        account.setBalance(newBalance);
        String resourceUrl = "http://localhost:8080/account/user/" + account.getUserId();
        // Create the request body by wrapping
        // the object in HttpEntity
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);
        try {
        HttpEntity<Account> request = new HttpEntity<Account>(account, headers);
        // Send the PUT method as a method parameter
        restTemplate.put(resourceUrl, request, Account.class);
    }catch (Exception e){
            System.out.println("error");
        }
}
}
