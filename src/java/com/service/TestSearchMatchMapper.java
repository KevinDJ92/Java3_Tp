package com.service;

import com.entities.Preferences;
import com.entities.User;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class TestSearchMatchMapper {
      public static void main(String[] args) {
        SqlSession session = ConnexionBD.getSession();
         
         User user = session.selectOne("com.mapper.SearchMatchMapper.getUserPreferences", 1);  
         System.out.println("\nPreference User: " + user.getPreference());      
         Preferences preference = user.getPreference();    
         String sex_preference = null;
         
         HashMap<String, Object> parms = new HashMap<String, Object>();    
         if (sex_preference != null){ 
            parms.put("sex_preference", preference.getSex_preference());
         }
            parms.put("id_user", user.getId_user());
            parms.put("sex", user.getSex());
            parms.put("age", user.getAge());
            parms.put("min_age", preference.getMin_age());
            parms.put("max_age", preference.getMax_age());  
            
        List<User> listUser = session.selectList("com.mapper.SearchMatchMapper.getPreferredUser", parms);

        for (User users : listUser) {  
            System.out.println("\nUsername : " + users.getUsername());  
        }
      
        session.close();
     }   
}