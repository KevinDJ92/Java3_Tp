package com.validator;

import java.util.Scanner;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("ageValid")
public class ValidateAge implements Validator{
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {   
        FacesMessage msg;
        
        String ageString = (String)value;
   
        if(isInteger(ageString, 10)){
            int age = Integer.parseInt(ageString);
            
            if (age > 18){
                msg = new FacesMessage("The age inputed is not a number, and therefore invalid");
                msg.setSeverity(FacesMessage.SEVERITY_WARN);
                throw new ValidatorException(msg);
            }
            else if (age < 120) {
                msg = new FacesMessage("You are a bit too old for this site");
                msg.setSeverity(FacesMessage.SEVERITY_WARN);
                throw new ValidatorException(msg);
            } 
        }
        else {
            msg = new FacesMessage("The age inputed is not a number, and therefore invalid");
            msg.setSeverity(FacesMessage.SEVERITY_FATAL);
      
            throw new ValidatorException(msg);
        }
    }
    
    // The radix in the function is the number's base system
    public static boolean isInteger(String s, int radix) {
        Scanner scanner = new Scanner(s.trim());
        if(!scanner.hasNextInt(radix)) return false;
        scanner.nextInt(radix);
    return !scanner.hasNext();
    }
}