package com.interviewproject.ArticleWebsite.model;

import java.util.Date;

public class Comment {
    private int commentId;
    private String reviewerName;
    private String commentBody;
    private Date dateWritten;
    private int articleRating;
    private int article_id;
    private String commentHeader;

    public Comment(){}

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
