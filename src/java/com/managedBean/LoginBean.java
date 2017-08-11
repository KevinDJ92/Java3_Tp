package com.managedBean;

import com.entities.User;
import com.manager.UserManager;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    private User userInDB;
    private User user;
    
    private boolean isUser = false;

    private String loginPage = "login";
    private String indexPage = "index";
    private String redirect = "?redirect=true";
    
    public LoginBean() {
       user = new User();
    }
    
    public String isUserInBd() throws IOException {
        userInDB = UserManager.selectUserByName(user);  
        String namePage = loginPage; 
        
        if (userInDB != null){
            if (user.getPassword().equals(userInDB.getPassword())){
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
}
