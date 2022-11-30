package com.BetterFriend.client.services;

import com.BetterFriend.client.model.Person;
import com.BetterFriend.client.util.BasicLogger;
import com.BetterFriend.client.util.BasicLoggerException;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class PersonService {
    public static final String API_BASE_URL = "http://localhost:8080/";
    private final RestTemplate restTemplate = new RestTemplate();

    private String authToken = null;
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Person[] getAllFriends() throws BasicLoggerException {
        Person[] people = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            ResponseEntity<Person[]> response = restTemplate.exchange(API_BASE_URL + "friend", HttpMethod.GET, makeAuthentity(), Person[].class);
            people = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return people;
    }



    public HttpEntity<Void> makeAuthentity(){
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);

    }




}
