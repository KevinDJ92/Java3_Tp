package com.manager;

import com.entities.Preferences;
import com.service.ConnexionBD;
import org.apache.ibatis.session.SqlSession;

public class PreferencesManager {
    public static void insertPreferences(Preferences preferences) {
        SqlSession session = ConnexionBD.getSession();
  
        System.out.println(" 2 id_user " + preferences.getId_user()
            + " min_age " + preferences.getMin_age() + " max_age " + preferences.getMax_age()
            + " min_height " + preferences.getMin_height() + " max_height " + preferences.getMax_height());
        
        session.insert("com.mapper.PreferencesMapper.insertPreferences", preferences);
        session.commit();
        
        session.close();
    }   
}
