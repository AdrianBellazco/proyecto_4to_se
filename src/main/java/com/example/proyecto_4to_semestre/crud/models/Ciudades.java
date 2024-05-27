package com.example.proyecto_4to_semestre.crud.models;

public class Ciudades {
    private int idCiudad;
    private String nombreCiudad;
    private int idDepartamento;

    public Ciudades(){}

    public Ciudades(int idCiudad, String nombreCiudad, int idDepartamento) {
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
        this.idDepartamento = idDepartamento;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
}
