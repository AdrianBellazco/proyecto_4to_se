package com.example.proyecto_4to_semestre.crud.services;

import com.example.proyecto_4to_semestre.crud.models.User;
import com.example.proyecto_4to_semestre.crud.repositories.Listar.UserRepositoriesImpl;
import com.example.proyecto_4to_semestre.crud.repositories.Listar.UserRepository;

import java.util.List;

public class UserServiceImlp implements UserService{
    private final UserRepository userRepository;

    public UserServiceImlp() {
        this.userRepository = new UserRepositoriesImpl();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.list();
    }

}
