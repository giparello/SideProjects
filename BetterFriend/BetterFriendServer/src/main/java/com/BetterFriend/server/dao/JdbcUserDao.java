package com.BetterFriend.server.dao;

import com.BetterFriend.server.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class JdbcUserDao {
    public List<User> findAll(){
        return null;
    }

    public User getUserById(int id){
        return null;
    }

    public User findByUsername(String username){
        return null;
    }

    public int findIdByUsername(String username){
        return 0;
    }

    public boolean create(String username, String password){
        return false;
    }




}
