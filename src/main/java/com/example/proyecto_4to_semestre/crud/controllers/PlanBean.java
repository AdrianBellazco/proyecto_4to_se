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
    private List<PlanesTuristicos> filteredPlanes; // Nueva lista para los planes filtrados
    private List<Tarifa> listTarifas;
    private List<puntosVisitas> listActivities;
    private List<puntosVisitas> selectedActivities;

    private PlanesTuristicos plane;
    private Activity activity;
    private Tarifa tarifa;
    private String searchID; // Nueva propiedad para el ID de búsqueda

    private PlanesTuristicos selectedPlan;


    public PlanBean() {
        this.puntoService = new PuntoServiceImpl();
        this.planService = new PlanServiceImpl();
        this.setPlane(new PlanesTuristicos());
        this.setActivity(new Activity());
        this.setTarifa(new Tarifa());
        this.setListActivities(this.puntoService.getAllpuntos());
        this.setListPlanes(planService.getAllPlanes());
        this.filteredPlanes = new ArrayList<>(listPlanes); // Inicializar la lista filtrada
        this.listTarifas = new ArrayList<>();
    }

    public String cancelarEdicion() {
        this.plane = new PlanesTuristicos();
        this.activity = new Activity();
        return "ParaAdministrador?faces-redirect=true";
    }

    public String createPlane() {
        planService.createPlan(plane, selectedActivities, listTarifas);
        this.setPlane(new PlanesTuristicos());
        this.setListPlanes(planService.getAllPlanes());
        this.filteredPlanes = new ArrayList<>(listPlanes); // Actualizar la lista filtrada
        return "ParaAdministrador?faces-redirect=true";
    }

    public String updatePlane() {
        List<puntosVisitas> selectedActivities = new ArrayList<>();
        List<Tarifa> tariffsToInsert = new ArrayList<>();
        List<Tarifa> tariffsToUpdate = new ArrayList<>();
        List<String> tariffsToDeleteId = new ArrayList<>();
        planService.updatePlan(plane, selectedActivities, tariffsToInsert, tariffsToUpdate, tariffsToDeleteId);
        this.setPlane(new PlanesTuristicos());
        this.setListPlanes(planService.getAllPlanes());
        this.filteredPlanes = new ArrayList<>(listPlanes); // Actualizar la lista filtrada
        return "ParaAdministrador?faces-redirect=true";
    }

    public void deletePlane(String Titulo) {
        planService.deletePlan(Titulo);
        this.setListPlanes(planService.getAllPlanes());
        this.filteredPlanes = new ArrayList<>(listPlanes); // Actualizar la lista filtrada
    }

    public String planDetails(String Titulo) {
        plane = planService.getPlanById(Titulo);
        return "form_planesTuristicos?faces-redirect=true";
    }


    public void planDetails2(String id) {
        selectedPlan = planService.getPlanById(id);
    }

    public PlanesTuristicos getSelectedPlan() {
        return selectedPlan;
    }

    public void setSelectedPlan(PlanesTuristicos selectedPlan) {
        this.selectedPlan = selectedPlan;
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

    public void filterPlanes() {
        if (searchID == null || searchID.isEmpty()) {
            filteredPlanes = new ArrayList<>(listPlanes);
        } else {
            filteredPlanes = new ArrayList<>();
            for (PlanesTuristicos plan : listPlanes) {
                if (plan.getID().contains(searchID)) {
                    filteredPlanes.add(plan);
                }
            }
        }
    }

    // SETTERS AND GETTERS

    public List<PlanesTuristicos> getListPlanes() {
        return listPlanes;
    }

    public void setListPlanes(List<PlanesTuristicos> listPlanes) {
        this.listPlanes = listPlanes;
    }

    public List<PlanesTuristicos> getFilteredPlanes() {
        return filteredPlanes;
    }

    public void setFilteredPlanes(List<PlanesTuristicos> filteredPlanes) {
        this.filteredPlanes = filteredPlanes;
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

    public String getSearchID() {
        return searchID;
    }

    public void setSearchID(String searchID) {
        this.searchID = searchID;
    }



}
