package com.example.proyecto_4to_semestre.crud.controllers;

import com.example.proyecto_4to_semestre.crud.models.PlanesTuristicos;
import com.example.proyecto_4to_semestre.crud.models.Vendedor;
import com.example.proyecto_4to_semestre.crud.services.VendedorService;
import com.example.proyecto_4to_semestre.crud.services.VendedorServiceImpl;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.application.NavigationHandler;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpSession;

import java.sql.SQLOutput;
import java.util.List;

@Named("loginBean")
@RequestScoped
public class LoginBean {
    private String username;
    private String password;
    private VendedorService vendedorService;
    private List<Vendedor> vendedors;
    public LoginBean() {
        this.vendedorService = new VendedorServiceImpl();
    }

    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        Vendedor vendedor = vendedorService.getVendedorByUser(username);
        if (vendedor != null && vendedor.getPassword().equals(password)) {
            // Usuario autenticado, redirigir a la página "system"
            System.out.println("Ingreso correctamente");
            return "HTML/ParaVendedor?faces-redirect=true";
        } else {
            if ("admin".equals(username) && "123".equals(password)) {
                return "HTML/ParaAdministrador?faces-redirect=true";
            }
        }
        // Credenciales inválidas, mostrar mensaje de error
        System.out.println("Nom");
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credenciales inválidas", null));
        return null;
    }

    public void close(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        NavigationHandler handler = facesContext.getApplication().getNavigationHandler();
        handler.handleNavigation(facesContext, null, "/index.xhtml");
    }

    public boolean esAdministrador() {
        if (getUsername() == null) {
            return false; // Si el nombre de usuario es nulo, no se puede determinar si es un administrador
        }
        return "admin".equals(getUsername()) && "123".equals(getPassword());
    }






    // Getters y setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public VendedorService getVendedorService() {
        return vendedorService;
    }

    public void setVendedorService(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }
}
