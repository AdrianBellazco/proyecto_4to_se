package com.example.proyecto_4to_semestre.crud.repositories.Listar;

import com.example.proyecto_4to_semestre.crud.models.User;
import com.example.proyecto_4to_semestre.crud.utils.Conexion_BD;
import java.sql.Date;
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
        user.setCedula(rs.getString("cedula"));
        user.setNombre(rs.getString("nombre"));
        user.setCorreo(rs.getString("correo"));
        user.setTelefono1(rs.getString("telefono1"));
        user.setTelefono2(rs.getString("telefono2"));
        user.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
        user.setContactoEmergencia(rs.getString("contacto_emergencia"));
        user.setTelefonoContactoEmergencia(rs.getString("telefono_contacto_emergencia"));
        user.setFechaCreacion(rs.getDate("fecha_creacion")); // Cambio aquí
        user.setFechaModificacion(rs.getDate("fecha_modificacion")); // Cambio aquí
        user.setCreador(rs.getString("creador"));
        user.setContrasena(rs.getString("contrasena"));
        return user;
    }



    @Override
    public boolean create(User user) {
        try (Connection conn = Conexion_BD.getConnection()) {
            assert conn != null;
            java.util.Date currentDate = new java.util.Date();

            PreparedStatement pst = conn.prepareStatement(
                    "INSERT INTO cliente(cedula, nombre, correo, telefono1, telefono2, fecha_nacimiento, contacto_emergencia, telefono_contacto_emergencia, fecha_creacion, fecha_modificacion, creador) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            pst.setString(1, user.getCedula());
            pst.setString(2, user.getNombre());
            pst.setString(3, user.getCorreo());
            pst.setString(4, user.getTelefono1());
            pst.setString(5, user.getTelefono2());
            pst.setDate(6, new java.sql.Date(user.getFechaNacimiento().getTime())); // Fecha de nacimiento
            pst.setString(7, user.getContactoEmergencia());
            pst.setString(8, user.getTelefonoContactoEmergencia());
            pst.setDate(9, new java.sql.Date(currentDate.getTime())); // Fecha de creación
            pst.setDate(10, new java.sql.Date(currentDate.getTime())); // Fecha de modificación
            pst.setString(11, user.getCreador());

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
            pst.setDate(5, new java.sql.Date(user.getFechaNacimiento().getTime())); // Convertir String a Date
            pst.setString(6, user.getContactoEmergencia());
            pst.setString(7, user.getTelefonoContactoEmergencia());
            pst.setDate(8, new java.sql.Date(user.getFechaCreacion().getTime())); // Convertir String a Date
            pst.setDate(9, new java.sql.Date(user.getFechaModificacion().getTime())); // Convertir String a Date
            pst.setString(10, user.getCreador());
            pst.setString(11, user.getContrasena());
            pst.setString(12, user.getCedula());
            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(String cedula){
        try (Connection conn = Conexion_BD.getConnection()){
            assert conn != null;
            PreparedStatement pst = conn.prepareStatement("DELETE FROM cliente WHERE cedula = ?");
            pst.setString(1, cedula);
            pst.executeUpdate();
            pst.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(String cedula){
        User user = null;
        try (Connection conn = Conexion_BD.getConnection()){
            assert conn != null;
            PreparedStatement pst = conn.prepareStatement("SELECT u.* FROM cliente as u WHERE u.cedula = ?");
            pst.setString(1, cedula);
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                user = getUser(rs);
            }
            rs.close();
            pst.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}




