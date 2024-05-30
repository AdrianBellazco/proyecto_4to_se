package com.example.proyecto_4to_semestre.crud.repositories.Listar;

import com.example.proyecto_4to_semestre.crud.models.Activity;
import com.example.proyecto_4to_semestre.crud.models.PlanesTuristicos;
import com.example.proyecto_4to_semestre.crud.models.Tarifa;
import com.example.proyecto_4to_semestre.crud.models.puntosVisitas;

import java.util.List;

public interface PlanRepositories {

    List<PlanesTuristicos> list();
    List<Tarifa> listTarifas();
    List<Activity> listActivities();
    boolean create(PlanesTuristicos touristPlan, List<puntosVisitas> selectedActivities, List<Tarifa> tariffs);
    boolean update(PlanesTuristicos touristPlan, List<puntosVisitas> selectedActivities, List<Tarifa> tariffsToInsert, List<Tarifa> tariffsToUpdate, List<String> tariffsToDeleteId);
    void delete(String titulo);
    PlanesTuristicos getplandById(String titulo);
}
