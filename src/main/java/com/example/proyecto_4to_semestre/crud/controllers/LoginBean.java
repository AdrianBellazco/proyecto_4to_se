package com.example.proyecto_4to_semestre.crud.controllers;

import com.example.proyecto_4to_semestre.crud.models.Vendedor;
import com.example.proyecto_4to_semestre.crud.services.VendedorService;
import com.example.proyecto_4to_semestre.crud.services.VendedorServiceImpl;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

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
            System.out.println("Ingreso correctamente");
            return "HTML/ParaVendedor?faces-redirect=true";
        } else if ("admin".equals(username) && "123".equals(password)) {
            return "HTML/ParaAdministrador?faces-redirect=true";
        } else {
            System.out.println("Credenciales inválidas");
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credenciales inválidas", null));
            return null; // No redirige en caso de error
        }
    }

    public void close() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, "/index.xhtml");
    }

    public boolean esAdministrador() {
        return "admin".equals(username) && "123".equals(password);
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
