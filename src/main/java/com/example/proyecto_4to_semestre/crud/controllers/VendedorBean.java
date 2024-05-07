package com.example.proyecto_4to_semestre.crud.controllers;

import com.example.proyecto_4to_semestre.crud.models.Vendedor;
import com.example.proyecto_4to_semestre.crud.services.VendedorService;
import com.example.proyecto_4to_semestre.crud.services.VendedorServiceImpl;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("vendedorBean")
@SessionScoped
public class VendedorBean implements Serializable {
    private final VendedorService vendedorService;
    private List<Vendedor> listvendedors;

    public VendedorBean() {
        this.vendedorService = new VendedorServiceImpl();
        this.listvendedors = vendedorService.getVendedors();
    }

    public List<Vendedor> getListvendedors() {
        return listvendedors;
    }

    public void setListvendedors(List<Vendedor> listvendedors) {
        this.listvendedors = listvendedors;
    }
}
