package com.service;

import com.entities.Preferences;
import com.entities.User;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class TestSearchMatchMapper {
      public static void main(String[] args) {
        SqlSession session = ConnexionBD.getSession();
         
        Preferences preference = session.selectOne("com.mapper.SearchMatchMapper.getUserPreferences", 1); 
        System.out.println("Passed-1");
        String sex_preference = null;
        
        // We need the user in the inner join because need to know the sex
        // so either we do two different sql request to get the user information
        // and then do a third to get the usernames    
        User user = session.selectOne("com.mapper.SearchMatchMapper.getUserSex", 1); 
        if (!preference.getSex_preference().equals("both")){
            sex_preference = preference.getSex_preference();  
        }
        
        System.out.println("Passed-2");
        HashMap<String, Object> parms = new HashMap<String, Object>();   
           if (sex_preference != null){
                parms.put("sex_preference", sex_preference);
           }
            parms.put("id_user", user.getId_user());
            parms.put("sex", user.getSex());
            parms.put("min_age", preference.getMin_age());
            parms.put("max_age", preference.getMax_age());      
            
        List<User> listUser = session.selectList("com.mapper.SearchMatchMapper.getPreferredUser", parms);

        for (User users : listUser) {  
            System.out.println("\nUsername : " + users.getUsername());  
        }
        
        session.close();
     }   
}
