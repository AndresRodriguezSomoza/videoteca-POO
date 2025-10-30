package com.mycompany.videoteca.poo;

import java.sql.*;
import javax.swing.JOptionPane;

//Aqui en DVDDAO se crea el codigo y se hace el INSERT a la base de datos
public class DVDDAO {
    public String generarCodigoDVD() throws SQLException{
        String sql = "SELECT MAX(CAST(SUBSTRING(cdidentificacion, 4) AS UNSIGNED)) as max_numero " +
                    "FROM dvd WHERE cdidentificacion LIKE 'DVD%'";
        
        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement pstmt = conexion.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            int maxNumero = 0;
            if (rs.next()) {
                maxNumero = rs.getInt("max_numero");
                if (rs.wasNull()) {
                    maxNumero = 0;
                }
            }
            return String.format("DVD%05d", maxNumero + 1);
        }
    }
    
    public boolean insertarDVD(DVD dvd) {
        // CORREGIDO: campos exactos de la tabla dvd
        String sql = "INSERT INTO dvd (cdidentificacion, titulo, stock, genero, duracion, director) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            
            pstmt.setString(1, dvd.getCdidentificacion());
            pstmt.setString(2, dvd.getTitle());
            pstmt.setInt(3, dvd.getOnStock());
            pstmt.setString(4, dvd.getGenre());
            pstmt.setInt(5, dvd.getDuracion());
            pstmt.setString(6, dvd.getDirector());
            
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error de base de datos: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
