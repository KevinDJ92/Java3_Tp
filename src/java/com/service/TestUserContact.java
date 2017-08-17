/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entities.UserContact;
import com.entities.User;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class TestUserContact {

    public static void main(String[] args) {
        ArrayList<User> lUser = new ArrayList<>();
        SqlSession session = ConnexionBD.getSession();
        List<UserContact> lContact =  session.selectList("com.mapper.UserContactMapper.getUserContactById", 1);
        
        for(UserContact user : lContact){
            if(user.getId_user() != 1){
                System.out.println("id_user "+user.getId_user());
                lUser.add(session.selectOne("com.mapper.UserMapper.getUserById", user.getId_user()));
                
            }
            else{
                System.out.println("id_contact "+user.getId_contact());
                lUser.add(session.selectOne("com.mapper.UserMapper.getUserById", user.getId_contact()));
            }
        }
        for(User user : lUser){
            System.out.println("id : " + user.getId_user() + " username : " + user.getUsername());
        }
    }
    
}
