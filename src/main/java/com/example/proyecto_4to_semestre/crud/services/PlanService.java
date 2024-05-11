package com.example.proyecto_4to_semestre.crud.services;

import com.example.proyecto_4to_semestre.crud.models.PlanesTuristicos;

import java.util.List;

public interface PlanService {
    List<PlanesTuristicos> getAllPlanes();
    PlanesTuristicos getPlanById(String Titulo);
    boolean createPlan(PlanesTuristicos plan);
    boolean updatePlan(PlanesTuristicos plan);
    void deletePlan(String Titulo);
}
