package com.interviewproject.ArticleWebsite.dao;

import com.interviewproject.ArticleWebsite.model.Article;
import java.util.Date;
import java.util.List;

//interface makes classes injectable for dependency injection
public interface ArticleDao {
    List<Article> getAllArticles();
    Article getArticleByArticleId(int articleId);
    public Article getArticleByArticleName(String articleName);
    public Article getArticleByAuthorName(String articleName);
    public Article getArticleByDate(Date date);
    public List<Article> getArticleByTag(String tag);
    Article addArticle(Article article);


}
