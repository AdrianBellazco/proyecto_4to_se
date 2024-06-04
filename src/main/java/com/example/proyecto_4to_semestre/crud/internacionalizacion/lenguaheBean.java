package com.example.proyecto_4to_semestre.crud.internacionalizacion;


import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Locale;

@Named("languageBean")
@SessionScoped
public class lenguaheBean implements Serializable {
    private String localCode = "es";

    public String getLocalCode() {
        return localCode;
    }
    public void setLocalCode(String localCode) {
        this.localCode = localCode;
    }

    public void changeLocale(ValueChangeEvent event){
        Locale newLocale = new Locale((String)event.getNewValue());
        FacesContext.getCurrentInstance().getViewRoot().setLocale(newLocale);
    }
}

