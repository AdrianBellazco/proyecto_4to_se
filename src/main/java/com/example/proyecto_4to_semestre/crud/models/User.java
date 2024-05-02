package com.example.proyecto_4to_semestre.crud.models;

public class User {

        private int cedula;
        private String nombre;
        private String correo;
        private String telefono1;
        private String telefono2;
        private String fechaNacimiento;
        private String contactoEmergencia;
        private String telefonoContactoEmergencia;
        private String fechaCreacion;
        private String fechaModificacion;
        private String creador;
        private String contrasena;

        public User(){}

        public User(int cedula, String nombre, String correo, String telefono1, String telefono2, String fechaNacimiento,
                       String contactoEmergencia, String telefonoContactoEmergencia, String fechaCreacion,
                       String fechaModificacion, String creador, String contrasena) {
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

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
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

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
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
