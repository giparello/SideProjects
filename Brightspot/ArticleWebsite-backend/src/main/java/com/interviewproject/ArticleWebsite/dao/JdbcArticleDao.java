package com.interviewproject.ArticleWebsite.dao;

import com.interviewproject.ArticleWebsite.model.Article;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class JdbcArticleDao implements ArticleDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcArticleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    //get all articles
    @Override
    public List<Article> getAllArticles() {
        List<Article> results = new ArrayList<Article>();
        String sql = "SELECT article_id, author_name, article_name, article_main_point, article_body, date_written\n" +
                "\tFROM public.articles;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()){
            Article article = mapRowToArticle(rowSet);
            results.add(article);
        }
        return results;
    }
    //get an article by article ID
    @Override
    public Article getArticleByArticleId(int articleId) {
        Article result = new Article();
        String sql = "SELECT article_id, author_name, article_name, article_main_point, article_body, date_written\n" +
                "\tFROM public.articles WHERE article_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, articleId);
        while (rowSet.next()){
            result = mapRowToArticle(rowSet);
        }

        return result;
    }
    @Override
    public Article getArticleByArticleName(String articleName) {
        Article result = new Article();
        String sql = "SELECT article_id, author_name, article_name, article_main_point, article_body, date_written\n" +
                "\tFROM public.articles WHERE article_name = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, articleName);
        while (rowSet.next()){
            result = mapRowToArticle(rowSet);
        }

        return result;
    }

    @Override
    public Article getArticleByAuthorName(String authorName) {
        Article result = new Article();
        String sql = "SELECT article_id, author_name, article_name, article_main_point, article_body, date_written\n" +
                "\tFROM public.articles WHERE author_name = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, authorName);
        while (rowSet.next()){
            result = mapRowToArticle(rowSet);
        }

        return result;
    }

    @Override
    public Article getArticleByDate(Date date) {
        Article result = new Article();
        String sql = "SELECT article_id, author_name, article_name, article_main_point, article_body, date_written\n" +
                "\tFROM public.articles WHERE date_written = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, date);
        while (rowSet.next()){
            result = mapRowToArticle(rowSet);
        }

        return result;
    }


    private Article mapRowToArticle(SqlRowSet rowSet){
        Article result = new Article();
        result.setArticleBody(rowSet.getString("article_body"));
        result.setArticleId(rowSet.getInt("article_id"));
        result.setArticleMainPoint(rowSet.getString("article_main_point"));
        result.setArticleName(rowSet.getString("article_name"));
        result.setAuthorName(rowSet.getString("author_name"));
        if (rowSet.getDate("date_written")!=null) {
            result.setDateWritten(rowSet.getDate("date_written"));
        }
        return result;
    }
}
