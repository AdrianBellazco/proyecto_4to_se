package com.example.proyecto_4to_semestre.crud.controllers;

import com.example.proyecto_4to_semestre.crud.models.PlanesTuristicos;
import com.example.proyecto_4to_semestre.crud.models.User;
import com.example.proyecto_4to_semestre.crud.services.PlanService;
import com.example.proyecto_4to_semestre.crud.services.PlanServiceImpl;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named("planBean")
@SessionScoped
public class PlanBean implements Serializable {
    private final PlanService planService;
    private List<PlanesTuristicos> listPlanes;
    private PlanesTuristicos Plane;

    public PlanBean(){
        this.setPlane(new PlanesTuristicos());
        this.planService = new PlanServiceImpl();
        this.setListPlanes(planService.getAllPlanes());
    }

    public String createPlane(){

        planService.createPlan(Plane);
        this.setPlane(new PlanesTuristicos());
        this.setListPlanes(planService.getAllPlanes());
        return "index?faces-redirect=true";
    }

    public String updatePlane(){
        planService.updatePlan(Plane);
        this.setPlane(new PlanesTuristicos());
        this.setListPlanes(planService.getAllPlanes());

        return "index?faces-redirect=true";
    }

    public void deletePlane(String Titulo){
        planService.deletePlan(Titulo);
        this.setListPlanes(planService.getAllPlanes());
    }

    public String planDetails(String Titulo){
        Plane = planService.getPlanById(Titulo);
        return "form_planesTuristicos?faces-redirect=true";
    }

    //SETTERS AND GETTERS

    public List<PlanesTuristicos> getListPlanes() {
        return listPlanes;
    }

    public void setListPlanes(List<PlanesTuristicos> listPlanes) {
        this.listPlanes = listPlanes;
    }

    public PlanesTuristicos getPlane() {
        return Plane;
    }

    public void setPlane(PlanesTuristicos plane) {
        this.Plane = plane;
    }

    public PlanService getPlanService() {
        return planService;
    }
}

