package com.example.proyecto_4to_semestre.crud.services;

import com.example.proyecto_4to_semestre.crud.models.Activity;
import com.example.proyecto_4to_semestre.crud.models.PlanesTuristicos;
import com.example.proyecto_4to_semestre.crud.models.Tarifa;

import java.util.List;

public interface PlanService {
    List<PlanesTuristicos> getAllPlanes();
    PlanesTuristicos getPlanById(String titulo);
    boolean createPlan(PlanesTuristicos plan, List<Activity> selectedActivities, List<Tarifa> tariffs);
    boolean updatePlan(PlanesTuristicos plan, List<Activity> selectedActivities, List<Tarifa> tariffsToInsert, List<Tarifa> tariffsToUpdate, List<String> tariffsToDeleteId);
    void deletePlan(String titulo);
}
