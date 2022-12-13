package com.interviewproject.ArticleWebsite.dao;

import com.interviewproject.ArticleWebsite.model.Comment;
import java.util.List;

public interface CommentDao {



    List<Comment> getAllComments();
    List<Comment> getCommentsByArticleId(int articleId);
    Comment addComment(Comment comment);

}
