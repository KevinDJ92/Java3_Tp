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
        Preferences preference = user.getPreference();    
        String sex_preference = null;
         
        HashMap<String, Object> parms = new HashMap<String, Object>();    
            parms.put("id_user", user.getId_user());
            parms.put("sex", user.getSex());
            parms.put("age", user.getAge());
            parms.put("height", user.getHeight());
            
            parms.put("min_age", preference.getMin_age());
            parms.put("max_age", preference.getMax_age());  
            parms.put("min_height", preference.getMin_height());
            parms.put("max_height", preference.getMax_height());  
        
            if (sex_preference != null){ 
                parms.put("sex_preference", preference.getSex_preference());
            }
            
        List<User> listUser = session.selectList("com.mapper.SearchMatchMapper.getPreferredUser", parms);

        for (User users : listUser) {  
            System.out.println("\nUsername : " + users.getUsername() + " id_Image: " + users.getId_image());  
        }
      
        session.close();
     }   
}
