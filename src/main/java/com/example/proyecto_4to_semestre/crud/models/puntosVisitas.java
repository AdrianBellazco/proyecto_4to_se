package com.example.proyecto_4to_semestre.crud.models;

import java.util.Date;

public class puntosVisitas {
        private String nombre;
        private String descripcion;
        private Boolean estado;
        private String departamento;
        private String ciudad;
        private Date fechaCreacion;
        private Date fechaModificacion;


        public puntosVisitas() {}

        public puntosVisitas(String nombre, String descripcion, Boolean estado, String departamento, String ciudad, Date fechaCreacion, Date fechaModificacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}


