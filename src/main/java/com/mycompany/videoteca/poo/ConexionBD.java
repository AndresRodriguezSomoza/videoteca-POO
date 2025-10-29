package com.mycompany.videoteca.poo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/videoteca";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public static Connection conectar() throws SQLException {
        String urlCompleta = URL + "?useSSL=false&serverTimezone=UTC";
        return DriverManager.getConnection(urlCompleta, USER, PASSWORD);
    }
    
    public static boolean verificarConexion() {
        try (Connection conn = conectar()) {
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}