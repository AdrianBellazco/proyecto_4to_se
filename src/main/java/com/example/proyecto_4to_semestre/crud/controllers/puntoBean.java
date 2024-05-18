package com.example.proyecto_4to_semestre.crud.controllers;

import com.example.proyecto_4to_semestre.crud.models.puntosVisitas;
import com.example.proyecto_4to_semestre.crud.services.PuntoService;
import com.example.proyecto_4to_semestre.crud.services.PuntoServiceImpl;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.*;

@Named("puntoBean")
@SessionScoped
public class puntoBean implements Serializable {
    private final PuntoService puntoService;
    private List<puntosVisitas> ListPuntos;
    private puntosVisitas puntoVisitas;

    public puntoBean() {
        this.setPuntoVisitas(new puntosVisitas());
        this.puntoService = new PuntoServiceImpl();
        this.setListPuntos(puntoService.getAllpuntos());
    }

    public String createPunto(){


        puntoVisitas.setIdpunto(generarCodigoUnico());
        puntoService.createpunto(puntoVisitas);
        this.setPuntoVisitas(new puntosVisitas());
        this.setListPuntos(puntoService.getAllpuntos());
        return "system?faces-redirect=true";
    }

    public String cancelarEdicion(){
        this.puntoVisitas = new puntosVisitas();
        return "system?faces-redirect=true";
    }

    public String updatePunto(){
        puntoVisitas.setFechaModificacion(new Date());
        puntoService.updatepunto(puntoVisitas);
        this.setPuntoVisitas(new puntosVisitas());
        this.setListPuntos(puntoService.getAllpuntos());
        return "system?faces-redirect=true";
    }

    public void deletepunto(String id){
        puntoService.deletepunto(id);
        this.setListPuntos(puntoService.getAllpuntos());
    }

    public String puntoDetail(String id){
        puntoVisitas = puntoService.getpuntoById(id);
        return "form_punto?faces-redirect=true";
    }


    //SETTERS AND GETTERS
    public PuntoService getPuntoService() {
        return puntoService;
    }

    public List<puntosVisitas> getListPuntos() {
        return ListPuntos;
    }

    public void setListPuntos(List<puntosVisitas> listPuntos) {
        ListPuntos = listPuntos;
    }

    public puntosVisitas getPuntoVisitas() {
        return puntoVisitas;
    }

    public void setPuntoVisitas(puntosVisitas puntoVisitas) {
        this.puntoVisitas = puntoVisitas;
    }
    public String generarCodigoUnico() {
        Set<String> codigosExistentes = new HashSet<>();
        for (puntosVisitas punto : ListPuntos) {
            codigosExistentes.add(punto.getIdpunto());
        }

        String nuevoCodigo;
        do {
            nuevoCodigo = generarCodigo();
        } while (codigosExistentes.contains(nuevoCodigo));

        return nuevoCodigo;
    }

    // Generar un código aleatorio
    public static String generarCodigo() {
        Random random = new Random();
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";

        char letra1 = letras.charAt(random.nextInt(letras.length()));
        char numero1 = numeros.charAt(random.nextInt(numeros.length()));
        char letra2 = letras.charAt(random.nextInt(letras.length()));
        char numero2 = numeros.charAt(random.nextInt(numeros.length()));

        return "" + letra1 + numero1 + letra2 + numero2;
    }
}