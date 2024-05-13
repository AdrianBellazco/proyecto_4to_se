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
    private PlanesTuristicos plane; // Cambiado de Plane a plane

    public PlanBean(){
        this.setPlane(new PlanesTuristicos());
        this.planService = new PlanServiceImpl();
        this.setListPlanes(planService.getAllPlanes());
    }

    public String createPlane(){
        planService.createPlan(plane);
        this.setPlane(new PlanesTuristicos());
        this.setListPlanes(planService.getAllPlanes());
        return "system?faces-redirect=true";
    }

    public String updatePlane(){
        planService.updatePlan(plane);
        this.setPlane(new PlanesTuristicos());
        this.setListPlanes(planService.getAllPlanes());
        return "system?faces-redirect=true";
    }

    public void deletePlane(String Titulo){
        planService.deletePlan(Titulo);
        this.setListPlanes(planService.getAllPlanes());
    }

    public String planDetails(String Titulo){
        plane = planService.getPlanById(Titulo);
        return "form_planesTuristicos?faces-redirect=true";
    }

    //SETTERS AND GETTERS

    public List<PlanesTuristicos> getListPlanes() {
        return listPlanes;
    }

    public void setListPlanes(List<PlanesTuristicos> listPlanes) {
        this.listPlanes = listPlanes;
    }

    // Cambiados de getPlane y setPlane
    public PlanesTuristicos getPlane() {
        return plane;
    }

    public void setPlane(PlanesTuristicos plane) {
        this.plane = plane;
    }

    public PlanService getPlanService() {
        return planService;
    }
}