package com.service;

import com.entities.User;
import org.apache.ibatis.session.SqlSession;

public class TestInsertUser {
    public static void main(String[] args) {
        SqlSession session = ConnexionBD.getSession();
        
        User user = new User("username2", "george@hotmail.com", "Abc123456");
        
        session.insert("com.mapper.UserMapper.insertUser", user);
        session.commit();
        
        session.close();
     }   
}
