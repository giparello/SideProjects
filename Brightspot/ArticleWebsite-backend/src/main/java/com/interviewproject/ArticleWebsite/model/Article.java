package com.interviewproject.ArticleWebsite.model;

import java.util.Date;

//create article object model
public class Article {
    //variables
    private int articleId;
    private String authorName;
    private String articleName;
    private String articleMainPoint;
    private String articleBody;
    private Date dateWritten;
    private String imageURL;
    private String tag;

    //constructor with no parameters
    public Article(){

    }
    //constructor with parameters
    public Article(int articleId, String authorName, String articleName, String articleMainPoint, String articleBody, Date dateWritten, String imageURL, String tag) {
        this.articleId = articleId;
        this.authorName = authorName;
        this.articleName = articleName;
        this.articleMainPoint = articleMainPoint;
        this.articleBody = articleBody;
        this.dateWritten = dateWritten;
        this.imageURL = imageURL;
        this.tag = tag;
    }

    //getters and setters
    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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
