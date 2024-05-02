package com.example.proyecto_4to_semestre.crud.repositories.Listar;

import com.example.proyecto_4to_semestre.crud.models.User;
import com.example.proyecto_4to_semestre.crud.utils.Conexion_BD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoriesImpl implements UserRepository {

    @Override
    public List<User> list() {
        List<User> users = new ArrayList<>();
        try (Connection conn = Conexion_BD.getConnection()){
            assert conn != null;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cliente");
            while (rs.next()){
                User user = getUser(rs);
                users.add(user);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    private User getUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setCedula(rs.getInt("cedula"));
        user.setNombre(rs.getString("nombre"));
        user.setCorreo(rs.getString("correo"));
        user.setTelefono1(rs.getString("telefono1"));
        user.setTelefono2(rs.getString("telefono2"));
        user.setFechaNacimiento(rs.getString("fecha_nacimiento"));
        user.setContactoEmergencia(rs.getString("contacto_emergencia"));
        user.setTelefonoContactoEmergencia(rs.getString("telefono_contacto_emergencia"));
        user.setFechaCreacion(rs.getString("fecha_creacion"));
        user.setFechaModificacion(rs.getString("fecha_modificacion"));
        user.setCreador(rs.getString("creador"));
        user.setContrasena(rs.getString("contrasena"));
        return user;
    }

}




