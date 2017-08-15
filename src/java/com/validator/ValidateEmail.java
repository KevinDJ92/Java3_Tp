package com.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Pattern;

@FacesValidator("emailValid")
public class ValidateEmail implements Validator{
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {   
        FacesMessage msg;
        String email = (String)value;
        // The \\ in front of the . is to escape the special character therefore \\. means look for .
        String pattern = "[a-zA-Z0-9]+[_a-zA-Z0-9\\.-]*[a-zA-Z0-9]+@[a-zA-Z0-9]+(\\.[a-z]{2,4})";
   
        if(!Pattern.matches(pattern, email)){
            msg = new FacesMessage("Email invalid");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
      
            throw new ValidatorException(msg);
        }
    }  
}