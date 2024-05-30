package com.example.proyecto_4to_semestre.crud.controllers;

import com.example.proyecto_4to_semestre.crud.models.Vendedor;
import com.example.proyecto_4to_semestre.crud.services.VendedorService;
import com.example.proyecto_4to_semestre.crud.services.VendedorServiceImpl;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Named("vendedorBean")
@SessionScoped
public class VendedorBean implements Serializable {
    private VendedorService vendedorService;
    private List<Vendedor> listvendedors;
    private List<Vendedor> filteredVendedores;
    private Vendedor vendedor;
    private String searchCedula;

    public VendedorBean() {
        this.vendedorService = new VendedorServiceImpl();
        this.listvendedors = vendedorService.getVendedors();
        this.filteredVendedores = listvendedors; // Inicializar la lista filtrada
        this.vendedor = new Vendedor(); // Inicializar el objeto vendedor
    }

    public String cancelarEdicion() {
        this.vendedor = new Vendedor();
        return "ParaAdministrador?faces-redirect=true";
    }

    public String createVendedor(){
        vendedorService.createVendedor(vendedor);
        this.setVendedor(new Vendedor());
        this.setListvendedors(vendedorService.getVendedors());
        this.filterVendedores(); // Actualizar la lista filtrada
        return "ParaAdministrador?faces-redirect=true";
    }

    public void deleteVendedor(String cedula){
        vendedorService.deleteVendedor(cedula);
        this.setListvendedors(vendedorService.getVendedors());
        this.filterVendedores(); // Actualizar la lista filtrada
    }


    public String updateVendedor(){
        vendedor.setFechaModificacion(new Date());
        vendedorService.updateVendedor(vendedor);
        this.setVendedor(new Vendedor());
        this.setListvendedors(vendedorService.getVendedors());
        this.filterVendedores(); // Actualizar la lista filtrada
        return "ParaAdministrador?faces-redirect=true";
    }

    public List<Vendedor> getListvendedors() {
        return listvendedors;
    }

    public void setListvendedors(List<Vendedor> listvendedors) {
        this.listvendedors = listvendedors;
    }

    public List<Vendedor> getFilteredVendedores() {
        return filteredVendedores;
    }

    public void setFilteredVendedores(List<Vendedor> filteredVendedores) {
        this.filteredVendedores = filteredVendedores;
    }

    public String getSearchCedula() {
        return searchCedula;
    }

    public void setSearchCedula(String searchCedula) {
        this.searchCedula = searchCedula;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public String vendedorDetail(String cedula){
        vendedor = vendedorService.getVendedorById(cedula);
        return "form_vendedor?faces-redirect=true";
    }

    // Método para filtrar vendedores por cédula
    public void filterVendedores() {
        if (searchCedula == null || searchCedula.isEmpty()) {
            filteredVendedores = listvendedors;
        } else {
            filteredVendedores = listvendedors.stream()
                    .filter(v -> v.getCedula().contains(searchCedula))
                    .collect(Collectors.toList());
        }
    }
}
