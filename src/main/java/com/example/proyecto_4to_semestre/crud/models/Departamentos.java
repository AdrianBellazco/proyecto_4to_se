package com.example.proyecto_4to_semestre.crud.models;

public class Departamentos {
    private int idDepartamento;
    private String departamento;

    public Departamentos() {}

    public Departamentos(String departamento, int idDepartamento) {
        this.departamento = departamento;
        this.idDepartamento = idDepartamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
}


