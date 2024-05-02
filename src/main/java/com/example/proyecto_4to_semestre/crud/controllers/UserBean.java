package com.example.proyecto_4to_semestre.crud.controllers;

import com.example.proyecto_4to_semestre.crud.models.User;
import com.example.proyecto_4to_semestre.crud.services.UserService;
import com.example.proyecto_4to_semestre.crud.services.UserServiceImlp;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("userBean")
@SessionScoped
public class UserBean implements Serializable {
    private final UserService userServide;
    private List<User> listUsers;

    public UserBean() {
        this.userServide = new UserServiceImlp();
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


}
