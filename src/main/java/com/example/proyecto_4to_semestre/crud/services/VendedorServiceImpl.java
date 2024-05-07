package com.example.proyecto_4to_semestre.crud.services;

import com.example.proyecto_4to_semestre.crud.models.Vendedor;
import com.example.proyecto_4to_semestre.crud.repositories.Listar.VendedorRepository;
import com.example.proyecto_4to_semestre.crud.repositories.Listar.VendedorRepositoryImpl;

import java.util.List;

public class VendedorServiceImpl implements VendedorService {
    private final VendedorRepository vendedorRepository;

    public VendedorServiceImpl() {
        this.vendedorRepository = new VendedorRepositoryImpl();

    }

    @Override
    public List<Vendedor> getVendedors() {
        return vendedorRepository.list();
    }

    @Override
    public boolean createVendedor(Vendedor vendedor) {
        return vendedorRepository.create(vendedor);
    }

    @Override
    public boolean updateVendedor(Vendedor vendedor) {
        return vendedorRepository.update(vendedor);
    }

    @Override
    public Vendedor getVendedorById(String cedula) {
        return vendedorRepository.getVendedorById(cedula);
    }

    @Override
    public void deleteVendedor(String cedula) {
        vendedorRepository.delete(cedula);
    }
}
