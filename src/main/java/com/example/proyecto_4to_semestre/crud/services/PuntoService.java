package com.example.proyecto_4to_semestre.crud.services;

import com.example.proyecto_4to_semestre.crud.models.PlanesTuristicos;
import com.example.proyecto_4to_semestre.crud.models.puntosVisitas;

import java.util.List;

public interface PuntoService{
    List<puntosVisitas> getAllpuntos();
    puntosVisitas getpuntoById(String id);
    boolean createpunto(puntosVisitas punto);
    boolean updatepunto(puntosVisitas punto);
    void deletepunto(String id);
}
