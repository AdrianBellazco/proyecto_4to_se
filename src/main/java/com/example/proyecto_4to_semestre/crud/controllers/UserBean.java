package com.example.proyecto_4to_semestre.crud.controllers;

import com.example.proyecto_4to_semestre.crud.models.User;
import com.example.proyecto_4to_semestre.crud.services.UserService;
import com.example.proyecto_4to_semestre.crud.services.UserServiceImlp;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named("userBean")
@SessionScoped
public class UserBean implements Serializable {
    private final UserService userService;
    private List<User> listUsers;
    private List<User> filteredUsers; // Nueva lista para usuarios filtrados
    private String searchID; // Nueva propiedad para el ID de búsqueda
    private User user;

    public UserBean() {
        this.setUser(new User());
        this.userService = new UserServiceImlp();
        this.setListUsers(userService.getAllUsers());
        this.filteredUsers = new ArrayList<>(listUsers); // Inicializar la lista filtrada
    }

    public String createUser() {
        userService.createUser(user);
        this.setUser(new User());
        this.setListUsers(userService.getAllUsers());
        this.filteredUsers = new ArrayList<>(listUsers); // Actualizar la lista filtrada
        return "ParaVendedor?faces-redirect=true";
    }

    public String cancelarEdicion() {
        this.user = new User();
        return "ParaVendedor?faces-redirect=true";
    }

    public String updateUser() {
        user.setFechaModificacion(new Date());
        userService.updateUser(user);
        this.setUser(new User());
        this.setListUsers(userService.getAllUsers());
        this.filteredUsers = new ArrayList<>(listUsers); // Actualizar la lista filtrada
        return "ParaVendedor?faces-redirect=true";
    }

    public void deleteUser(String cedula) {
        userService.deleteUser(cedula);
        this.setListUsers(userService.getAllUsers());
        this.filteredUsers = new ArrayList<>(listUsers); // Actualizar la lista filtrada
    }

    public String userDetail(String cedula) {
        user = userService.getUserById(cedula);
        return "form?faces-redirect=true";
    }

    public void filterUsers() {
        if (searchID == null || searchID.isEmpty()) {
            filteredUsers = new ArrayList<>(listUsers);
        } else {
            filteredUsers = new ArrayList<>();
            for (User user : listUsers) {
                if (user.getCedula().contains(searchID)) {
                    filteredUsers.add(user);
                }
            }
        }
    }

    // SETTERS AND GETTERS

    public UserService getUserService() {
        return userService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<User> listUsers) {
        this.listUsers = listUsers;
    }

    public List<User> getFilteredUsers() {
        return filteredUsers;
    }

    public void setFilteredUsers(List<User> filteredUsers) {
        this.filteredUsers = filteredUsers;
    }

    public String getSearchID() {
        return searchID;
    }

    public void setSearchID(String searchID) {
        this.searchID = searchID;
    }
}
