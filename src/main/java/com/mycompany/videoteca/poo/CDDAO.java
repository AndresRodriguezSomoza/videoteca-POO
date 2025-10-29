package com.mycompany.videoteca.poo;

import java.sql.*;
import javax.swing.JOptionPane;

public class CDDAO {

    public String generarCodigoCD() throws SQLException {
        String sql = "SELECT MAX(CAST(SUBSTRING(cdidentificacion, 3) AS UNSIGNED)) as max_numero "
                + "FROM cd WHERE cdidentificacion LIKE 'CDA%'";

        try (Connection conexion = ConexionBD.conectar(); PreparedStatement pstmt = conexion.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            int maxNumero = 0;
            if (rs.next()) {
                maxNumero = rs.getInt("max_numero");
                if (rs.wasNull()) {
                    maxNumero = 0;
                }
            }
            return String.format("CDA%05d", maxNumero + 1);
        }
    }

    public boolean insertarCD(CD cd) {
        String sql = "INSERT INTO cd (cdidentificacion, titulo, stock, genero, duracion, artista, numerodecanciones) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.conectar(); PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setString(1, cd.getCdidentificacion());
            pstmt.setString(2, cd.getTitle());
            pstmt.setInt(3, cd.getOnStock());
            pstmt.setString(4, cd.getGenre());
            pstmt.setInt(5, cd.getDuracion());
            pstmt.setString(6, cd.getArtista());
            pstmt.setInt(7, cd.getNumeroCanciones());

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error de base de datos: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
