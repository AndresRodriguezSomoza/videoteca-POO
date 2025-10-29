package com.mycompany.videoteca.poo;

import java.sql.*;
import javax.swing.JOptionPane;

public class RevistaDAO {

    public String generarCodigoRevista() throws SQLException {
        String sql = "SELECT MAX(CAST(SUBSTRING(cdidentificacion, 4) AS UNSIGNED)) as max_numero "
                + "FROM revista WHERE cdidentificacion LIKE 'REV%'";

        try (Connection conexion = ConexionBD.conectar(); PreparedStatement pstmt = conexion.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            int maxNumero = 0;
            if (rs.next()) {
                maxNumero = rs.getInt("max_numero");
                if (rs.wasNull()) {
                    maxNumero = 0;
                }
            }
            return String.format("REV%05d", maxNumero + 1);
        }
    }

    public boolean insertarRevista(Revista revista) {
        String sql = "INSERT INTO revista (cdidentificacion, titulo, stock, publisher, periocidad, fechapublicacion) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.conectar(); PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setString(1, revista.getCdidentificacion());
            pstmt.setString(2, revista.getTitle());
            pstmt.setInt(3, revista.getOnStock());
            pstmt.setString(4, revista.getPublisher());
            pstmt.setString(5, revista.getPeriocidad());
            pstmt.setString(6, revista.getFechaPubli());

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error de base de datos: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
