package com.example.proyecto_4to_semestre.crud.models;

public class User {
    private String cedula;
    private String nombre;
    private String correo;
    private String telefono_1;
    private String telefono_2;
    private String fecha_nacimiento;
    private String persona_contacto;
    private String telefono_contacto;
    private String fechar_creacion;
    private String fechar_actualizacion;
    private String vendedor;

    public User(){}

    public User(String cedula, String nombre,
                String correo, String telefono_1,
                String telefono_2, String fecha_nacimiento,
                String persona_contacto, String telefono_contacto,
                String fechar_creacion, String fechar_actualizacion, String vendedor) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono_1 = telefono_1;
        this.telefono_2 = telefono_2;
        this.fecha_nacimiento = fecha_nacimiento;
        this.persona_contacto = persona_contacto;
        this.telefono_contacto = telefono_contacto;
        this.fechar_creacion = fechar_creacion;
        this.fechar_actualizacion = fechar_actualizacion;
        this.vendedor = vendedor;
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

    public String getTelefono_1() {
        return telefono_1;
    }

    public void setTelefono_1(String telefono_1) {
        this.telefono_1 = telefono_1;
    }

    public String getTelefono_2() {
        return telefono_2;
    }

    public void setTelefono_2(String telefono_2) {
        this.telefono_2 = telefono_2;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getPersona_contacto() {
        return persona_contacto;
    }

    public void setPersona_contacto(String persona_contacto) {
        this.persona_contacto = persona_contacto;
    }

    public String getTelefono_contacto() {
        return telefono_contacto;
    }

    public void setTelefono_contacto(String telefono_contacto) {
        this.telefono_contacto = telefono_contacto;
    }

    public String getFechar_creacion() {
        return fechar_creacion;
    }

    public void setFechar_creacion(String fechar_creacion) {
        this.fechar_creacion = fechar_creacion;
    }

    public String getFechar_actualizacion() {
        return fechar_actualizacion;
    }

    public void setFechar_actualizacion(String fechar_actualizacion) {
        this.fechar_actualizacion = fechar_actualizacion;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
}
