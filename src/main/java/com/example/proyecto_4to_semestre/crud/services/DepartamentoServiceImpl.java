package com.example.proyecto_4to_semestre.crud.services;

import com.example.proyecto_4to_semestre.crud.models.Ciudades;
import com.example.proyecto_4to_semestre.crud.models.Departamentos;
import com.example.proyecto_4to_semestre.crud.repositories.Listar.DepartamentoRepositories;
import com.example.proyecto_4to_semestre.crud.repositories.Listar.DepartamentoRepositoriesImpl;

import java.util.List;

public class DepartamentoServiceImpl implements DepartamentoService {
    private final DepartamentoRepositories departamentoRepositories;

    public DepartamentoServiceImpl() {
        this.departamentoRepositories = new DepartamentoRepositoriesImpl();
    }

    public List<Departamentos> getAllDepar() {
        return departamentoRepositories.list();
    }

    public List<Ciudades> getAllCiudades() {
        return departamentoRepositories.listCiudad();
    }

    public List<Ciudades> getCiudadesByDepartamento(int departamentoId) {
        return departamentoRepositories.findCiudadesByDepartamento(departamentoId);
    }
}

