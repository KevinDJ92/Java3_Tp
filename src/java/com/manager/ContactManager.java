package com.manager;

import com.entities.UserContact;
import com.entities.User;
import com.service.ConnexionBD;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class ContactManager {
    public static List<UserContact> GetAllContactById(int id){
        List<UserContact> lContact = null;
        SqlSession session = ConnexionBD.getSession();
        
        lContact = session.selectList("com.mapper.UserContactMapper.getUserContactById", id);
        session.close();
        return lContact;
    }
}
