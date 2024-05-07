package com.example.proyecto_4to_semestre.crud.repositories.Listar;

import com.example.proyecto_4to_semestre.crud.models.Vendedor;

import java.util.List;

public interface VendedorRepository {
    List<Vendedor> list();

    void delete(String cedula);
    boolean create(Vendedor vendedor);
    boolean update(Vendedor vendedor);
    Vendedor getVendedorById(String cedula);
}
