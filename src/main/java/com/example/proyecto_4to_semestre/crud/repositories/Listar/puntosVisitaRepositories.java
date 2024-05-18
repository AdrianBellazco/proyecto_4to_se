package com.example.proyecto_4to_semestre.crud.repositories.Listar;

import com.example.proyecto_4to_semestre.crud.models.puntosVisitas;

import java.util.List;

public interface puntosVisitaRepositories {
    List<puntosVisitas> list();
    boolean create(puntosVisitas puntos);
    boolean update(puntosVisitas puntos);
    void delete(String id);
    puntosVisitas getById(String id);
}
