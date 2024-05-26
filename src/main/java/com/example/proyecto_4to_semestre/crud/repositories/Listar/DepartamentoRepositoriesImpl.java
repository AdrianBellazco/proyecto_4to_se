package com.example.proyecto_4to_semestre.crud.repositories.Listar;

import com.example.proyecto_4to_semestre.crud.models.Ciudades;
import com.example.proyecto_4to_semestre.crud.models.Departamentos;
import com.example.proyecto_4to_semestre.crud.utils.Conexion_BD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoRepositoriesImpl implements DepartamentoRepositories {
    @Override
    public List<Departamentos> list() {
        List<Departamentos> departamentos = new ArrayList<>();
        try (Connection conn = Conexion_BD.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM departamentos");
            while (rs.next()) {
                Departamentos de = getdepartamento(rs);
                departamentos.add(de);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departamentos;
    }

    @Override
    public List<Ciudades> listCiudad() {
        List<Ciudades> ciudad = new ArrayList<>();
        try (Connection conn = Conexion_BD.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ciudades");
            while (rs.next()) {
                Ciudades de = getciudad(rs);
                ciudad.add(de);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ciudad;
    }


    @Override
    public List<Ciudades> findCiudadesByDepartamento(int departamentoId) {
        List<Ciudades> ciudad = new ArrayList<>();
        try (Connection conn = Conexion_BD.getConnection()){
            assert conn != null;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ciudades WHERE departamento_id = " + departamentoId);
            while (rs.next()){
                Ciudades de = getciudad(rs);
                ciudad.add(de);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ciudad;
    }

    private Departamentos getdepartamento(ResultSet rs) throws SQLException {
        Departamentos depa = new Departamentos();
        depa.setIdDepartamento(rs.getInt("id"));
        depa.setDepartamento(rs.getString("departamento"));
        return depa;
    }

    private Ciudades getciudad(ResultSet rs) throws SQLException {
        Ciudades city = new Ciudades();
        city.setIdCiudad(rs.getInt("id"));
        city.setNombreCiudad(rs.getString("ciudad"));
        city.setIdDepartamento(rs.getInt("departamento_id"));

        return city;
    }
}
