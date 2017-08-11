package com.service;

import com.entities.User;
import org.apache.ibatis.session.SqlSession;

public class TestSelectUserByName {   
     public static void main(String[] args) {
        SqlSession session = ConnexionBD.getSession();
         
        User user = session.selectOne("com.mapper.UserMapper.getUserByName", "myusername"); 
        System.out.println("\nid : " + user.getId_user() + "\nnom : " + user.getUsername()+ "\npassword : " + user.getPassword() +"\nemail : " + user.getEmail());      
        session.close();
     }   
}