package com.example.proyecto_4to_semestre.crud.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion_BD {

    private static final String url = "jdbc:postgresql://localhost:5432/turismo";
    private static final String username = "postgres";

    private Conexion_BD(){}

    public static Connection getConnection(){
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            return DriverManager.getConnection(url, username, "3187140146");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
