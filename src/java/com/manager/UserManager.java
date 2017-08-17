package com.manager;

import com.entities.User;
import com.service.ConnexionBD;
import org.apache.ibatis.session.SqlSession;

public class UserManager {
    public static User selectUserByName(User user) {
        User user1;    
        SqlSession session = ConnexionBD.getSession();
  
        user1 = session.selectOne("com.mapper.UserMapper.getUserByName", user.getUsername());
        session.close();	  
        
        return user1;
    }
    
    public static User selectUserByEmail(User user) {
        User user1;    
        SqlSession session = ConnexionBD.getSession();
  
        user1 = session.selectOne("com.mapper.UserMapper.getUserByEmail", user.getEmail());
        session.close();	  
        
        return user1;
    }
    
        public static User selectUserById(User user) {
        User user1;    
        SqlSession session = ConnexionBD.getSession();
  
        user1 = session.selectOne("com.mapper.UserMapper.getUserById", user.getId_user());
        session.close();	  
        
        return user1;
    }
    
    public static void insertUser(User user) {
        boolean userInserted = false; 
        SqlSession session = ConnexionBD.getSession();
  
        session.insert("com.mapper.UserMapper.insertUser", user);
        session.commit();
        
        session.close();
    }
}
