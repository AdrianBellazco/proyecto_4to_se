package com.example.proyecto_4to_semestre.crud.models;

import java.util.Date;

public class Tarifa{

    private String temporada;
    private String tituloPlanTuristico;
    private boolean estado;
    private Date iniciotemporada;
    private Date fintemporada;
    private Date fechaCreacion;
    private Date fechaModificacion;

    public Tarifa(){}

    public Tarifa(String temporada, String tituloPlanTuristico, boolean estado, Date iniciotemporada, Date fintemporada, Date fechaCreacion, Date fechaModificacion) {
        this.temporada = temporada;
        this.tituloPlanTuristico = tituloPlanTuristico;
        this.estado = estado;
        this.iniciotemporada = iniciotemporada;
        this.fintemporada = fintemporada;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public String getTituloPlanTuristico() {
        return tituloPlanTuristico;
    }

    public void setTituloPlanTuristico(String tituloPlanTuristico) {
        this.tituloPlanTuristico = tituloPlanTuristico;
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
}
