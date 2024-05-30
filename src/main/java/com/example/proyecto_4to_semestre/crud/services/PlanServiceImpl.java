package com.example.proyecto_4to_semestre.crud.services;

import com.example.proyecto_4to_semestre.crud.models.Activity;
import com.example.proyecto_4to_semestre.crud.models.PlanesTuristicos;
import com.example.proyecto_4to_semestre.crud.models.Tarifa;
import com.example.proyecto_4to_semestre.crud.models.puntosVisitas;
import com.example.proyecto_4to_semestre.crud.repositories.Listar.PlanRepositories;
import com.example.proyecto_4to_semestre.crud.repositories.Listar.PlanRepositoriesImpl;

import java.util.List;

public class PlanServiceImpl implements PlanService {
    private final PlanRepositories planRepositories;

    public PlanServiceImpl() {
        this.planRepositories = new PlanRepositoriesImpl();
    }

    public List<PlanesTuristicos> getAllPlanes() {
        return planRepositories.list();
    }

    public boolean createPlan(PlanesTuristicos plan, List<puntosVisitas> selectedActivities, List<Tarifa> tariffs) {
        return planRepositories.create(plan, selectedActivities, tariffs);
    }

    public boolean updatePlan(PlanesTuristicos plan, List<puntosVisitas> selectedActivities, List<Tarifa> tariffsToInsert, List<Tarifa> tariffsToUpdate, List<String> tariffsToDeleteId) {
        return planRepositories.update(plan, selectedActivities, tariffsToInsert, tariffsToUpdate, tariffsToDeleteId);
    }

    public void deletePlan(String Titulo) {
        planRepositories.delete(Titulo);
    }

    public PlanesTuristicos getPlanById(String Titulo) {
        return planRepositories.getplandById(Titulo);
    }
}

