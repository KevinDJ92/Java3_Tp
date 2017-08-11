package com.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ConnexionBD {
        public static SqlSession getSession (){
         SqlSession session = null;
            try {
                String resource = "com/service/myBatis.xml";
                InputStream input = Resources.getResourceAsStream(resource);
                SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(input);
                ssf.getConfiguration().addMappers("mapper");
                session = ssf.openSession();           
        } catch (IOException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
         return session;
    }
}
