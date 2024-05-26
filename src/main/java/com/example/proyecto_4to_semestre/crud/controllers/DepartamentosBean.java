package com.example.proyecto_4to_semestre.crud.controllers;

import com.example.proyecto_4to_semestre.crud.models.Ciudades;
import com.example.proyecto_4to_semestre.crud.models.Departamentos;
import com.example.proyecto_4to_semestre.crud.services.DepartamentoService;
import com.example.proyecto_4to_semestre.crud.services.DepartamentoServiceImpl;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("deparBean")
@SessionScoped
public class DepartamentosBean implements Serializable {
    private final DepartamentoService departamentoService;
    private List<Departamentos> listDepartamentos;
    private List<Ciudades> listCiudades;
    private Departamentos departamentos;
    private int selectedDepartamentoId;


    public DepartamentosBean() {
        this.departamentoService = new DepartamentoServiceImpl();

        this.listDepartamentos = departamentoService.getAllDepar();
        this.listCiudades = departamentoService.getAllCiudades();
    }

    public List<Departamentos> getListDepartamentos() {
        return listDepartamentos;
    }

    public void setListDepartamentos(List<Departamentos> listDepartamentos) {
        this.listDepartamentos = listDepartamentos;
    }

    public List<Ciudades> getListCiudades() {
        return listCiudades;
    }

    public void setListCiudades(List<Ciudades> listCiudades) {
        this.listCiudades = listCiudades;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

    public void updateCiudades() {
        if (selectedDepartamentoId != 0) {
            this.listCiudades = departamentoService.getCiudadesByDepartamento(selectedDepartamentoId);
        }
    }

    public int getSelectedDepartamentoId() {
        return selectedDepartamentoId;
    }

    public void setSelectedDepartamentoId(int selectedDepartamentoId) {
        this.selectedDepartamentoId = selectedDepartamentoId;
    }



}
