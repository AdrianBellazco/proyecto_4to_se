package com.example.proyecto_4to_semestre.crud.controllers;

import com.example.proyecto_4to_semestre.crud.models.User;
import com.example.proyecto_4to_semestre.crud.models.Vendedor;
import com.example.proyecto_4to_semestre.crud.services.VendedorService;
import com.example.proyecto_4to_semestre.crud.services.VendedorServiceImpl;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named("vendedorBean")
@SessionScoped
public class VendedorBean implements Serializable {
    private final VendedorService vendedorService;
    private List<Vendedor> listvendedors;
    private Vendedor vendedor;

    public VendedorBean() {
        this.vendedorService = new VendedorServiceImpl();
        this.listvendedors = vendedorService.getVendedors();
        this.vendedor = new Vendedor(); // Inicializar el objeto vendedor
    }


    public String createVendedor(){
        if (vendedor.getFecha_nacimiento() == null) {
            vendedor.setFecha_nacimiento(new Date());
        }
        vendedorService.createVendedor(vendedor);
        this.setVendedor(new Vendedor());
        this.setListvendedors(vendedorService.getVendedors());
        return "index?faces-redirect=true";
    }

    public void delatevendedor(String cedula){
        vendedorService.deleteVendedor(cedula);
        this.setListvendedors(vendedorService.getVendedors());
    }


    public String updateVendedor(){
        vendedorService.updateVendedor(vendedor);
        this.setVendedor(new Vendedor());
        this.setListvendedors(vendedorService.getVendedors());
        return "index?faces-redirect=true";
    }


    public List<Vendedor> getListvendedors() {
        return listvendedors;
    }

    public String vendedorDetail(String cedula){
        vendedor = vendedorService.getVendedorById(cedula);
        return "form?faces-redirect=true";

    }

    public void setListvendedors(List<Vendedor> listvendedors) {
        this.listvendedors = listvendedors;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
