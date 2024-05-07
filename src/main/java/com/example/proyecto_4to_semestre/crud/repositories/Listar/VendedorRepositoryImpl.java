package com.example.proyecto_4to_semestre.crud.repositories.Listar;

import com.example.proyecto_4to_semestre.crud.models.Vendedor;
import com.example.proyecto_4to_semestre.crud.utils.Conexion_BD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

}
