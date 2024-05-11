package com.example.proyecto_4to_semestre.crud.repositories.Listar;

import com.example.proyecto_4to_semestre.crud.models.PlanesTuristicos;

import java.util.List;

public interface PlanRepositories {

    List<PlanesTuristicos> list();
    boolean create (PlanesTuristicos planesTuristico);
    boolean update (PlanesTuristicos planesTuristico);
    void delete (String Titulo);
    PlanesTuristicos getplandById(String Titulo);
}
