package com.example.proyecto_4to_semestre.crud.repositories.Listar;

import com.example.proyecto_4to_semestre.crud.models.User;
import com.example.proyecto_4to_semestre.crud.models.puntosVisitas;
import com.example.proyecto_4to_semestre.crud.utils.Conexion_BD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class puntosVisitaRepositoriesImpl implements puntosVisitaRepositories {

    @Override
    public List<puntosVisitas> list() {
        List<puntosVisitas> users = new ArrayList<>();
        try (Connection conn = Conexion_BD.getConnection()){
            assert conn != null;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM puntovisita");
            while (rs.next()){
                puntosVisitas user = getpunto(rs);
                users.add(user);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    private puntosVisitas getpunto(ResultSet rs) throws SQLException {
        puntosVisitas punto = new puntosVisitas();
        punto.setIdpunto(rs.getString("idpunto"));
        punto.setNombre(rs.getString("titulo"));
        punto.setDescripcion(rs.getString("descripcion"));
        punto.setEstado(rs.getBoolean("estado"));
        punto.setDepartamento(rs.getString("departamento"));
        punto.setCiudad(rs.getString("ciudad"));
        punto.setFechaCreacion(rs.getDate("fechacreacion"));
        punto.setFechaModificacion(rs.getDate("fechamodificacion"));
       return punto;
    }

    @Override
    public boolean create(puntosVisitas puntos) {
        try (Connection conn = Conexion_BD.getConnection()) {
            assert conn != null;
            java.util.Date currentDate = new java.util.Date();
            java.sql.Date sqlCurrentDate = new java.sql.Date(currentDate.getTime());

            PreparedStatement pst = conn.prepareStatement(
                    "INSERT INTO puntovisita(idpunto, titulo, descripcion, estado, departamento, ciudad, fechacreacion, fechamodificacion) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
            );

            pst.setString(1, puntos.getIdpunto());
            pst.setString(2, puntos.getNombre());
            pst.setString(3, puntos.getDescripcion());
            pst.setBoolean(4, puntos.getEstado());
            pst.setString(5, puntos.getDepartamento());
            pst.setString(6, puntos.getCiudad()); // Fecha de nacimiento como String
            pst.setDate(7, sqlCurrentDate); // Fecha de creación
            pst.setDate(8, sqlCurrentDate); // Fecha de modificación

            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(puntosVisitas puntos){
        try (Connection conn = Conexion_BD.getConnection()){
            assert conn != null;
            PreparedStatement pst = conn.prepareStatement("UPDATE puntovisita SET titulo = ?, descripcion = ?, estado = ?, departamento = ?, ciudad = ?, fechamodificacion = ? WHERE idpunto = ?");
            pst.setString(1, puntos.getNombre());
            pst.setString(2, puntos.getDescripcion());
            pst.setBoolean(3, puntos.getEstado());
            pst.setString(4, puntos.getDepartamento());
            pst.setString(5, puntos.getCiudad()); // Convertir String a Date
            pst.setDate(6, new java.sql.Date(puntos.getFechaModificacion().getTime())); // Convertir String a Date
            pst.setString(7, puntos.getIdpunto());
            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(String id) {
        try (Connection conn = Conexion_BD.getConnection()) {
            assert conn != null;
            PreparedStatement pst = conn.prepareStatement("DELETE FROM puntovisita WHERE idpunto = ?");
            pst.setString(1, id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        @Override
        public puntosVisitas getById(String id){
            puntosVisitas punto = null;
            try (Connection conn = Conexion_BD.getConnection()){
                assert conn != null;
                PreparedStatement pst = conn.prepareStatement("SELECT u.* FROM puntovisita as u WHERE u.idpunto = ?");
                pst.setString(1, id);
                ResultSet rs = pst.executeQuery();
                if (rs.next()){
                    punto = getpunto(rs);
                }
                rs.close();
                pst.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
            return punto;
        }


}
