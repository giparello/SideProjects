package com.interviewproject.ArticleWebsite.controllers;

import com.interviewproject.ArticleWebsite.dao.ArticleDao;
import com.interviewproject.ArticleWebsite.model.Article;
import com.interviewproject.ArticleWebsite.model.Comment;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ArticleController {
    //Instantiate Data access object
    private ArticleDao articleDao;

    //Constructor
    public ArticleController(ArticleDao articleDao){
    this.articleDao = articleDao;
    }

    //create endpoint to get all of the articles
    @RequestMapping(path = "/article", method = RequestMethod.GET)
    public List<Article> getAllArticles(){
        return this.articleDao.getAllArticles();
    }

    //create endpoint to get articles by article ID
    @RequestMapping(path = "/article/{articleId}", method = RequestMethod.GET)
    public Article getArticleByArticleId(@PathVariable int articleId){
        return this.articleDao.getArticleByArticleId(articleId);
    }
    //create endpoint to add a new article
    @RequestMapping(path = "/article",method = RequestMethod.POST)
    public Article addArticle(@RequestBody Article article){
        return articleDao.addArticle(article);
    }

    //create endpoint to get articles by tag
    @RequestMapping(path = "/article/type/{tag}",method = RequestMethod.GET)
    public List<Article> getArticlesByTag(@PathVariable String tag){
        return articleDao.getArticleByTag(tag);
    }
}
