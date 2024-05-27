package com.example.proyecto_4to_semestre.crud.services;

import com.example.proyecto_4to_semestre.crud.models.Ciudades;
import com.example.proyecto_4to_semestre.crud.models.Departamentos;

import java.util.List;

public interface DepartamentoService {
    List<Departamentos> getAllDepar();
    List<Ciudades> getAllCiudades();
    List<Ciudades> getCiudadesByDepartamento(int departamentoId);
}


