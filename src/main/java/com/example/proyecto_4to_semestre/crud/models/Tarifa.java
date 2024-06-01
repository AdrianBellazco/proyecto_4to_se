package com.example.proyecto_4to_semestre.crud.models;

import java.util.Date;
import java.util.Objects;

public class Tarifa{

    private String temporada;
    private String id_planturistico;
    private boolean estado;
    private Date iniciotemporada;
    private Date fintemporada;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private double precio;

    public Tarifa(){}

    public Tarifa(String temporada, String id_planturistico, boolean estado, Date iniciotemporada, Date fintemporada, Date fechaCreacion, Date fechaModificacion, double precio) {
        this.temporada = temporada;
        this.id_planturistico = id_planturistico;
        this.estado = estado;
        this.iniciotemporada = iniciotemporada;
        this.fintemporada = fintemporada;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.precio = precio;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public String getId_planturistico() {
        return id_planturistico;
    }

    public void setId_planturistico(String id_planturistico) {
        this.id_planturistico = id_planturistico;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getIniciotemporada() {
        return iniciotemporada;
    }

    public void setIniciotemporada(Date iniciotemporada) {
        this.iniciotemporada = iniciotemporada;
    }

    public Date getFintemporada() {
        return fintemporada;
    }

    public void setFintemporada(Date fintemporada) {
        this.fintemporada = fintemporada;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarifa tarifa = (Tarifa) o;
        return estado == tarifa.estado &&
                Double.compare(tarifa.precio, precio) == 0 &&
                Objects.equals(temporada, tarifa.temporada) &&
                Objects.equals(iniciotemporada, tarifa.iniciotemporada) &&
                Objects.equals(fintemporada, tarifa.fintemporada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temporada, estado, precio, iniciotemporada, fintemporada);
    }
}