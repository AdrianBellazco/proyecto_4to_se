package com.example.proyecto_4to_semestre.crud.services;

import com.example.proyecto_4to_semestre.crud.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    boolean createUser(User user);
    boolean updateUser(User user);

}
