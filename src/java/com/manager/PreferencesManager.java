package com.manager;

import com.entities.Preferences;
import com.service.ConnexionBD;
import org.apache.ibatis.session.SqlSession;

public class PreferencesManager {
    public static void insertPreferences(Preferences preferences) {
        SqlSession session = ConnexionBD.getSession();
  
        session.insert("com.mapper.PreferencesMapper.insertPreferences", preferences);
        session.commit();
        
        session.close();
    }   
}
