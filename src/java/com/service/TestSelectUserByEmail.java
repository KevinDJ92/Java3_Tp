package com.service;

import com.entities.User;
import org.apache.ibatis.session.SqlSession;

public class TestSelectUserByEmail {
    public static void main(String[] args) {
        SqlSession session = ConnexionBD.getSession();
         
        User user = session.selectOne("com.mapper.UserMapper.getUserByEmail", "kevin@hotmail.com"); 
        System.out.println("\nid : " +user.getId_user() + "\nnom : " + user.getUsername()+ "\npassword : " + user.getPassword() +"\nemail : " + user.getEmail());      
       
        String characters = "";
        
        for (int i = 48; i <= 90; i++){  
            characters += String.valueOf(i); 
        }
        
        System.out.println("List of characters: " + characters);
        
        session.close();
     }   
}
