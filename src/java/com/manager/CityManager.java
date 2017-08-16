package com.manager;

import com.entities.City;
import com.service.ConnexionBD;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class CityManager {
        public static List<City> selectAllCities() {
        City city;    
        SqlSession session = ConnexionBD.getSession();
  
        List<City> listCities = session.selectList("com.mapper.CityMapper.getAllCities");
        session.close();	  
        
        return listCities;
    }
}
