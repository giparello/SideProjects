package com.interviewproject.ArticleWebsite.controllers;


import com.interviewproject.ArticleWebsite.dao.CommentDao;
import com.interviewproject.ArticleWebsite.model.Comment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CommentController {
    //Instantiate data access object
    private CommentDao commentDao;

    //Constructor
    public CommentController(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    //Create endpoint to get all comments
    @RequestMapping(path = "/comment",method = RequestMethod.GET)
        public List<Comment> getAllComments(){
            return this.commentDao.getAllComments();
        }

    //Create endpoint to get comments by article
    @RequestMapping(path = "/comment/{articleId}",method = RequestMethod.GET)
    public List<Comment> getCommentsByArticleId(@PathVariable int articleId){
        return commentDao.getCommentsByArticleId(articleId);
    }
    //create endpoint to add a new comment
    @RequestMapping(path = "/comment",method = RequestMethod.POST)
    public Comment addComment(@RequestBody Comment comment){
        return commentDao.addComment(comment);
    }
}
