package com.interviewproject.ArticleWebsite.controllers;

import com.interviewproject.ArticleWebsite.dao.ArticleDao;
import com.interviewproject.ArticleWebsite.model.Article;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
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
