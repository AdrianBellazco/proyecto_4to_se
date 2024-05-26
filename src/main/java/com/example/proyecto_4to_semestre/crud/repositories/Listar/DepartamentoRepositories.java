package com.example.proyecto_4to_semestre.crud.repositories.Listar;

import com.example.proyecto_4to_semestre.crud.models.Ciudades;
import com.example.proyecto_4to_semestre.crud.models.Departamentos;

import java.util.List;

public interface DepartamentoRepositories {
    List<Departamentos> list();
    List<Ciudades> listCiudad();
    List<Ciudades> findCiudadesByDepartamento(int departamentoId);
}
