package com.interviewproject.ArticleWebsite.service;

import com.interviewproject.ArticleWebsite.model.CatFact;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Component
public class CatFactService {
//sample api request for outside API
    private static final String API_URL = "https://cat-data.netlify.app/api/fact/random";
    private RestTemplate restTemplate = new RestTemplate();

    public CatFact getFact() throws RestClientResponseException{
        CatFact catFact = restTemplate.getForObject(API_URL, CatFact.class);
        return catFact;
    }



}
