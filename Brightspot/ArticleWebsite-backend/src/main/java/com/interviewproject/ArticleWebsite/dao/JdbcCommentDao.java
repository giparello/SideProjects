package com.interviewproject.ArticleWebsite.dao;

import com.interviewproject.ArticleWebsite.model.Comment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@CrossOrigin
public class JdbcCommentDao implements CommentDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcCommentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Comment> getAllComments() {
        List<Comment> comments = new ArrayList<>();
        String sql="SELECT comment_id, reviewer_name, comment_body, date_written, article_rating, article_id, comment_header\n" +
                "\tFROM public.article_comments;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while (result.next()){
            Comment comment =mapRowToComment(result);
            comments.add(comment);
        }
        return comments;
    }

    @Override
    public List<Comment> getCommentsByArticleId(int articleId) {
        List<Comment> comments = new ArrayList<>();
        String sql="SELECT comment_id, reviewer_name, comment_body, date_written, article_rating, article_id, comment_header\n" +
                "\tFROM public.article_comments WHERE article_id =?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, articleId);
        while (result.next()){
            Comment comment =mapRowToComment(result);
            comments.add(comment);
        }
        return comments;
    }

    @Override
    public Comment addComment(Comment comment) {
        Comment newComment = new Comment();
        LocalDateTime date= LocalDateTime.now();
        newComment.setReviewerName(comment.getReviewerName());
        newComment.setDateWritten(comment.getDateWritten());
        newComment.setCommentBody(comment.getCommentBody());
        newComment.setArticleRating(comment.getArticleRating());
        newComment.setArticle_id(comment.getArticle_id());
        newComment.setCommentId(comment.getCommentId());
        newComment.setCommentHeader(comment.getCommentHeader());
        String sql="INSERT INTO public.article_comments(\n" +
                "\treviewer_name, comment_body, date_written, article_rating, article_id, comment_header)\n" +
                "\tVALUES (?, ?, ?, ?, ?, ?) RETURNING comment_id;";
        int commentId =jdbcTemplate.queryForObject(sql, int.class,newComment.getReviewerName(),newComment.getCommentBody(),date ,newComment.getArticleRating(),newComment.getArticle_id(), newComment.getCommentHeader());
        newComment.setCommentId(commentId);
        return newComment;
    }

    private Comment mapRowToComment(SqlRowSet rowSet){
        Comment result = new Comment();
        result.setCommentId(rowSet.getInt("comment_id"));
        result.setArticle_id(rowSet.getInt("article_id"));
        result.setArticleRating(rowSet.getInt("article_rating"));
        result.setCommentBody(rowSet.getString("comment_body"));
        if (rowSet.getDate("date_written")!=null) {
            result.setDateWritten(rowSet.getDate("date_written"));
        }
        result.setReviewerName(rowSet.getString("reviewer_name"));
        result.setCommentHeader(rowSet.getString("comment_header"));
        return result;
    }
}
