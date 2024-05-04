package com.example.proyecto_4to_semestre.crud.repositories.Listar;

import com.example.proyecto_4to_semestre.crud.models.User;
import com.example.proyecto_4to_semestre.crud.utils.Conexion_BD;

import java.sql.*;
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

    @Override
    public boolean create(User user) {
        try (Connection conn = Conexion_BD.getConnection()) {
            assert conn != null;
            PreparedStatement pst = conn.prepareStatement("INSERT INTO cliente(cedula, nombre, correo, telefono1, telefono2, fecha_nacimiento, contacto_emergencia, telefono_contacto_emergencia, fecha_creacion, fecha_modificacion, creador, contrasena) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setInt(1, user.getCedula());
            pst.setString(2, user.getNombre());
            pst.setString(3, user.getCorreo());
            pst.setString(4, user.getTelefono1());
            pst.setString(5, user.getTelefono2());
            pst.setString(6, user.getFechaNacimiento());
            pst.setString(7, user.getContactoEmergencia());
            pst.setString(8, user.getTelefonoContactoEmergencia());
            pst.setString(9, user.getFechaCreacion());
            pst.setString(10, user.getFechaModificacion());
            pst.setString(11, user.getCreador());
            pst.setString(12, user.getContrasena());
            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(User user){
        try (Connection conn = Conexion_BD.getConnection()){
            assert conn != null;
            PreparedStatement pst = conn.prepareStatement("UPDATE cliente SET nombre = ?, correo = ?, telefono1 = ?, telefono2 = ?, fecha_nacimiento = ?, contacto_emergencia = ?, telefono_contacto_emergencia = ?, fecha_creacion = ?, fecha_modificacion = ?, creador = ?, contrasena = ? WHERE cedula = ?");
            pst.setString(1, user.getNombre());
            pst.setString(2, user.getCorreo());
            pst.setString(3, user.getTelefono1());
            pst.setString(4, user.getTelefono2());
            pst.setString(5, user.getFechaNacimiento());
            pst.setString(6, user.getContactoEmergencia());
            pst.setString(7, user.getTelefonoContactoEmergencia());
            pst.setString(8, user.getFechaCreacion());
            pst.setString(9, user.getFechaModificacion());
            pst.setString(10, user.getCreador());
            pst.setString(11, user.getContrasena());
            pst.setInt(12, user.getCedula());
            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}




