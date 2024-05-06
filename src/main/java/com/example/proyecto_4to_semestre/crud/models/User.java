package com.example.proyecto_4to_semestre.crud.models;

import java.util.Date;

public class User {

        private String cedula;
        private String nombre;
        private String correo;
        private String telefono1;
        private String telefono2;
        private Date fechaNacimiento;
        private String contactoEmergencia;
        private String telefonoContactoEmergencia;
        private Date fechaCreacion;
        private Date fechaModificacion;
        private String creador;
        private String contrasena;

        public User(){}

        public User(String cedula, String nombre, String correo, String telefono1, String telefono2, Date fechaNacimiento,
                    String contactoEmergencia, String telefonoContactoEmergencia, Date fechaCreacion,
                    Date fechaModificacion, String creador, String contrasena) {
            this.cedula = cedula;
            this.nombre = nombre;
            this.correo = correo;
            this.telefono1 = telefono1;
            this.telefono2 = telefono2;
            this.fechaNacimiento = fechaNacimiento;
            this.contactoEmergencia = contactoEmergencia;
            this.telefonoContactoEmergencia = telefonoContactoEmergencia;
            this.fechaCreacion = fechaCreacion;
            this.fechaModificacion = fechaModificacion;
            this.creador = creador;
            this.contrasena = contrasena;
        }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getContactoEmergencia() {
        return contactoEmergencia;
    }

    public void setContactoEmergencia(String contactoEmergencia) {
        this.contactoEmergencia = contactoEmergencia;
    }

    public String getTelefonoContactoEmergencia() {
        return telefonoContactoEmergencia;
    }

    public void setTelefonoContactoEmergencia(String telefonoContactoEmergencia) {
        this.telefonoContactoEmergencia = telefonoContactoEmergencia;
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

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
