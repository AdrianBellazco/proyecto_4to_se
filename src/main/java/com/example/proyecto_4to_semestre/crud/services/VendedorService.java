package com.example.proyecto_4to_semestre.crud.services;

import com.example.proyecto_4to_semestre.crud.models.Vendedor;

import java.util.List;

public interface VendedorService {
    List<Vendedor> getVendedors();
    Vendedor getVendedorByUser(String nombre);
    Vendedor getVendedorById(String vendedor);
    boolean createVendedor(Vendedor vendedor);
    boolean updateVendedor(Vendedor vendedor);
    void deleteVendedor(String cedula);

}
