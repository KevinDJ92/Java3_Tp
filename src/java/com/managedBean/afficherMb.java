package com.managedBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@Named(value = "afficherMb")
@SessionScoped
public class afficherMb implements Serializable {

    public afficherMb() {
        
    }
    
}
