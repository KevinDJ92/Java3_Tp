package com.managedBean;

import com.entities.City;
import com.entities.User;
import com.manager.CityManager;
import com.manager.UserManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.Part;
import org.icefaces.ace.component.checkboxbuttons.CheckboxButtons;


@Named(value = "registerBean")
@SessionScoped
public class RegisterBean implements Serializable {  
    private User user;
    private User usernameInDB;
    private User emailInDB;
    
    private String registerPage = "register";
    private String loginPage = "login";
    private String redirect = "?redirect=true";
    
    private ArrayList<SelectItem> choix;
    private SelectItem selectItem;
    
    private Part image;
    
    private CheckboxButtons cbButtons;
    
    public RegisterBean() {
        user = new User();
        
        List<City> listCities = CityManager.selectAllCities();
        
        choix = new ArrayList<>();
        for (int i = 0; i < listCities.size(); i++){ 
            selectItem = new SelectItem(listCities.get(i).getIdCity(), listCities.get(i).getName());
            choix.add(selectItem);
        }        
    }  
    
    @PostConstruct
    public void init(){
        cbButtons = new CheckboxButtons();
        
        String[] values = {"3"};  
        cbButtons.setSelectedValues(values);
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

    public ArrayList<SelectItem> getChoix() {
        return choix;
    }

    public void setChoix(ArrayList<SelectItem> choix) {
        this.choix = choix;
    }
    
    public Part getImage() {
        return image;
    }

    public void setImage(Part image) {
        this.image = image;
    }

    public CheckboxButtons getCbButtons() {
        return cbButtons;
    }

    public void setCbButtons(CheckboxButtons cbButtons) {
        this.cbButtons = cbButtons;
    }
}
