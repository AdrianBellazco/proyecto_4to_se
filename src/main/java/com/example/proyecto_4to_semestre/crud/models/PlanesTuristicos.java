package com.example.proyecto_4to_semestre.crud.models;

import java.util.Date;

public class PlanesTuristicos {

    private String Titulo;
    private String Descripcion;
    private int DuracionDias;
    private boolean IncluyeDesayuno;
    private boolean IncluyeAlmuerzo;
    private boolean PagarAdicionalAlimentacion;
    private double CostoDesayuno;
    private double CostoAlmuerzo;
    private double CostoComida;
    private String Estado;
    private Date FechaCreacion;
    private Date FechaModificacion;
    private String Url;

    public PlanesTuristicos(){}

    public PlanesTuristicos(String titulo, String descripcion, int duracionDias, boolean incluyeDesayuno, boolean incluyeAlmuerzo, boolean pagarAdicionalAlimentacion, double costoDesayuno, double costoAlmuerzo, double costoComida, String estado, Date fechaCreacion, Date fechaModificacion, String Url) {
        this.Titulo = titulo;
        this.Descripcion = descripcion;
        this.DuracionDias = duracionDias;
        this.IncluyeDesayuno = incluyeDesayuno;
        this.IncluyeAlmuerzo = incluyeAlmuerzo;
        this.PagarAdicionalAlimentacion = pagarAdicionalAlimentacion;
        this.CostoDesayuno = costoDesayuno;
        this.CostoAlmuerzo = costoAlmuerzo;
        this.CostoComida = costoComida;
        this.Estado = estado;
        this.FechaCreacion = fechaCreacion;
        this.FechaModificacion = fechaModificacion;
        this.Url = Url;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getDuracionDias() {
        return DuracionDias;
    }

    public void setDuracionDias(int duracionDias) {
        DuracionDias = duracionDias;
    }

    public boolean isIncluyeDesayuno() {
        return IncluyeDesayuno;
    }

    public void setIncluyeDesayuno(boolean incluyeDesayuno) {
        IncluyeDesayuno = incluyeDesayuno;
    }

    public boolean isIncluyeAlmuerzo() {
        return IncluyeAlmuerzo;
    }

    public void setIncluyeAlmuerzo(boolean incluyeAlmuerzo) {
        IncluyeAlmuerzo = incluyeAlmuerzo;
    }

    public boolean isPagarAdicionalAlimentacion() {
        return PagarAdicionalAlimentacion;
    }

    public void setPagarAdicionalAlimentacion(boolean pagarAdicionalAlimentacion) {
        PagarAdicionalAlimentacion = pagarAdicionalAlimentacion;
    }

    public double getCostoDesayuno() {
        return CostoDesayuno;
    }

    public void setCostoDesayuno(double costoDesayuno) {
        CostoDesayuno = costoDesayuno;
    }

    public double getCostoAlmuerzo() {
        return CostoAlmuerzo;
    }

    public void setCostoAlmuerzo(double costoAlmuerzo) {
        CostoAlmuerzo = costoAlmuerzo;
    }

    public double getCostoComida() {
        return CostoComida;
    }

    public void setCostoComida(double costoComida) {
        CostoComida = costoComida;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return FechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        FechaModificacion = fechaModificacion;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}


