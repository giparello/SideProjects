package com.interviewproject.ArticleWebsite.model;

import java.util.Date;

//creation of comment object model
public class Comment {
    //variables
    private int commentId;
    private String reviewerName;
    private String commentBody;
    private Date dateWritten;
    private int articleRating;
    private int article_id;
    private String commentHeader;

    //constructor with no parameters
    public Comment(){}

    //constructor with parameters
    public Comment(int commentId, String reviewerName, String commentBody, Date dateWritten, int articleRating, int article_id, String commentHeader) {
        this.commentId = commentId;
        this.reviewerName = reviewerName;
        this.commentBody = commentBody;
        this.dateWritten = dateWritten;
        this.articleRating = articleRating;
        this.article_id = article_id;
        this.commentHeader = commentHeader;
    }

    //getters and setters
    public String getCommentHeader() {
        return commentHeader;
    }

    public void setCommentHeader(String commentHeader) {
        this.commentHeader = commentHeader;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public Date getDateWritten() {
        return dateWritten;
    }

    public void setDateWritten(Date dateWritten) {
        this.dateWritten = dateWritten;
    }

    public int getArticleRating() {
        return articleRating;
    }

    public void setArticleRating(int articleRating) {
        this.articleRating = articleRating;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }
}
