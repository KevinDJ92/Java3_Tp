package com.manager;

import com.entities.User;
import com.service.ConnexionBD;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    
        public static User selectUserById(int id) {
        User user1;    
        SqlSession session = ConnexionBD.getSession();
  
        user1 = session.selectOne("com.mapper.UserMapper.getUserById", id);
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
    
        public static List<User> selectAllUser() {
        List<User> lUser = null;
        SqlSession session = ConnexionBD.getSession();
        
        lUser = session.selectList("com.mapper.UserMapper.getAllUser");
        session.close();
        return lUser;
    }
        public static User getUserPreferences(User user){
        User user1 = null;   
        SqlSession session = ConnexionBD.getSession();
  
        user = session.selectOne("com.mapper.SearchMatchMapper.getUserPreferences", user.getId_user());
        session.close();
        return user1;
        }
        
        public static List<User> getPreferredUser(HashMap param){
            SqlSession session = ConnexionBD.getSession();
            List<User> listUser = session.selectList("com.mapper.SearchMatchMapper.getPreferredUser", param);
            session.close();
            return listUser;
        }
}
