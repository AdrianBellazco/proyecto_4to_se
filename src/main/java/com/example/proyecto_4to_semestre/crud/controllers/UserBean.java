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
    private final UserService userServide;
    private List<User> listUsers;
    private User user;

    public UserBean() {
        this.setUser(new User());
        this.userServide = new UserServiceImlp();
        this.setListUsers(userServide.getAllUsers());

    }

    public List<User> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<User> listUsers) {
        this.listUsers = listUsers;
    }

    public UserService getUserServide() {
        return userServide;
    }

    public String createUser() {
        if (user.getFechaNacimiento() == null) {

            user.setFechaNacimiento(new Date());
        }
        userServide.createUser(user);
        this.setUser(new User());
        this.setListUsers(userServide.getAllUsers());
        return "index?faces-redirect=true";
    }

    public String updateUser() {
        userServide.updateUser(user);
        this.setUser(new User());
        this.setListUsers(userServide.getAllUsers());

        return "index?faces-redirect=true";
    }

    public void deleteUser(String cedula){
        userServide.deleteUser(cedula);
        this.setListUsers(userServide.getAllUsers());
    }

    public String userDetail(String cedula){
        user = userServide.getUserById(cedula);
        return "form?faces-redirect=true";
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
