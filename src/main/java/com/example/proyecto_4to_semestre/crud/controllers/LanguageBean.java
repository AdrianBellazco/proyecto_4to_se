package com.example.proyecto_4to_semestre.crud.controllers;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Locale;

@Named("languageBean")
@SessionScoped
public class LanguageBean implements Serializable {
    private String localeCode = "es";

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    public void changeLocale(ValueChangeEvent event) {
        String newLocaleValue = event.getNewValue().toString();
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(newLocaleValue));
    }
}
