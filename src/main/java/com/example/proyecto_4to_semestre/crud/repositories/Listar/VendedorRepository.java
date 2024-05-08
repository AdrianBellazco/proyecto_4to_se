package com.example.proyecto_4to_semestre.crud.repositories.Listar;

import com.example.proyecto_4to_semestre.crud.models.Vendedor;

import java.util.List;

public interface VendedorRepository {
    List<Vendedor> list();
    boolean create(Vendedor vendedor);
    boolean update(Vendedor vendedor);
    void delete(String cedula);
    Vendedor getVendedorById(String cedula);
}
