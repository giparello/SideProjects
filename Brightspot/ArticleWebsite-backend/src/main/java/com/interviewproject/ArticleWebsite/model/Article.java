package com.interviewproject.ArticleWebsite.model;

import java.util.Date;

public class Article {
    private int articleId;
    private String authorName;
    private String articleName;
    private String articleMainPoint;
    private String articleBody;
    private Date dateWritten;
    private String imageURL;
    public Article(){

    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleMainPoint() {
        return articleMainPoint;
    }

    public void setArticleMainPoint(String articleMainPoint) {
        this.articleMainPoint = articleMainPoint;
    }

    public String getArticleBody() {
        return articleBody;
    }

    public void setArticleBody(String articleBody) {
        this.articleBody = articleBody;
    }

    public Date getDateWritten() {
        return dateWritten;
    }

    public void setDateWritten(Date dateWritten) {
        this.dateWritten = dateWritten;
    }
}
