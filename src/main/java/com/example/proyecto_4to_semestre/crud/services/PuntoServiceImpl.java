package com.example.proyecto_4to_semestre.crud.services;

import com.example.proyecto_4to_semestre.crud.models.PlanesTuristicos;
import com.example.proyecto_4to_semestre.crud.models.puntosVisitas;
import com.example.proyecto_4to_semestre.crud.repositories.Listar.PlanRepositoriesImpl;
import com.example.proyecto_4to_semestre.crud.repositories.Listar.puntosVisitaRepositories;
import com.example.proyecto_4to_semestre.crud.repositories.Listar.puntosVisitaRepositoriesImpl;

import java.util.List;

public class PuntoServiceImpl implements PuntoService {
    private final puntosVisitaRepositories puntosVisita;

    public PuntoServiceImpl() {
        this.puntosVisita = new puntosVisitaRepositoriesImpl();
    }

    public List<puntosVisitas> getAllpuntos() {
        return puntosVisita.list();
    }

    public boolean createpunto(puntosVisitas punto) {
        return puntosVisita.create(punto);
    }

    public boolean updatepunto(puntosVisitas punto) {
        return puntosVisita.update(punto);
    }

    public void deletepunto(String id) {
        puntosVisita.delete(id);
    }

    public puntosVisitas getpuntoById(String id) {
        return puntosVisita.getById(id);
    }

}