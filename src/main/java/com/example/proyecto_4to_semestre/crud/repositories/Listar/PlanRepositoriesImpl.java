package com.example.proyecto_4to_semestre.crud.repositories.Listar;

import com.example.proyecto_4to_semestre.crud.models.Activity;
import com.example.proyecto_4to_semestre.crud.models.PlanesTuristicos;
import com.example.proyecto_4to_semestre.crud.models.Tarifa;
import com.example.proyecto_4to_semestre.crud.models.puntosVisitas;
import com.example.proyecto_4to_semestre.crud.utils.Conexion_BD;
import com.example.proyecto_4to_semestre.crud.utils.generadorID;

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
            ResultSet rs = st.executeQuery("SELECT * FROM Plan_turistico");
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

    @Override
    public List<Tarifa> listTarifas(){
        List<Tarifa> tarifas = new ArrayList<>();
        try(Connection conn = Conexion_BD.getConnection()){
            assert conn != null;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tarifa_vigente");
            while (rs.next()){
                Tarifa tarifa = gettarifa(rs);
                tarifas.add(tarifa);
            }
            rs.close();
            st.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return tarifas;
    }

    @Override
    public List<Activity> listActivities(){
        List<Activity> acty = new ArrayList<>();
        try(Connection conn = Conexion_BD.getConnection()){
            assert conn != null;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM punto_visitas");
            while (rs.next()){
                Activity tarifa = getActivity(rs);
                acty.add(tarifa);
            }
            rs.close();
            st.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return acty;
    }

    private PlanesTuristicos getPlanTuristico(ResultSet rs) throws SQLException {
        PlanesTuristicos plan = new PlanesTuristicos();
        plan.setID(rs.getString("id_plan"));
        plan.setTitulo(rs.getString("titulo"));
        plan.setDescripcion(rs.getString("Descripcion"));
        plan.setDuracionDias(rs.getInt("cantidad_dias_duracion"));
        plan.setIncluyeDesayuno(rs.getBoolean("incluyedesayuno"));
        plan.setIncluyeAlmuerzo(rs.getBoolean("incluyealmuerzo"));
        plan.setPagarAdicionalAlimentacion(rs.getBoolean("pagaradicionalalimentacion"));
        plan.setCostoDesayuno(rs.getDouble("costodesayuno"));
        plan.setCostoAlmuerzo(rs.getDouble("costoalmuerzo"));
        plan.setCostoComida(rs.getDouble("costocomida"));
        plan.setEstado(rs.getString("estado"));
        plan.setFechaCreacion(rs.getDate("fechacreacion"));
        plan.setFechaModificacion(rs.getDate("fechamodificacion"));
        plan.setUrl(rs.getString("url"));

        //para la tarifa
/*
        Tarifa tarifa = new Tarifa();
        tarifa.setTemporada(rs.getString("temporada"));
        tarifa.setId_planturistico(rs.getString("id_plan_turistico"));
        tarifa.setEstado(rs.getBoolean("estado"));
        tarifa.setPrecio(rs.getDouble("costo"));
        tarifa.setIniciotemporada(rs.getString("inicio_temporada"));
        tarifa.setFintemporada(rs.getString("fin_temporada"));
        tarifa.setFechaCreacion(rs.getDate("fecha_creacion"));
        tarifa.setFechaModificacion(rs.getDate("fecha_modificacion"));
*/

        return plan;
    }

    private Tarifa gettarifa(ResultSet rs) throws SQLException {


        Tarifa tarifa = new Tarifa();
        tarifa.setTemporada(rs.getString("temporada"));
        tarifa.setId_planturistico(rs.getString("id_plan_turistico"));
        tarifa.setEstado(rs.getBoolean("estado"));
        tarifa.setPrecio(rs.getDouble("costo"));
        tarifa.setIniciotemporada(rs.getString("inicio_temporada"));
        tarifa.setFintemporada(rs.getString("fin_temporada"));
        tarifa.setFechaCreacion(rs.getDate("fecha_creacion"));
        tarifa.setFechaModificacion(rs.getDate("fecha_modificacion"));

        return tarifa;
    }

    private Activity getActivity(ResultSet rs) throws SQLException {
        Activity activity = new Activity();

        activity.setIdTouristPlan(rs.getString("id_plan"));
        activity.setIdPuntosVisita(rs.getString("idpunto"));

        return activity;
    }



    @Override
    public boolean create(PlanesTuristicos touristPlan, List<puntosVisitas> selectedActivities, List<Tarifa> tariffs) {
        try (Connection conn = Conexion_BD.getConnection()) {
            assert conn != null;
            java.util.Date currentDate = new java.util.Date();
            PreparedStatement pst = conn.prepareStatement("INSERT INTO Plan_turistico (titulo, descripcion," +
                    " cantidad_dias_duracion, incluyedesayuno, incluyealmuerzo, pagaradicionalalimentacion," +
                    " costodesayuno, costoalmuerzo, costocomida, estado, fechacreacion," +
                    " fechamodificacion, Url, id_plan) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");


            pst.setString(1, touristPlan.getTitulo());
            pst.setString(2, touristPlan.getDescripcion());
            pst.setInt(3, touristPlan.getDuracionDias());
            pst.setBoolean(4, touristPlan.isIncluyeDesayuno());
            pst.setBoolean(5, touristPlan.isIncluyeAlmuerzo());
            pst.setBoolean(6, touristPlan.isPagarAdicionalAlimentacion());
            pst.setDouble(7, touristPlan.getCostoDesayuno());
            pst.setDouble(8, touristPlan.getCostoAlmuerzo());
            pst.setDouble(9, touristPlan.getCostoComida());
            pst.setString(10, touristPlan.getEstado());
            pst.setDate(11, new java.sql.Date(currentDate.getTime()));
            pst.setDate(12, new java.sql.Date(currentDate.getTime()));
            pst.setString(13, touristPlan.getUrl());
            touristPlan.setID(generadorID.generarCodigo());
            pst.setString(14, touristPlan.getID());

            pst.executeUpdate();
            pst.close();

            PreparedStatement pst2 = conn.prepareStatement(
                    "INSERT INTO planTiene_PuntosVisita (id_plan, idpunto) VALUES (?, ?)");
            for (puntosVisitas activity : selectedActivities) {
                pst2.setString(1, touristPlan.getID());
                pst2.setString(2, activity.getIdpunto());
                pst2.addBatch();
            }
            pst2.executeBatch();
            pst2.close();

            PreparedStatement pst3 = conn.prepareStatement(
                    "INSERT INTO tarifa_vigente (temporada, id_plan_turistico, costo, estado, inicio_temporada, fin_temporada, fecha_creacion, fecha_modificacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            for (Tarifa tariff : tariffs) {
                pst3.setString(1, tariff.getTemporada());
                pst3.setString(2, touristPlan.getID());
                pst3.setDouble(3, tariff.getPrecio());
                pst3.setBoolean(4, true);
                pst3.setString(5, tariff.getIniciotemporada());
                pst3.setString(6, tariff.getFintemporada());
                pst3.setDate(7, Date.valueOf(String.valueOf(currentDate)));
                pst3.setDate(8, Date.valueOf(String.valueOf(currentDate)));

                pst3.addBatch();
            }
            pst3.executeBatch();
            pst3.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(PlanesTuristicos touristPlan, List<puntosVisitas> selectedActivities, List<Tarifa> tariffsToInsert, List<Tarifa> tariffsToUpdate, List<String> tariffsToDeleteId) {
        try (Connection conn =Conexion_BD.getConnection()) {
            java.util.Date currentDate = new java.util.Date();
            PreparedStatement pst = conn.prepareStatement("UPDATE Plan_turistico SET Descripcion = ?, cantidad_dias_duracion = ?, incluyedesayuno = ?, incluyealmuerzo = ?, pagaradicionalalimentacion = ?, costodesayuno = ?, costoalmuerzo = ?, costocomida = ?, estado = ?, fechamodificacion = ?, Url = ?, Titulo = ? WHERE id_plan = ?");

            pst.setString(1, touristPlan.getDescripcion());
            pst.setInt(2, touristPlan.getDuracionDias());
            pst.setBoolean(3, touristPlan.isIncluyeDesayuno());
            pst.setBoolean(4, touristPlan.isIncluyeAlmuerzo());
            pst.setBoolean(5, touristPlan.isPagarAdicionalAlimentacion());
            pst.setDouble(6, touristPlan.getCostoDesayuno());
            pst.setDouble(7, touristPlan.getCostoAlmuerzo());
            pst.setDouble(8, touristPlan.getCostoComida());
            pst.setString(9, touristPlan.getEstado());
            pst.setDate(10, new java.sql.Date(currentDate.getTime()));
            pst.setString(11, touristPlan.getUrl());
            pst.setString(12, touristPlan.getTitulo());
            pst.setString(13, touristPlan.getID());


            int rowsUpdated = pst.executeUpdate();
            pst.close();

            // Set new activities-plan
            PreparedStatement pst2 = conn.prepareStatement("DELETE FROM planTiene_PuntosVisita WHERE id_plan = ?");
            pst2.setString(1, touristPlan.getID());
            pst2.executeUpdate();
            pst2.close();

            PreparedStatement pst3 = conn.prepareStatement(
                    "INSERT INTO planTiene_PuntosVisita (id_plan, idpunto) VALUES (?, ?)");
            for (puntosVisitas activity : selectedActivities) {
                pst3.setString(1, touristPlan.getID());
                pst3.setString(2, activity.getIdpunto());
                pst3.addBatch();
            }
            pst3.executeBatch();
            pst3.close();

            //Delete-Update-Insert Tariffs
            if (tariffsToDeleteId.size() > 0) {
                String deleteSql = "DELETE FROM Tarifa_vigente WHERE id_plan_turistico=? AND temporada IN (";
                for (int i = 0; i < tariffsToDeleteId.size(); i++) {
                    deleteSql += "?";
                    if (i < tariffsToDeleteId.size() - 1) {
                        deleteSql += ", ";
                    }
                }
                deleteSql += ")";
                PreparedStatement pst4 = conn.prepareStatement(deleteSql);
                pst4.setString(1, touristPlan.getID());
                for (int i = 0; i < tariffsToDeleteId.size(); i++) {
                    pst4.setString(i + 2, tariffsToDeleteId.get(i));
                }
                pst4.executeUpdate();
            }

            if (tariffsToInsert.size() > 0) {
                PreparedStatement pst5 = conn.prepareStatement(
                        "INSERT INTO Tarifa_vigente (temporada, id_plan_turistico, costo, estado, inicio_temporada, fin_temporada, fecha_creacion, fecha_modificacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                for (Tarifa tariff : tariffsToInsert) {
                    pst5.setString(1, tariff.getTemporada());
                    pst5.setString(2, touristPlan.getID());
                    pst5.setDouble(3, tariff.getPrecio());
                    pst5.setBoolean(4, true);
                    pst5.setString(5, tariff.getIniciotemporada());
                    pst5.setString(6, tariff.getFintemporada());
                    pst5.setDate(7, new java.sql.Date(currentDate.getTime()));
                    pst5.setDate(8, new java.sql.Date(currentDate.getTime()));
                    pst5.addBatch();
                }
                pst5.executeBatch();
                pst5.close();
            }

            if (tariffsToUpdate.size() > 0 ) {
                PreparedStatement pst6 = conn.prepareStatement(
                        "UPDATE Tarifa_vigente SET costo = ?, estado = ?, inicio_temporada = ?, fin_temporada = ?, fecha_modificacion = ? WHERE temporada=? AND id_plan_turistico=?");
                for (Tarifa tariff : tariffsToUpdate) {
                    pst6.setDouble(1, tariff.getPrecio());
                    pst6.setBoolean(2, tariff.isEstado());
                    pst6.setString(3, tariff.getIniciotemporada());
                    pst6.setString(4, tariff.getFintemporada());
                    pst6.setDate(5, new java.sql.Date(currentDate.getTime()));
                    pst6.setString(6, tariff.getTemporada());
                    pst6.setString(7, touristPlan.getID());
                }
                pst6.executeUpdate();
                pst6.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }



/*
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
*/

    public void delete(String Titulo){
        try (Connection conn = Conexion_BD.getConnection()){
            assert conn != null;
            PreparedStatement pst = conn.prepareStatement("DELETE FROM Plan_turistico WHERE id_plan = ?");
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
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM Plan_turistico WHERE id_plan = ?");
            pst.setString(1, Titulo);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                plan = new PlanesTuristicos();
                plan.setID(rs.getString("id_plan"));
                plan.setTitulo(rs.getString("titulo"));
                plan.setDescripcion(rs.getString("descripcion"));
                plan.setDuracionDias(rs.getInt("cantidad_dias_duracion"));
                plan.setIncluyeDesayuno(rs.getBoolean("incluyedesayuno"));
                plan.setIncluyeAlmuerzo(rs.getBoolean("incluyealmuerzo"));
                plan.setPagarAdicionalAlimentacion(rs.getBoolean("pagaradicionalalimentacion"));
                plan.setCostoDesayuno(rs.getDouble("costodesayuno"));
                plan.setCostoAlmuerzo(rs.getDouble("costoalmuerzo"));
                plan.setCostoComida(rs.getDouble("costocomida"));
                plan.setEstado(rs.getString("estado"));
                plan.setFechaCreacion(rs.getDate("fechacreacion"));
                plan.setFechaModificacion(rs.getDate("fechamodificacion"));
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
