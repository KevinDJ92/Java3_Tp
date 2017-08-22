package com.managedBean;

import com.entities.User;
import com.manager.UserManager;
import com.security.HashFunction;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    private User userInDB;
    private User user = new User();
    
    private boolean isUser = false;

    private String loginPage = "login";
    private String indexPage = "index";
    private String redirect = "?redirect=true";
    private String password = "";
    
    public LoginBean() {
    }
    
    public String isUserInBd() throws IOException {
        userInDB = UserManager.selectUserByName(user);  
        String namePage = loginPage; 
        
        String passwordWithSalt = "";
        
        if (userInDB != null){    
            passwordWithSalt = password + userInDB.getSalt_password();
            HashFunction hash = new HashFunction();
            
            user.setHash_password(hash.getHash(passwordWithSalt));
            
            if (user.getHash_password().equals(userInDB.getHash_password())){
               
               user = userInDB;
               isUser = true;
               namePage = indexPage + redirect;
           }
               else {
               FacesMessage msg = new FacesMessage("Incorrect password");
               msg.setSeverity(FacesMessage.SEVERITY_FATAL);
               FacesContext.getCurrentInstance().addMessage(null, msg);
           }
        }
        else {
               System.out.println("userInDB");
               FacesMessage msg = new FacesMessage("Incorrect username");
               msg.setSeverity(FacesMessage.SEVERITY_FATAL);
               FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        
        return namePage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isIsUser() {
        return isUser;
    }

    public void setIsUser(boolean isUser) {
        this.isUser = isUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
