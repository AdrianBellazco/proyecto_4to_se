package com.example.proyecto_4to_semestre.crud.controllers;

import com.example.proyecto_4to_semestre.crud.models.Activity;
import com.example.proyecto_4to_semestre.crud.models.PlanesTuristicos;
import com.example.proyecto_4to_semestre.crud.models.Tarifa;
import com.example.proyecto_4to_semestre.crud.models.puntosVisitas;
import com.example.proyecto_4to_semestre.crud.services.PlanService;
import com.example.proyecto_4to_semestre.crud.services.PlanServiceImpl;
import com.example.proyecto_4to_semestre.crud.services.PuntoService;
import com.example.proyecto_4to_semestre.crud.services.PuntoServiceImpl;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("planBean")
@SessionScoped
public class PlanBean implements Serializable {
    private final PlanService planService;
    private final PuntoService puntoService;

    private List<PlanesTuristicos> listPlanes;
    private List<Tarifa> listTarifas;
    private List<puntosVisitas> listActivities;
    private List<puntosVisitas> selectedActivities;

    private PlanesTuristicos plane;
    private Activity activity;
    private Tarifa tarifa;

    public String cancelarEdicion() {
        this.plane = new PlanesTuristicos();
        this.activity = new Activity();
        return "system?faces-redirect=true";
    }

    public PlanBean() {
        this.puntoService = new PuntoServiceImpl();
        this.planService = new PlanServiceImpl();
        this.setPlane(new PlanesTuristicos());
        this.setActivity(new Activity());
        this.setTarifa(new Tarifa());
        this.setListActivities(this.puntoService.getAllpuntos());
        this.setListPlanes(planService.getAllPlanes());
        this.listTarifas = new ArrayList<>();
    }

    public String createPlane() {
//        List<Tarifa> tariffs = new ArrayList<>();
        //planService.createPlan(plane, selectedActivities, tariffs);
       // this.setPlane(new PlanesTuristicos());
       // this.setListPlanes(planService.getAllPlanes());
        return "system?faces-redirect=true";
    }

    public String updatePlane() {
        List<Activity> selectedActivities = new ArrayList<>();
        List<Tarifa> tariffsToInsert = new ArrayList<>();
        List<Tarifa> tariffsToUpdate = new ArrayList<>();
        List<String> tariffsToDeleteId = new ArrayList<>();
        planService.updatePlan(plane, selectedActivities, tariffsToInsert, tariffsToUpdate, tariffsToDeleteId);
        this.setPlane(new PlanesTuristicos());
        this.setListPlanes(planService.getAllPlanes());
        return "system?faces-redirect=true";
    }

    public void deletePlane(String Titulo) {
        planService.deletePlan(Titulo);
        this.setListPlanes(planService.getAllPlanes());
    }

    public String planDetails(String Titulo) {
        plane = planService.getPlanById(Titulo);
        return "form_planesTuristicos?faces-redirect=true";
    }

    public void addTarifa() {
        if (listTarifas == null) {
            listTarifas = new ArrayList<>();
        }
        listTarifas.add(new Tarifa());
    }

    public void removeTarifa(Tarifa tarifa) {
        if (listTarifas != null) {
            System.out.println("Tarifa eliminada: " + tarifa);
            listTarifas.remove(tarifa);
            System.out.println("Lista de tarifas después de la eliminación: " + listTarifas);

        }
    }
    public void refreshListActivities() {
        this.setListActivities(this.puntoService.getAllpuntos());
    }



    //SETTERS AND GETTERS

    public List<PlanesTuristicos> getListPlanes() {
        return listPlanes;
    }

    public void setListPlanes(List<PlanesTuristicos> listPlanes) {
        this.listPlanes = listPlanes;
    }

    public PlanesTuristicos getPlane() {
        return plane;
    }

    public void setPlane(PlanesTuristicos plane) {
        this.plane = plane;
    }

    public PlanService getPlanService() {
        return planService;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public List<Tarifa> getListTarifas() {
        return listTarifas;
    }

    public void setListTarifas(List<Tarifa> listTarifas) {
        this.listTarifas = listTarifas;
    }

    public List<puntosVisitas> getListActivities() {
        return listActivities;
    }

    public void setListActivities(List<puntosVisitas> listActivities) {
        this.listActivities = listActivities;
    }

    public List<puntosVisitas> getSelectedActivities() {
        return selectedActivities;
    }

    public void setSelectedActivities(List<puntosVisitas> selectedActivities) {
        this.selectedActivities = selectedActivities;
    }
}
