package com.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Pattern;

@FacesValidator("passwordValid")
public class ValidatePassword implements Validator{
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        FacesMessage msg;
        String password = (String)value;
        
        String pattern = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$";
   
        if(!Pattern.matches(pattern, password)){
            msg = new FacesMessage("Password invalid");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        
            throw new ValidatorException(msg);
        }
    }  
}
