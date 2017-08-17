package com.managedBean;

import com.utils.DateConverter;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.Years;

@Named(value = "dateMb")
@ViewScoped
public class DateMb implements Serializable{
    private List<String> joursListe, moisListe, anneeListe;
    private int annee = 1917;
    private int mois = 1;
    private int jour = 1;

    DateTime datetime = new DateTime();
    private int nbJour = 31;
    
    public DateMb() {
        joursListe = new ArrayList<>();
        moisListe = new ArrayList<>();
        anneeListe = new ArrayList<>();
    }
   @PostConstruct
    public void init() {
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
    }
    public void CalculAge(){
        String msgRetour = "";
        LocalDate birthday = new LocalDate(annee, mois, jour);
        LocalDate dateAujourdhui = LocalDate.now();
        
        Date date = DateConverter.localdateToDate(birthday);
        int diff = Years.yearsBetween(birthday, dateAujourdhui).getYears();
        
        msgRetour = "Birthday: " + birthday +  "\nAge: " + diff;   

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgRetour));
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
        nbJour = DateConverter.getLastDayOfMonth(mois, annee);
     
        joursListe = new ArrayList<>();
      
        for (int j = 1; j <= nbJour; j++) {
            joursListe.add("" + j);
        }
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
