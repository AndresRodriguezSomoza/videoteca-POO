package com.mycompany.videoteca.poo;

import java.sql.*;
import javax.swing.JOptionPane;

public class LibroDAO {
    
    public String generarCodigoLibro() throws SQLException {
        String sql = "SELECT MAX(CAST(SUBSTRING(cdidentificacion, 4) AS UNSIGNED)) as max_numero " +
                    "FROM libro WHERE cdidentificacion LIKE 'LIB%'";
        
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
            return String.format("LIB%05d", maxNumero + 1);
        }
    }
    
    public boolean insertarLibro(Libro libro) {
        String sql = "INSERT INTO libro (cdidentificacion, titulo, stock, publisher, autor, numerodepaginas, isbn, publishyear) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            
            pstmt.setString(1, libro.getCdidentificacion());
            pstmt.setString(2, libro.getTitle());
            pstmt.setInt(3, libro.getOnStock());
            pstmt.setString(4, libro.getPublisher());
            pstmt.setString(5, libro.getAutor());
            pstmt.setInt(6, libro.getNumeroDePaginas());
            pstmt.setString(7, libro.getIsbn());
            pstmt.setInt(8, libro.getAñoDePublicacion());
            
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error de base de datos: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
