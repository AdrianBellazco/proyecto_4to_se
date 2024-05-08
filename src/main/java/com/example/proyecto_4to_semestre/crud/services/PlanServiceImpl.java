package com.example.proyecto_4to_semestre.crud.services;


import com.example.proyecto_4to_semestre.crud.models.PlanesTuristicos;
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

    public boolean createPlan(PlanesTuristicos plan) {
        return planRepositories.create(plan);
    }

    public boolean updatePlan(PlanesTuristicos plan) {
        return planRepositories.update(plan);
    }

    public void deletePlan(String Titulo) {
        planRepositories.delete(Titulo);
    }

    public PlanesTuristicos getPlanById(String Titulo) {
        return planRepositories.getplandById(Titulo);
    }

}
