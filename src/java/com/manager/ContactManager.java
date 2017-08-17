package com.manager;

import com.entities.UserContact;
import com.entities.User;
import com.service.ConnexionBD;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
/**
 *
 * @author damon
 */
public class ContactManager {
    public static List<UserContact> GetAllContactById(User user){
        List<UserContact> lContact = null;
        SqlSession session = ConnexionBD.getSession();
        
        lContact = session.selectList("com.mapper.UserContactMapper.getUserContactById",user.getId_user());
        session.close();
        return lContact;
    }
}
