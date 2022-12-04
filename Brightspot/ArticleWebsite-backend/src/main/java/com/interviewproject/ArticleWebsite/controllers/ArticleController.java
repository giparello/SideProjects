package com.interviewproject.ArticleWebsite.controllers;

import com.interviewproject.ArticleWebsite.dao.ArticleDao;
import com.interviewproject.ArticleWebsite.model.Article;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ArticleController {
    private ArticleDao articleDao;

    //dependency injection
    public ArticleController(ArticleDao articleDao){
    this.articleDao = articleDao;
    }

    //TODO finish return statement
    @RequestMapping(path = "/article", method = RequestMethod.GET)
    public List<Article> getAllArticles(){
        return this.articleDao.getAllArticles();
    }
    @RequestMapping(path = "/article/{articleId}", method = RequestMethod.GET)
    public Article getArticleByArticleId(@PathVariable int articleId){
        return this.articleDao.getArticleByArticleId(articleId);
    }
}
