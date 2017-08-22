package com.managedBean;

import com.entities.City;
import com.entities.User;

import com.manager.CityManager;
import com.manager.PreferencesManager;
import com.manager.UserManager;

import com.security.HashFunction;
import com.utils.DateFunctions;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.inject.Named;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.servlet.http.Part;

import org.icefaces.ace.component.checkboxbuttons.CheckboxButtons;
import org.joda.time.LocalDate;

@Named(value = "registerBean")
@ViewScoped
public class RegisterBean implements Serializable {  
    // Users
    private User user, usernameInDB, emailInDB;
    
    // Pages
    private String registerPage = "register", loginPage = "login", redirect = "?redirect=true";
   
    private int choixLangue;
    
    private ArrayList<SelectItem> choix;
    private SelectItem selectItem;
    
    private boolean afficherForm1, afficherForm2;
    
    private Part image;
    private CheckboxButtons cbButtons;
    private String password;
    private String charactersASCII;
    private static Random rand;
   
    // Height
    private List<String> heightList;
    private String heightWithCm;
    
    // Date
    private List<String> joursListe, moisListe, anneeListe;
    private int annee = 1917, mois = 1, jour = 1;
    private int nbJour = 31;
    
    public RegisterBean() {
        user = new User();
        heightList = new ArrayList<>();
        joursListe = new ArrayList<>();
        moisListe = new ArrayList<>();
        anneeListe = new ArrayList<>();
        
        afficherForm1 = true;
        afficherForm2 = false;
        
        List<City> listCities = CityManager.selectAllCities();
        user.setId_role(2);
        
        choix = new ArrayList<>();
        for (int i = 0; i < listCities.size(); i++){ 
            System.out.println("value: " + listCities.get(i).getId_city());
            selectItem = new SelectItem(listCities.get(i).getId_city(), listCities.get(i).getName());
            choix.add(selectItem);
        }        
    }  
    
    @PostConstruct
    public void init(){    
        // ASCII 48- 122
        for (int i = 48; i <= 122; i++){  
           charactersASCII += (char) i; 
        }
        
        for (int h = 140; h <= 200; h++) {
            heightList.add("" + h + " cm");
        }
        
        Calendar c = Calendar.getInstance();        
        
        for (int m = 1; m <= 12; m++) {
            moisListe.add("" + m);
        }
        
        for (int j = 1; j <= nbJour; j++) {
            joursListe.add("" + j);
        }

        int a = c.get(Calendar.YEAR);

        for (int y = a - 100; y <= a; y++) {
            anneeListe.add("" + y);
        }
        
        cbButtons = new CheckboxButtons();  
        String[] values = {"3"};  
        cbButtons.setSelectedValues(values);
    }
    
    public void userIsUnique() {   
        
        usernameInDB = UserManager.selectUserByName(user);     
        if (usernameInDB == null){   
           
            emailInDB = UserManager.selectUserByEmail(user);      
            if (emailInDB == null){         
                
                // Encrypt passworrs
                user.setSalt_password(generateString(charactersASCII, 8));  
                HashFunction hash = new HashFunction();
                user.setHash_password(hash.getHash(password + user.getSalt_password()));
                
                LocalDate dateOfBirth = new LocalDate(annee, mois, jour);                
               
                // BUG !!! Returns a date that is 1 day less the the original date 
                Date dateSql = DateFunctions.localdateToDate(dateOfBirth);
                user.setDate_of_birth(dateSql);
                
                user.setHeight(Integer.parseInt(heightWithCm.substring(0, 3)));        
                
                UserManager.insertUser(user);
                
                afficherForm1 = false;
                afficherForm2 = true;
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
    }
    
    public String completeRegistration(){
        PreferencesManager.insertPreferences(user.getPreferences());
  
        return loginPage + redirect;
    }
    
     public static String generateString(String characters, int length){
        rand = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++){
            text[i] = characters.charAt(rand.nextInt(characters.length()));
        }
        return new String(text);
     }
     
    public void changerLangueListener(ValueChangeEvent event){
        Locale lang = null;
        
        System.out.println(event.getNewValue());
        
        int newValue = (int) event.getNewValue();
        switch (newValue) {
            case 0:
                lang = Locale.ENGLISH;
                break;
            case 1:
                lang = Locale.FRANCE;
                break;   
        }
        
        FacesContext.getCurrentInstance().getViewRoot().setLocale(lang);
    }
    
    public void changerMonthListener(ValueChangeEvent event){   
       String monthString = event.getNewValue().toString();
       mois = Integer.valueOf(monthString);
  
      changeDays();
    }
    
    public void changerYearListener(ValueChangeEvent event){   
       String yearString = event.getNewValue().toString();
       annee = Integer.valueOf(yearString);
       
       changeDays();
    }
    
    public void changeDays(){
       nbJour = DateFunctions.getLastDayOfMonth(mois, annee);
     
       joursListe = new ArrayList<>();
      
       for (int j = 1; j <= nbJour; j++) {
            joursListe.add("" + j);
       }
    }
     
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public int getChoixLangue() {
        return choixLangue;
    }
    
    public void setChoixLangue(int choixLangue) {
        this.choixLangue = choixLangue;
    }
    
    public ArrayList<SelectItem> getChoix() {
        return choix;
    }

    public void setChoix(ArrayList<SelectItem> choix) {
        this.choix = choix;
    }

    public boolean isAfficherForm1() {
        return afficherForm1;
    }

    public void setAfficherForm1(boolean afficherForm1) {
        this.afficherForm1 = afficherForm1;
    }

    public boolean isAfficherForm2() {
        return afficherForm2;
    }

    public void setAfficherForm2(boolean afficherForm2) {
        this.afficherForm2 = afficherForm2;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getHeightList() {
        return heightList;
    }

    public void setHeighList(List<String> heightList) {
        this.heightList = heightList;
    }

    public String getHeightWithCm() {
        return heightWithCm;
    }

    public void setHeightWithCm(String heightWithCm) {
        this.heightWithCm = heightWithCm;
    }
     
    public List<String> getJoursListe() {
        return joursListe;
    }
    
    public void setJoursListe(List<String> joursListe) {
        this.joursListe = joursListe;
    }
    
    public List<String> getMoisListe() {
        return moisListe;
    }
    
    public void setMoisListe(List<String> moisListe) {
        this.moisListe = moisListe;
    }
    
    public List<String> getAnneeListe() {
        return anneeListe;
    }
    
    public void setAnneeListe(List<String> anneeListe) {
        this.anneeListe = anneeListe;
    }
    
    public int getAnnee() {
        return annee;
    }
    
    public void setAnnee(int annee) {
        this.annee = annee;
    }
    
    public int getMois() {
        return mois;
    }
    
    public void setMois(int mois) {
        this.mois = mois;
    }
    
    public int getJour() {
        return jour;
    }
    
    public void setJour(int jour) {
        this.jour = jour;
    }
}
