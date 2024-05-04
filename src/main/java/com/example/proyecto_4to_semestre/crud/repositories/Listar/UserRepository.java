package com.example.proyecto_4to_semestre.crud.repositories.Listar;

import com.example.proyecto_4to_semestre.crud.models.User;

import java.util.List;

public interface  UserRepository {
    List<User> list();
    boolean create(User user);
    boolean update(User user);
}
