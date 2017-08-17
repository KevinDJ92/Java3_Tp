package com.service;

import com.entities.User;
import org.apache.ibatis.session.SqlSession;

public class TestSelectUserByName {   
     public static void main(String[] args) {
        SqlSession session = ConnexionBD.getSession();
         
        User user = session.selectOne("com.mapper.UserMapper.getUserByName", "myusername"); 
      
        session.close();
     }   
}
