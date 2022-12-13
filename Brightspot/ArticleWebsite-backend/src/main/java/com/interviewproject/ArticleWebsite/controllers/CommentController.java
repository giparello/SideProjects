package com.interviewproject.ArticleWebsite.controllers;


import com.interviewproject.ArticleWebsite.dao.CommentDao;
import com.interviewproject.ArticleWebsite.model.Comment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CommentController {
    private CommentDao commentDao;

    public CommentController(CommentDao commentDao) {
        this.commentDao = commentDao;
    }
    @RequestMapping(path = "/comment",method = RequestMethod.GET)
        public List<Comment> getAllComments(){
            return this.commentDao.getAllComments();
        }
    @RequestMapping(path = "/comment/{articleId}",method = RequestMethod.GET)
    public List<Comment> getCommentsByArticleId(@PathVariable int articleId){
        return commentDao.getCommentsByArticleId(articleId);
    }
    @RequestMapping(path = "/comment",method = RequestMethod.POST)
    public Comment addComment(@RequestBody Comment comment){
        return commentDao.addComment(comment);
    }
}
