package com.example.proyecto_4to_semestre.crud.repositories.Listar;

import com.example.proyecto_4to_semestre.crud.models.User;
import com.example.proyecto_4to_semestre.crud.models.Vendedor;
import com.example.proyecto_4to_semestre.crud.utils.Conexion_BD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendedorRepositoryImpl implements VendedorRepository {

    @Override
    public List<Vendedor> list() {
        List<Vendedor> vendedores = new ArrayList<Vendedor>();
        try (Connection conn = Conexion_BD.getConnection()){
            assert conn != null;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM vendedor");
            while(rs.next()){
                Vendedor vendedor =  getVendedor(rs);
                vendedores.add(vendedor);
            }
            rs.close();
            st.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return vendedores;
    }


    private Vendedor getVendedor(ResultSet rs) throws SQLException {
        Vendedor vendedor = new Vendedor();
        vendedor.setCedula(rs.getString("cedula"));
        vendedor.setNombre(rs.getString("nombre"));
        vendedor.setCorreo(rs.getString("correo"));
        vendedor.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
        vendedor.setTelefono1(rs.getString("telefono1"));
        vendedor.setTelefono2(rs.getString("telefono2"));
        vendedor.setUsername(rs.getString("username"));
        vendedor.setPassword(rs.getString("password"));
        vendedor.setFechaCreacion(rs.getDate("fecha_creacion"));
        vendedor.setFechaModificacion(rs.getDate("fecha_modificacion"));

        return vendedor;
    }

    @Override
    public boolean create(Vendedor vendedor) {
        try (Connection conn = Conexion_BD.getConnection()) {
            assert conn != null;
            PreparedStatement pst = conn.prepareStatement("INSERT INTO vendedor(cedula, nombre, correo, fecha_nacimiento, telefono1, telefono2, username, password, fecha_creacion, fecha_modificacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, vendedor.getCedula());
            pst.setString(2, vendedor.getNombre());
            pst.setString(3, vendedor.getCorreo());
            pst.setDate(4,  new java.sql.Date(vendedor.getFecha_nacimiento().getTime())); // Convertir java.util.Date a java.sql.Date
            pst.setString(5, vendedor.getTelefono1());
            pst.setString(6, vendedor.getTelefono2());
            pst.setString(7, vendedor.getUsername());
            pst.setString(8, vendedor.getPassword());
            pst.setTimestamp(9, new java.sql.Timestamp(new java.util.Date().getTime())); // Establecer fecha de creación como fecha actual
            pst.setTimestamp(10, new java.sql.Timestamp(new java.util.Date().getTime())); // Establecer fecha de modificación como fecha actual
            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean update(Vendedor vendedor) {
        try (Connection conn = Conexion_BD.getConnection()) {
            assert conn != null;
            PreparedStatement pst = conn.prepareStatement("UPDATE vendedor SET nombre = ?, correo = ?, fecha_nacimiento = ?, telefono1 = ?, telefono2 = ?, fecha_modificacion = ? WHERE cedula = ?");
            pst.setString(1, vendedor.getNombre());
            pst.setString(2, vendedor.getCorreo());
            pst.setDate(3, new java.sql.Date(vendedor.getFecha_nacimiento().getTime()));
            pst.setString(4, vendedor.getTelefono1());
            pst.setString(5, vendedor.getTelefono2());
            pst.setTimestamp(6, new java.sql.Timestamp(new java.util.Date().getTime()));
            pst.setString(7, vendedor.getCedula());
            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Vendedor getVendedorById(String cedula){
        Vendedor vendedor = null;
        try (Connection conn = Conexion_BD.getConnection()){
            assert conn != null;
            PreparedStatement pst = conn.prepareStatement("SELECT u.* FROM vendedor as u WHERE u.cedula = ?");
            pst.setString(1, cedula);
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                vendedor = getVendedor(rs);
            }
            rs.close();
            pst.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return vendedor;
    }

    @Override
    public Vendedor getVendedorByUser(String nombre){
        Vendedor vendedor = null;
        try (Connection conn = Conexion_BD.getConnection()){
            assert conn != null;
            PreparedStatement pst = conn.prepareStatement("SELECT u.* FROM vendedor as u WHERE u.username = ?");
            pst.setString(1, nombre);
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                vendedor = getVendedor(rs);
            }
            rs.close();
            pst.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return vendedor;
    }

    @Override
    public void delete(String cedula){
        try (Connection conn = Conexion_BD.getConnection()){
            assert conn != null;
            PreparedStatement pst = conn.prepareStatement("DELETE FROM vendedor WHERE cedula = ?");
            pst.setString(1, cedula);
            pst.executeUpdate();
            pst.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
