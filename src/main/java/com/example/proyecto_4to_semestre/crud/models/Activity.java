package com.example.proyecto_4to_semestre.crud.models;

public class Activity {
    private String idTouristPlan;
    private String idPuntosVisita;


    public Activity(){}

    public Activity(String idTouristPlan, String idPuntosVisita) {
        this.idTouristPlan = idTouristPlan;
        this.idPuntosVisita = idPuntosVisita;
    }

    public String getIdTouristPlan() {
        return idTouristPlan;
    }

    public void setIdTouristPlan(String idTouristPlan) {
        this.idTouristPlan = idTouristPlan;
    }

    public String getIdPuntosVisita() {
        return idPuntosVisita;
    }

    public void setIdPuntosVisita(String idPuntosVisita) {
        this.idPuntosVisita = idPuntosVisita;
    }
}
