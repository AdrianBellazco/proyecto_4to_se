package com.example.proyecto_4to_semestre.crud.repositories.Listar;

import com.example.proyecto_4to_semestre.crud.models.User;
import com.example.proyecto_4to_semestre.crud.utils.Conexion_BD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoriesImpl implements UserRepository{

    @Override
    public List<User> list() {
        List<User> users = new ArrayList<>();
        try (Connection conn = Conexion_BD.getConnection()){
            assert conn != null;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()){
                User user = getUser(rs);
                users.add(user);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    private User getUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setCedula(rs.getString("id"));
        user.setNombre(rs.getString("nombre"));
        user.setCorreo(rs.getString("correo"));
        user.setTelefono_1(rs.getString("telefono 1"));
        user.setTelefono_2(rs.getString("telefono 2"));
        user.setFecha_nacimiento(rs.getString("fecha de nacimiento"));
        user.setPersona_contacto(rs.getString("persona contacto"));
        user.setTelefono_contacto(rs.getString("telefono contacto"));
        user.setFechar_creacion(rs.getString("fecha de creacion"));
        user.setFechar_actualizacion(rs.getString("fecha de actualizacion"));
        user.setVendedor(rs.getString("vendedor"));









        return user;
    }

}
