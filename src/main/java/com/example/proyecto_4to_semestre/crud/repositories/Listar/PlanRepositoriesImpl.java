package com.example.proyecto_4to_semestre.crud.repositories.Listar;

import com.example.proyecto_4to_semestre.crud.models.PlanesTuristicos;
import com.example.proyecto_4to_semestre.crud.utils.Conexion_BD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanRepositoriesImpl implements PlanRepositories {

    @Override
    public  List<PlanesTuristicos> list(){
        List<PlanesTuristicos> planesTuristicos = new ArrayList<>();
        try(Connection conn = Conexion_BD.getConnection()){
            assert conn != null;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM PlanesTuristicos");
            while (rs.next()){
                PlanesTuristicos planesTuristico = getPlanTuristico(rs);
                planesTuristicos.add(planesTuristico);
            }
            rs.close();
            st.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return planesTuristicos;
    }

    private PlanesTuristicos getPlanTuristico(ResultSet rs) throws SQLException {
        PlanesTuristicos plan = new PlanesTuristicos();
        plan.setTitulo(rs.getString("Titulo"));
        plan.setDescripcion(rs.getString("Descripcion"));
        plan.setDuracionDias(rs.getInt("DuracionDias"));
        plan.setIncluyeDesayuno(rs.getBoolean("IncluyeDesayuno"));
        plan.setIncluyeAlmuerzo(rs.getBoolean("IncluyeAlmuerzo"));
        plan.setPagarAdicionalAlimentacion(rs.getBoolean("PagarAdicionalAlimentacion"));
        plan.setCostoDesayuno(rs.getDouble("CostoDesayuno"));
        plan.setCostoAlmuerzo(rs.getDouble("CostoAlmuerzo"));
        plan.setCostoComida(rs.getDouble("CostoComida"));
        plan.setEstado(rs.getString("Estado"));
        plan.setFechaCreacion(rs.getDate("FechaCreacion"));
        plan.setFechaModificacion(rs.getDate("FechaModificacion"));
        plan.setUrl(rs.getString("Url"));
        return plan;
    }


    @Override
    public boolean create(PlanesTuristicos planesTuristico) {
        try (Connection conn = Conexion_BD.getConnection()) {
            assert conn != null;
            java.util.Date currentDate = new java.util.Date();
            PreparedStatement pst = conn.prepareStatement("INSERT INTO planesturisticos (Titulo, Descripcion, DuracionDias, IncluyeDesayuno, IncluyeAlmuerzo, PagarAdicionalAlimentacion, CostoDesayuno, CostoAlmuerzo, CostoComida, Estado, FechaCreacion, FechaModificacion, Url) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, planesTuristico.getTitulo());
            pst.setString(2, planesTuristico.getDescripcion());
            pst.setInt(3, planesTuristico.getDuracionDias());
            pst.setBoolean(4, planesTuristico.isIncluyeDesayuno());
            pst.setBoolean(5, planesTuristico.isIncluyeAlmuerzo());
            pst.setBoolean(6, planesTuristico.isPagarAdicionalAlimentacion());
            pst.setDouble(7, planesTuristico.getCostoDesayuno());
            pst.setDouble(8, planesTuristico.getCostoAlmuerzo());
            pst.setDouble(9, planesTuristico.getCostoComida());
            pst.setString(10, planesTuristico.getEstado());

            // Seteamos la fecha de creación y modificación con la fecha actual
            pst.setDate(11, new java.sql.Date(currentDate.getTime()));
            pst.setDate(12, new java.sql.Date(currentDate.getTime()));

            pst.setString(13, planesTuristico.getUrl());

            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update (PlanesTuristicos planesTuristico) {
        try (Connection conn = Conexion_BD.getConnection()) {
            assert conn != null;
            java.util.Date currentDate = new java.util.Date();
            PreparedStatement pst = conn.prepareStatement("UPDATE planesturisticos SET Descripcion = ?, DuracionDias = ?, IncluyeDesayuno = ?, IncluyeAlmuerzo = ?, PagarAdicionalAlimentacion = ?, CostoDesayuno = ?, CostoAlmuerzo = ?, CostoComida = ?, Estado = ?, FechaModificacion = ?, Url = ? WHERE Titulo = ?");

            pst.setString(1, planesTuristico.getDescripcion());
            pst.setInt(2, planesTuristico.getDuracionDias());
            pst.setBoolean(3, planesTuristico.isIncluyeDesayuno());
            pst.setBoolean(4, planesTuristico.isIncluyeAlmuerzo());
            pst.setBoolean(5, planesTuristico.isPagarAdicionalAlimentacion());
            pst.setDouble(6, planesTuristico.getCostoDesayuno());
            pst.setDouble(7, planesTuristico.getCostoAlmuerzo());
            pst.setDouble(8, planesTuristico.getCostoComida());
            pst.setString(9, planesTuristico.getEstado());
            pst.setDate(10, new java.sql.Date(currentDate.getTime()));
            pst.setString(11, planesTuristico.getUrl());
            pst.setString(12, planesTuristico.getTitulo());

            int rowsUpdated = pst.executeUpdate();
            pst.close();

            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public void delete(String Titulo){
        try (Connection conn = Conexion_BD.getConnection()){
            assert conn != null;
            PreparedStatement pst = conn.prepareStatement("DELETE FROM planesturisticos WHERE Titulo = ?");
            pst.setString(1, Titulo);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public PlanesTuristicos getplandById(String Titulo) {
        PlanesTuristicos plan = null;
        try (Connection conn = Conexion_BD.getConnection()) {
            assert conn != null;
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM planesturisticos WHERE Titulo = ?");
            pst.setString(1, Titulo);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                plan = new PlanesTuristicos();
                plan.setTitulo(rs.getString("Titulo"));
                plan.setDescripcion(rs.getString("Descripcion"));
                plan.setDuracionDias(rs.getInt("DuracionDias"));
                plan.setIncluyeDesayuno(rs.getBoolean("IncluyeDesayuno"));
                plan.setIncluyeAlmuerzo(rs.getBoolean("IncluyeAlmuerzo"));
                plan.setPagarAdicionalAlimentacion(rs.getBoolean("PagarAdicionalAlimentacion"));
                plan.setCostoDesayuno(rs.getDouble("CostoDesayuno"));
                plan.setCostoAlmuerzo(rs.getDouble("CostoAlmuerzo"));
                plan.setCostoComida(rs.getDouble("CostoComida"));
                plan.setEstado(rs.getString("Estado"));
                plan.setFechaCreacion(rs.getDate("FechaCreacion"));
                plan.setFechaModificacion(rs.getDate("FechaModificacion"));
                plan.setUrl(rs.getString("Url"));
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return plan;
    }


}
