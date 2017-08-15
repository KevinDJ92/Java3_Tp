package com.managedBean;

import com.entities.User;
import com.manager.UserManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

@Named(value = "registerBean")
@SessionScoped
public class RegisterBean implements Serializable {  
    private User user;
    private User usernameInDB;
    private User emailInDB;
    
    private String registerPage = "register";
    private String loginPage = "login";
    private String redirect = "?redirect=true";
    private Part image;
    
    public RegisterBean() {
        user = new User();
    }

    public String userIsUnique() {
        String namePage = registerPage; 
        
        usernameInDB = UserManager.selectUserByName(user);  
        if (usernameInDB == null){   
            emailInDB = UserManager.selectUserByEmail(user);
            
            if (emailInDB == null){
                UserManager.insertUser(user);
                namePage = loginPage + redirect;
            }
            else {
               FacesMessage msg = new FacesMessage("Email is not unique");
               msg.setSeverity(FacesMessage.SEVERITY_FATAL);
               FacesContext.getCurrentInstance().addMessage(null, msg);
            
            }
        }
        else {
               FacesMessage msg = new FacesMessage("Username is not unique");
               msg.setSeverity(FacesMessage.SEVERITY_FATAL);
               FacesContext.getCurrentInstance().addMessage(null, msg);
        }  
        
        return namePage;
    }
    
     public void doUpload(){
        try {
            InputStream in = image.getInputStream();
            
            byte[] imageBytes = null;
          
           File f = new File("/Users/Kevin/Documents/Java3_tp/web/upload/" + image.getSubmittedFileName());
           f.createNewFile();
           
           FileOutputStream out = new FileOutputStream(f);
           byte[] buffer = new byte[1024];
           int length;
           
           while ((length = in.read(buffer)) > 0){
               out.write(buffer, 0, length);
           }
           
           out.close();
           in.close();
           
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Part getImage() {
        return image;
    }

    public void setImage(Part image) {
        this.image = image;
    }
}
