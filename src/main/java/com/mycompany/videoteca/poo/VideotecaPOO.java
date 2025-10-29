/*
SE MODIFICO EL 25/10/2025 POR ANDRES
ANDRES: BASE DE DATOS
EDUARDO Y WILLIAM: VALIDACIONES
ALEX Y MANUEL: SUB MENU ELIMINAR Y EDITAR
 */
package com.mycompany.videoteca.poo;

import java.sql.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class VideotecaPOO {

    static List<String> materialesEscritos = new ArrayList<>();
    static List<String> materialesAudiovisuales = new ArrayList<>();

    public static void main(String[] args) {
        MainMenu();
    }

    public static void MainMenu() {
        while (true) {
            String[] opciones = {"Material Escrito", "Material Audiovisual", "Salir"};

            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "🏠 SISTEMA DE MEDIATECA\nSeleccione el tipo de material:",
                    "Menú Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (seleccion) {
                case 0:
                    menuEscrito();
                    break;
                case 1:
                    menuAudiovisual();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "¡Hasta pronto! 👋");
                    System.exit(0);
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    public static void menuEscrito() {
        while (true) {
            String[] opciones = {"Registrar Libro", "Registrar Revista", "Ver Materiales", "Editar Material", "Eliminar Material", "Volver"};

            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "📚 MATERIAL ESCRITO\nSeleccione una opción:",
                    "Menú Material Escrito",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (seleccion) {
                case 0:
                    ingresarLibro();
                    break;
                case 1:
                    ingresarRevista();
                    break;
                case 2:
                    mostrarEscritos();
                    break;
                case 3:
                    editarMaterialEscrito();
                    break;
                case 4:
                    eliminarMaterialEscrito();
                    break;
                case 5:
                    return;
                default:
                    return;
            }
        }
    }

    public static void menuAudiovisual() {
        while (true) {
            String[] opciones = {"Registrar CD", "Registrar DVD", "Ver Materiales", "Editar Material", "Eliminar Material", "Volver"};

            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "🎵 MATERIAL AUDIOVISUAL\nSeleccione una opción:",
                    "Menú Material Audiovisual",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (seleccion) {
                case 0:
                    ingresarCD();
                    break;
                case 1:
                    ingresarDVD();
                    break;
                case 2:
                    mostrarAudiovisuales();
                    break;
                case 3:
                    editarMaterialAudiovisual();
                    break;
                case 4:
                    eliminarMaterialAudiovisual();
                    break;
                case 5:
                    return;
                default:
                    return;
            }
        }
    }

    public static void ingresarLibro() {
        try {
            LibroDAO libroDAO = new LibroDAO();

            if (!ConexionBD.verificarConexion()) {
                JOptionPane.showMessageDialog(null, "❌ No se pudo conectar a la base de datos");
                return;
            }

            String codigo = libroDAO.generarCodigoLibro();

            String titulo = JOptionPane.showInputDialog("Título del libro:");
            if (titulo == null || titulo.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "❌ El título es obligatorio");
                return;
            }

            String autor = JOptionPane.showInputDialog("Autor:");
            if (autor == null || autor.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "❌ El autor es obligatorio");
                return;
            }

            String isbn = JOptionPane.showInputDialog("ISBN:");
            if (isbn == null || isbn.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "❌ El ISBN es obligatorio");
                return;
            }

            String publisher = JOptionPane.showInputDialog("Editorial (Publisher):");
            if (publisher == null || publisher.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "❌ La editorial es obligatoria");
                return;
            }

            int publishYear = Integer.parseInt(JOptionPane.showInputDialog("Año de publicación:"));
            int numeroPaginas = Integer.parseInt(JOptionPane.showInputDialog("Número de páginas:"));
            int stock = Integer.parseInt(JOptionPane.showInputDialog("Cantidad en stock:"));

            Libro libro = new Libro(codigo, titulo, stock, publisher, autor, numeroPaginas, isbn, publishYear);

            boolean exito = libroDAO.insertarLibro(libro);

            if (exito) {
                // Opcional: Mostrar información usando el método de Libro
                JOptionPane.showMessageDialog(null, libro.ShowInformation());
            } else {
                JOptionPane.showMessageDialog(null, "❌ Error al registrar el libro en la base de datos.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error de base de datos: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "❌ Error en los datos numéricos: Asegúrate de ingresar números válidos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "❌ Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void ingresarRevista() {
        try {
            RevistaDAO revistaDAO = new RevistaDAO();

            if (!ConexionBD.verificarConexion()) {
                JOptionPane.showMessageDialog(null, "❌ No se pudo conectar a la base de datos");
                return;
            }

            String codigo = revistaDAO.generarCodigoRevista();

            String titulo = JOptionPane.showInputDialog("Título de la revista:");
            if (titulo == null || titulo.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "❌ El título es obligatorio");
                return;
            }

            String publisher = JOptionPane.showInputDialog("Editorial (Publisher):");
            if (publisher == null || publisher.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "❌ La editorial es obligatoria");
                return;
            }

            String periocidad = JOptionPane.showInputDialog("Periodicidad:");
            if (periocidad == null || periocidad.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "❌ La periodicidad es obligatoria");
                return;
            }

            String fechaPubli = JOptionPane.showInputDialog("Fecha de publicación:");
            if (fechaPubli == null || fechaPubli.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "❌ La fecha de publicación es obligatoria");
                return;
            }

            int stock = Integer.parseInt(JOptionPane.showInputDialog("Cantidad en stock:"));

            Revista revista = new Revista(codigo, titulo, stock, publisher, periocidad, fechaPubli);

            boolean exito = revistaDAO.insertarRevista(revista);

            if (exito) {
                JOptionPane.showMessageDialog(null, revista.ShowInformation());
            } else {
                JOptionPane.showMessageDialog(null, "❌ Error al registrar la revista en la base de datos.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error de base de datos: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "❌ Error en los datos numéricos: Asegúrate de ingresar números válidos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "❌ Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void ingresarCD() {
        try {
            CDDAO cdDAO = new CDDAO();

            if (!ConexionBD.verificarConexion()) {
                JOptionPane.showMessageDialog(null, "❌ No se pudo conectar a la base de datos");
                return;
            }

            String codigo = cdDAO.generarCodigoCD();

            String titulo = JOptionPane.showInputDialog("Título del CD:");
            if (titulo == null || titulo.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "❌ El título es obligatorio");
                return;
            }

            String artista = JOptionPane.showInputDialog("Artista o grupo:");
            if (artista == null || artista.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "❌ El artista es obligatorio");
                return;
            }

            String genero = JOptionPane.showInputDialog("Género musical:");
            if (genero == null || genero.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "❌ El título es obligatorio");
                return;
            }

            int duracion = Integer.parseInt(JOptionPane.showInputDialog("Duración (en minutos):"));

            int numeroCanciones = Integer.parseInt(JOptionPane.showInputDialog("Número de canciones:"));

            int stock = Integer.parseInt(JOptionPane.showInputDialog("Cantidad en stock:"));

            CD cd = new CD(codigo, titulo, stock, genero, duracion, artista, numeroCanciones) {
            };

            boolean exito = cdDAO.insertarCD(cd);

            if (exito) {
                // Opcional: Mostrar información usando el método de CD
                JOptionPane.showMessageDialog(null, cd.ShowInformation());
            } else {
                JOptionPane.showMessageDialog(null, "❌ Error al registrar el CD en la base de datos.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error de base de datos: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "❌ Error en los datos numéricos: Asegúrate de ingresar números válidos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "❌ Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void ingresarDVD() {
        try {
            DVDDAO dvdDAO = new DVDDAO();

            if (!ConexionBD.verificarConexion()) {
                JOptionPane.showMessageDialog(null, "❌ No se pudo conectar a la base de datos");
                return;
            }

            String codigo = dvdDAO.generarCodigoDVD();

            String titulo = JOptionPane.showInputDialog("Título de la película:");
            if (titulo == null || titulo.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "❌ El título es obligatorio");
                return;
            }

            String director = JOptionPane.showInputDialog("Director:");
            if (director == null || director.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "❌ El director es obligatorio");
                return;
            }

            String genero = JOptionPane.showInputDialog("Género:");
            int duracion = Integer.parseInt(JOptionPane.showInputDialog("Duración (en minutos):"));
            int stock = Integer.parseInt(JOptionPane.showInputDialog("Cantidad en stock:"));

            DVD dvd = new DVD(director, genero, duracion, codigo, titulo, stock) {
            };

            boolean exito = dvdDAO.insertarDVD(dvd);

            if (exito) {
                JOptionPane.showMessageDialog(null, dvd.ShowInformation());
            } else {
                JOptionPane.showMessageDialog(null, "❌ Error al registrar el DVD en la base de datos.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error de base de datos: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "❌ Error en los datos numéricos: Asegúrate de ingresar números válidos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "❌ Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void mostrarEscritos() {
        String[] opciones = {
            "📚 Mostrar todos los Libros",
            "📰 Mostrar todas las Revistas",
            "⬅️ Volver al menú principal"
        };

        int opcion = JOptionPane.showOptionDialog(
                null,
                "Seleccione qué desea mostrar:",
                "Menú de Materiales Escritos",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        switch (opcion) {
            case 0:
                mostrarLibros();
                break;
            case 1:
                mostrarRevistas();
                break;
            case 2:
                // Volver al menú principal
                break;
            default:
                // Opción cancelada
                break;
        }
    }

    public static void mostrarAudiovisuales() {
        String[] opciones = {
            "📀 Mostrar todos los CDs",
            "🎥 Mostrar todos los DVDs",
            "⬅️ Volver al menú principal"
        };

        int opcion = JOptionPane.showOptionDialog(
                null,
                "Seleccione qué desea mostrar:",
                "Menú de Visualización",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        switch (opcion) {
            case 0:
                mostrarCDs();
                break;
            case 1:
                mostrarDVDs();
                break;
            case 2:
                // Volver al menú principal
                break;
            default:
                // Opción cancelada
                break;
        }
    }

    public static void mostrarLibros() {
        try (Connection conexion = ConexionBD.conectar(); Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM libro")) {

            StringBuilder sb = new StringBuilder("📚 LIBROS REGISTRADOS:\n\n");
            boolean hayLibros = false;

            while (rs.next()) {
                hayLibros = true;
                sb.append("Código: ").append(rs.getString("cdidentificacion"))
                        .append("\nTítulo: ").append(rs.getString("titulo"))
                        .append("\nAutor: ").append(rs.getString("autor"))
                        .append("\nISBN: ").append(rs.getString("isbn"))
                        .append("\nAño: ").append(rs.getInt("publishyear"))
                        .append("\nEditorial: ").append(rs.getString("publisher"))
                        .append("\nPáginas: ").append(rs.getInt("numerodepaginas"))
                        .append("\nStock: ").append(rs.getInt("stock"))
                        .append("\n--------------------\n");
            }

            if (!hayLibros) {
                sb.append("No hay libros registrados en la base de datos.");
            }

            JOptionPane.showMessageDialog(null, sb.toString());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al cargar los libros: " + e.getMessage());
        }
    }

    public static void mostrarRevistas() {
        try (Connection conexion = ConexionBD.conectar(); Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM revista")) {

            StringBuilder sb = new StringBuilder("📰 REVISTAS REGISTRADOS:\n\n");
            boolean hayRevistas = false;

            while (rs.next()) {
                hayRevistas = true;
                sb.append("Código: ").append(rs.getString("cdidentificacion"))
                        .append("\nTítulo: ").append(rs.getString("titulo"))
                        .append("\nEditorial: ").append(rs.getString("publisher"))
                        .append("\nPeriodicidad: ").append(rs.getString("periocidad"))
                        .append("\nFecha publicación: ").append(rs.getString("fechapublicacion"))
                        .append("\nStock: ").append(rs.getInt("stock"))
                        .append("\n--------------------\n");
            }

            if (!hayRevistas) {
                sb.append("No hay revistas registradas en la base de datos.");
            }

            JOptionPane.showMessageDialog(null, sb.toString());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al cargar las revistas: " + e.getMessage());
        }
    }

    public static void mostrarCDs() {
        try (Connection conexion = ConexionBD.conectar(); Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM cd")) {

            StringBuilder sb = new StringBuilder("💿 CDs REGISTRADOS:\n\n");
            boolean hayCDs = false;

            while (rs.next()) {
                hayCDs = true;
                sb.append("Código: ").append(rs.getString("cdidentificacion"))
                        .append("\nTítulo: ").append(rs.getString("titulo"))
                        .append("\nArtista: ").append(rs.getString("artista"))
                        .append("\nGénero: ").append(rs.getString("genero"))
                        .append("\nDuración: ").append(rs.getInt("duracion")).append(" min")
                        .append("\nCanciones: ").append(rs.getInt("numerodecanciones"))
                        .append("\nStock: ").append(rs.getInt("stock"))
                        .append("\n--------------------\n");
            }

            if (!hayCDs) {
                sb.append("No hay CDs registrados en la base de datos.");
            }

            JOptionPane.showMessageDialog(null, sb.toString());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al cargar los CDs: " + e.getMessage());
        }
    }

    public static void mostrarDVDs() {
        try (Connection conexion = ConexionBD.conectar(); Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM dvd")) {

            StringBuilder sb = new StringBuilder("🎥 DVDs REGISTRADOS:\n\n");
            boolean hayDVDs = false;

            while (rs.next()) {
                hayDVDs = true;
                sb.append("Código: ").append(rs.getString("cdidentificacion"))
                        .append("\nTítulo: ").append(rs.getString("titulo"))
                        .append("\nDirector: ").append(rs.getString("director"))
                        .append("\nGénero: ").append(rs.getString("genero"))
                        .append("\nDuración: ").append(rs.getInt("duracion")).append(" minutos")
                        .append("\nStock: ").append(rs.getInt("stock"))
                        .append("\n--------------------\n");
            }

            if (!hayDVDs) {
                sb.append("No hay DVDs registrados en la base de datos.");
            }

            JOptionPane.showMessageDialog(null, sb.toString());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al cargar los DVDs: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void editarMaterialEscrito() {
        try {
            if (!ConexionBD.verificarConexion()) {
                JOptionPane.showMessageDialog(null, "❌ No hay conexión a la base de datos");
                return;
            }

            List<String> materiales = new ArrayList<>();
            List<String> codigos = new ArrayList<>();
            List<String> tablas = new ArrayList<>();

            Connection conexion = ConexionBD.conectar();

            // Obtener LIBROS
            Statement stmtLibros = conexion.createStatement();
            ResultSet rsLibros = stmtLibros.executeQuery("SELECT cdidentificacion, titulo FROM libro");

            while (rsLibros.next()) {
                String codigo = rsLibros.getString("cdidentificacion");
                String titulo = rsLibros.getString("titulo");

                codigos.add(codigo);
                materiales.add(codigo + " - " + titulo + " (Libro)");
                tablas.add("libro");
            }
            rsLibros.close();
            stmtLibros.close();

            // Obtener REVISTAS
            Statement stmtRevistas = conexion.createStatement();
            ResultSet rsRevistas = stmtRevistas.executeQuery("SELECT cdidentificacion, titulo FROM revista");

            while (rsRevistas.next()) {
                String codigo = rsRevistas.getString("cdidentificacion");
                String titulo = rsRevistas.getString("titulo");

                codigos.add(codigo);
                materiales.add(codigo + " - " + titulo + " (Revista)");
                tablas.add("revista");
            }
            rsRevistas.close();
            stmtRevistas.close();

            conexion.close();

            if (materiales.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay materiales escritos para editar.");
                return;
            }

            String seleccion = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione el material a editar:",
                    "Editar Material Escrito",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    materiales.toArray(),
                    materiales.get(0)
            );

            if (seleccion != null) {
                int index = materiales.indexOf(seleccion);
                String codigo = codigos.get(index);
                String tabla = tablas.get(index);

                if (tabla.equals("libro")) {
                    editarLibro(codigo);
                } else {
                    editarRevista(codigo);
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al cargar materiales: " + e.getMessage());
        }
    }

    public static void editarLibro(String codigoLibro) {
        try {
            Connection conn = ConexionBD.conectar();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM libro WHERE cdidentificacion = ?");
            pstmt.setString(1, codigoLibro);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Mostrar datos actuales del libro
                String mensajeActual = "📚 DATOS ACTUALES DEL LIBRO:\n\n"
                        + "Código: " + rs.getString("cdidentificacion") + "\n"
                        + "Título: " + rs.getString("titulo") + "\n"
                        + "Autor: " + rs.getString("autor") + "\n"
                        + "ISBN: " + rs.getString("isbn") + "\n"
                        + "Año: " + rs.getInt("publishyear") + "\n"
                        + "Editorial: " + rs.getString("publisher") + "\n"
                        + "Páginas: " + rs.getInt("numerodepaginas") + "\n"
                        + "Stock: " + rs.getInt("stock");

                JOptionPane.showMessageDialog(null, mensajeActual, "Datos Actuales", JOptionPane.INFORMATION_MESSAGE);

                // Solicitar nuevos datos (con valores actuales como predeterminados)
                String titulo = JOptionPane.showInputDialog("Ingrese el nuevo título:", rs.getString("titulo"));
                if (titulo == null || titulo.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "❌ El título no puede estar vacío");
                    return;
                }

                String autor = JOptionPane.showInputDialog("Ingrese el nuevo autor:", rs.getString("autor"));
                if (autor == null || autor.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "❌ El autor no puede estar vacío");
                    return;
                }

                String isbn = JOptionPane.showInputDialog("Ingrese el nuevo ISBN:", rs.getString("isbn"));
                if (isbn == null || isbn.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "❌ El ISBN no puede estar vacío");
                    return;
                }

                int añoPublicacion;
                try {
                    añoPublicacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo año de publicación:", rs.getInt("publishyear")));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "❌ El año debe ser un número válido");
                    return;
                }

                String editorial = JOptionPane.showInputDialog("Ingrese la nueva editorial:", rs.getString("publisher"));
                if (editorial == null || editorial.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "❌ La editorial no puede estar vacía");
                    return;
                }

                int numeroPaginas;
                try {
                    numeroPaginas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo número de páginas:", rs.getInt("numerodepaginas")));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "❌ El número de páginas debe ser un número válido");
                    return;
                }

                int stock;
                try {
                    stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo stock:", rs.getInt("stock")));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "❌ El stock debe ser un número válido");
                    return;
                }

                // Confirmar la edición
                int confirmacion = JOptionPane.showConfirmDialog(
                        null,
                        "¿Está seguro de actualizar este libro?\n\n"
                        + "Nuevos datos:\n"
                        + "Título: " + titulo + "\n"
                        + "Autor: " + autor + "\n"
                        + "ISBN: " + isbn + "\n"
                        + "Año: " + añoPublicacion + "\n"
                        + "Editorial: " + editorial + "\n"
                        + "Páginas: " + numeroPaginas + "\n"
                        + "Stock: " + stock,
                        "Confirmar Edición",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirmacion == JOptionPane.YES_OPTION) {
                    // Actualizar en la base de datos
                    PreparedStatement updateStmt = conn.prepareStatement(
                            "UPDATE libro SET titulo=?, autor=?, isbn=?, publishyear=?, publisher=?, numerodepaginas=?, stock=? WHERE cdidentificacion=?"
                    );

                    updateStmt.setString(1, titulo);
                    updateStmt.setString(2, autor);
                    updateStmt.setString(3, isbn);
                    updateStmt.setInt(4, añoPublicacion);
                    updateStmt.setString(5, editorial);
                    updateStmt.setInt(6, numeroPaginas);
                    updateStmt.setInt(7, stock);
                    updateStmt.setString(8, codigoLibro);

                    int filasAfectadas = updateStmt.executeUpdate();

                    if (filasAfectadas > 0) {
                        JOptionPane.showMessageDialog(null, "✅ Libro actualizado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "❌ Error al actualizar el libro");
                    }

                    updateStmt.close();
                }
            } else {
                JOptionPane.showMessageDialog(null, "❌ No se encontró el libro con código: " + codigoLibro);
            }

            // Cerrar recursos
            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al editar el libro: " + e.getMessage());
        }
    }

    public static void editarRevista(String codigoRevista) {
        try {
            Connection conn = ConexionBD.conectar();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM revista WHERE cdidentificacion = ?");
            pstmt.setString(1, codigoRevista);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Mostrar datos actuales de la revista
                String mensajeActual = "📰 DATOS ACTUALES DE LA REVISTA:\n\n"
                        + "Código: " + rs.getString("cdidentificacion") + "\n"
                        + "Título: " + rs.getString("titulo") + "\n"
                        + "Editorial: " + rs.getString("publisher") + "\n"
                        + "Periodicidad: " + rs.getString("periocidad") + "\n"
                        + "Fecha: " + rs.getString("fechapublicacion") + "\n"
                        + "Stock: " + rs.getInt("stock");

                JOptionPane.showMessageDialog(null, mensajeActual, "Datos Actuales", JOptionPane.INFORMATION_MESSAGE);

                // Solicitar nuevos datos
                String titulo = JOptionPane.showInputDialog("Ingrese el nuevo título:", rs.getString("titulo"));
                if (titulo == null || titulo.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "❌ El título no puede estar vacío");
                    return;
                }

                String editorial = JOptionPane.showInputDialog("Ingrese la nueva editorial:", rs.getString("publisher"));
                if (editorial == null || editorial.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "❌ La editorial no puede estar vacía");
                    return;
                }

                String periodicidad = JOptionPane.showInputDialog("Ingrese la nueva periodicidad:", rs.getString("periocidad"));
                if (periodicidad == null || periodicidad.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "❌ La periodicidad no puede estar vacía");
                    return;
                }

                String fechaPublicacion = JOptionPane.showInputDialog("Ingrese la nueva fecha de publicación:", rs.getString("fechapublicacion"));
                if (fechaPublicacion == null || fechaPublicacion.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "❌ La fecha de publicación no puede estar vacía");
                    return;
                }

                int stock;
                try {
                    stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo stock:", rs.getInt("stock")));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "❌ El stock debe ser un número válido");
                    return;
                }

                // Confirmar la edición
                int confirmacion = JOptionPane.showConfirmDialog(
                        null,
                        "¿Está seguro de actualizar esta revista?\n\n"
                        + "Nuevos datos:\n"
                        + "Título: " + titulo + "\n"
                        + "Editorial: " + editorial + "\n"
                        + "Periodicidad: " + periodicidad + "\n"
                        + "Fecha: " + fechaPublicacion + "\n"
                        + "Stock: " + stock,
                        "Confirmar Edición",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirmacion == JOptionPane.YES_OPTION) {
                    // Actualizar en la base de datos
                    PreparedStatement updateStmt = conn.prepareStatement(
                            "UPDATE revista SET titulo=?, publisher=?, periocidad=?, fechapublicacion=?, stock=? WHERE cdidentificacion=?"
                    );

                    updateStmt.setString(1, titulo);
                    updateStmt.setString(2, editorial);
                    updateStmt.setString(3, periodicidad);
                    updateStmt.setString(4, fechaPublicacion);
                    updateStmt.setInt(5, stock);
                    updateStmt.setString(6, codigoRevista);

                    int filasAfectadas = updateStmt.executeUpdate();

                    if (filasAfectadas > 0) {
                        JOptionPane.showMessageDialog(null, "✅ Revista actualizada correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "❌ Error al actualizar la revista");
                    }

                    updateStmt.close();
                }
            } else {
                JOptionPane.showMessageDialog(null, "❌ No se encontró la revista con código: " + codigoRevista);
            }

            // Cerrar recursos
            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al editar la revista: " + e.getMessage());
        }
    }

    public static void eliminarMaterialEscrito() {
        try {
            // Verificar conexión a la base de datos
            if (!ConexionBD.verificarConexion()) {
                JOptionPane.showMessageDialog(null, "❌ No hay conexión a la base de datos");
                return;
            }

            // Obtener todos los libros y revistas
            Connection conexion = ConexionBD.conectar();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT cdidentificacion, titulo, 'libro' as tipo FROM libro UNION SELECT cdidentificacion, titulo, 'revista' as tipo FROM revista");

            List<String> materiales = new ArrayList<>();
            List<String> codigos = new ArrayList<>();
            List<String> tipos = new ArrayList<>();

            while (rs.next()) {
                String codigo = rs.getString("cdidentificacion");
                String titulo = rs.getString("titulo");
                String tipo = rs.getString("tipo");

                codigos.add(codigo);
                materiales.add(codigo + " - " + titulo + " (" + tipo + ")");
                tipos.add(tipo);
            }

            // Cerrar recursos
            rs.close();
            stmt.close();
            conexion.close();

            if (materiales.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay materiales escritos para eliminar.");
                return;
            }

            // Mostrar lista para eliminar
            String seleccion = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione el material a eliminar:",
                    "Eliminar Material Escrito",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    materiales.toArray(),
                    materiales.get(0)
            );

            if (seleccion != null) {
                int index = materiales.indexOf(seleccion);
                String codigo = codigos.get(index);
                String tipo = tipos.get(index);
                String titulo = seleccion.split(" - ")[1].split(" \\(")[0];

                // Confirmar eliminación
                int confirmacion = JOptionPane.showConfirmDialog(
                        null,
                        "¿Está seguro de eliminar:\n" + titulo + " (" + tipo + ")?",
                        "Confirmar Eliminación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );

                if (confirmacion == JOptionPane.YES_OPTION) {
                    // Eliminar de la base de datos
                    Connection conn = ConexionBD.conectar();
                    String tabla = tipo.equals("libro") ? "libro" : "revista";

                    PreparedStatement pstmt = conn.prepareStatement("DELETE FROM " + tabla + " WHERE cdidentificacion = ?");
                    pstmt.setString(1, codigo);

                    int filasAfectadas = pstmt.executeUpdate();

                    if (filasAfectadas > 0) {
                        JOptionPane.showMessageDialog(null, "✅ " + (tipo.equals("libro") ? "Libro" : "Revista") + " eliminado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "❌ Error al eliminar el material");
                    }

                    pstmt.close();
                    conn.close();
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al eliminar el material: " + e.getMessage());
        }
    }

    public static void editarMaterialAudiovisual() {
        try {
            if (!ConexionBD.verificarConexion()) {
                JOptionPane.showMessageDialog(null, "❌ No hay conexión a la base de datos");
                return;
            }

            List<String> materiales = new ArrayList<>();
            List<String> codigos = new ArrayList<>();
            List<String> tablas = new ArrayList<>();

            Connection conexion = ConexionBD.conectar();

            // Obtener LIBROS
            Statement stmtLibros = conexion.createStatement();
            ResultSet rsLibros = stmtLibros.executeQuery("SELECT cdidentificacion, titulo FROM cd");

            while (rsLibros.next()) {
                String codigo = rsLibros.getString("cdidentificacion");
                String titulo = rsLibros.getString("titulo");

                codigos.add(codigo);
                materiales.add(codigo + " - " + titulo + " (CD)");
                tablas.add("libro");
            }
            rsLibros.close();
            stmtLibros.close();

            // Obtener REVISTAS
            Statement stmtRevistas = conexion.createStatement();
            ResultSet rsRevistas = stmtRevistas.executeQuery("SELECT cdidentificacion, titulo FROM dvd");

            while (rsRevistas.next()) {
                String codigo = rsRevistas.getString("cdidentificacion");
                String titulo = rsRevistas.getString("titulo");

                codigos.add(codigo);
                materiales.add(codigo + " - " + titulo + " (DVD)");
                tablas.add("revista");
            }
            rsRevistas.close();
            stmtRevistas.close();

            conexion.close();

            if (materiales.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay materiales escritos para editar.");
                return;
            }

            String seleccion = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione el material a editar:",
                    "Editar Material Audiovisual",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    materiales.toArray(),
                    materiales.get(0)
            );

            if (seleccion != null) {
                int index = materiales.indexOf(seleccion);
                String codigo = codigos.get(index);
                String tabla = tablas.get(index);

                if (tabla.equals("cd")) {
                    editarCD(codigo);
                } else {
                    editarDVD(codigo);
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al cargar materiales: " + e.getMessage());
        }
    }

    public static void editarCD(String codigoCD) {
        try {
            Connection conn = ConexionBD.conectar();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM cd WHERE cdidentificacion = ?");
            pstmt.setString(1, codigoCD);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Mostrar datos actuales del CD
                String mensajeActual = "💿 DATOS ACTUALES DEL CD:\n\n"
                        + "Código: " + rs.getString("cdidentificacion") + "\n"
                        + "Título: " + rs.getString("titulo") + "\n"
                        + "Artista: " + rs.getString("artista") + "\n"
                        + "Género: " + rs.getString("genero") + "\n"
                        + "Duración: " + rs.getInt("duracion") + " minutos\n"
                        + "Número de canciones: " + rs.getInt("numerodecanciones") + "\n"
                        + "Stock: " + rs.getInt("stock");

                JOptionPane.showMessageDialog(null, mensajeActual, "Datos Actuales", JOptionPane.INFORMATION_MESSAGE);

                // Solicitar nuevos datos (con valores actuales como predeterminados)
                String titulo = JOptionPane.showInputDialog("Ingrese el nuevo título:", rs.getString("titulo"));
                if (titulo == null || titulo.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "❌ El título no puede estar vacío");
                    return;
                }

                String artista = JOptionPane.showInputDialog("Ingrese el nuevo artista/grupo:", rs.getString("artista"));
                if (artista == null || artista.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "❌ El artista no puede estar vacío");
                    return;
                }

                String genero = JOptionPane.showInputDialog("Ingrese el nuevo género musical:", rs.getString("genero"));
                if (genero == null || genero.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "❌ El género no puede estar vacío");
                    return;
                }

                int duracion;
                try {
                    duracion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva duración (minutos):", rs.getInt("duracion")));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "❌ La duración debe ser un número válido");
                    return;
                }

                int numeroCanciones;
                try {
                    numeroCanciones = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo número de canciones:", rs.getInt("numerodecanciones")));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "❌ El número de canciones debe ser un número válido");
                    return;
                }

                int stock;
                try {
                    stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo stock:", rs.getInt("stock")));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "❌ El stock debe ser un número válido");
                    return;
                }

                // Confirmar la edición
                int confirmacion = JOptionPane.showConfirmDialog(
                        null,
                        "¿Está seguro de actualizar este CD?\n\n"
                        + "Nuevos datos:\n"
                        + "Título: " + titulo + "\n"
                        + "Artista: " + artista + "\n"
                        + "Género: " + genero + "\n"
                        + "Duración: " + duracion + " minutos\n"
                        + "Canciones: " + numeroCanciones + "\n"
                        + "Stock: " + stock,
                        "Confirmar Edición",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirmacion == JOptionPane.YES_OPTION) {
                    // Actualizar en la base de datos
                    PreparedStatement updateStmt = conn.prepareStatement(
                            "UPDATE cd SET titulo=?, artista=?, genero=?, duracion=?, numerodecanciones=?, stock=? WHERE cdidentificacion=?"
                    );

                    updateStmt.setString(1, titulo);
                    updateStmt.setString(2, artista);
                    updateStmt.setString(3, genero);
                    updateStmt.setInt(4, duracion);
                    updateStmt.setInt(5, numeroCanciones);
                    updateStmt.setInt(6, stock);
                    updateStmt.setString(7, codigoCD);

                    int filasAfectadas = updateStmt.executeUpdate();

                    if (filasAfectadas > 0) {
                        JOptionPane.showMessageDialog(null, "✅ CD actualizado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "❌ Error al actualizar el CD");
                    }

                    updateStmt.close();
                }
            } else {
                JOptionPane.showMessageDialog(null, "❌ No se encontró el CD con código: " + codigoCD);
            }

            // Cerrar recursos
            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al editar el CD: " + e.getMessage());
        }
    }

    public static void editarDVD(String codigoDVD) {
        try {
            Connection conn = ConexionBD.conectar();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM dvd WHERE cdidentificacion = ?");
            pstmt.setString(1, codigoDVD);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Mostrar datos actuales del DVD
                String mensajeActual = "🎥 DATOS ACTUALES DEL DVD:\n\n"
                        + "Código: " + rs.getString("cdidentificacion") + "\n"
                        + "Título: " + rs.getString("titulo") + "\n"
                        + "Director: " + rs.getString("director") + "\n"
                        + "Género: " + rs.getString("genero") + "\n"
                        + "Duración: " + rs.getInt("duracion") + " minutos\n"
                        + "Stock: " + rs.getInt("stock");

                JOptionPane.showMessageDialog(null, mensajeActual, "Datos Actuales", JOptionPane.INFORMATION_MESSAGE);

                // Solicitar nuevos datos (con valores actuales como predeterminados)
                String titulo = JOptionPane.showInputDialog("Ingrese el nuevo título:", rs.getString("titulo"));
                if (titulo == null || titulo.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "❌ El título no puede estar vacío");
                    return;
                }

                String director = JOptionPane.showInputDialog("Ingrese el nuevo director:", rs.getString("director"));
                if (director == null || director.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "❌ El director no puede estar vacío");
                    return;
                }

                String genero = JOptionPane.showInputDialog("Ingrese el nuevo género:", rs.getString("genero"));
                if (genero == null || genero.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "❌ El género no puede estar vacío");
                    return;
                }

                int duracion;
                try {
                    duracion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva duración (minutos):", rs.getInt("duracion")));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "❌ La duración debe ser un número válido");
                    return;
                }

                int stock;
                try {
                    stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo stock:", rs.getInt("stock")));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "❌ El stock debe ser un número válido");
                    return;
                }

                // Confirmar la edición
                int confirmacion = JOptionPane.showConfirmDialog(
                        null,
                        "¿Está seguro de actualizar este DVD?\n\n"
                        + "Nuevos datos:\n"
                        + "Título: " + titulo + "\n"
                        + "Director: " + director + "\n"
                        + "Género: " + genero + "\n"
                        + "Duración: " + duracion + " minutos\n"
                        + "Stock: " + stock,
                        "Confirmar Edición",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirmacion == JOptionPane.YES_OPTION) {
                    // Actualizar en la base de datos
                    PreparedStatement updateStmt = conn.prepareStatement(
                            "UPDATE dvd SET titulo=?, director=?, genero=?, duracion=?, stock=? WHERE cdidentificacion=?"
                    );

                    updateStmt.setString(1, titulo);
                    updateStmt.setString(2, director);
                    updateStmt.setString(3, genero);
                    updateStmt.setInt(4, duracion);
                    updateStmt.setInt(5, stock);
                    updateStmt.setString(6, codigoDVD);

                    int filasAfectadas = updateStmt.executeUpdate();

                    if (filasAfectadas > 0) {
                        JOptionPane.showMessageDialog(null, "✅ DVD actualizado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "❌ Error al actualizar el DVD");
                    }

                    updateStmt.close();
                }
            } else {
                JOptionPane.showMessageDialog(null, "❌ No se encontró el DVD con código: " + codigoDVD);
            }

            // Cerrar recursos
            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al editar el DVD: " + e.getMessage());
        }
    }

    public static void eliminarMaterialAudiovisual() {
        try {
            // Verificar conexión a la base de datos
            if (!ConexionBD.verificarConexion()) {
                JOptionPane.showMessageDialog(null, "❌ No hay conexión a la base de datos");
                return;
            }

            // Obtener todos los libros y revistas
            Connection conexion = ConexionBD.conectar();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT cdidentificacion, titulo, 'cd' as tipo FROM cd UNION SELECT cdidentificacion, titulo, 'dvd' as tipo FROM dvd");

            List<String> materiales = new ArrayList<>();
            List<String> codigos = new ArrayList<>();
            List<String> tipos = new ArrayList<>();

            while (rs.next()) {
                String codigo = rs.getString("cdidentificacion");
                String titulo = rs.getString("titulo");
                String tipo = rs.getString("tipo");

                codigos.add(codigo);
                materiales.add(codigo + " - " + titulo + " (" + tipo + ")");
                tipos.add(tipo);
            }

            // Cerrar recursos
            rs.close();
            stmt.close();
            conexion.close();

            if (materiales.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay materiales escritos para eliminar.");
                return;
            }

            // Mostrar lista para eliminar
            String seleccion = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione el material a eliminar:",
                    "Eliminar Material Audiovisual",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    materiales.toArray(),
                    materiales.get(0)
            );

            if (seleccion != null) {
                int index = materiales.indexOf(seleccion);
                String codigo = codigos.get(index);
                String tipo = tipos.get(index);
                String titulo = seleccion.split(" - ")[1].split(" \\(")[0];

                // Confirmar eliminación
                int confirmacion = JOptionPane.showConfirmDialog(
                        null,
                        "¿Está seguro de eliminar:\n" + titulo + " (" + tipo + ")?",
                        "Confirmar Eliminación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );

                if (confirmacion == JOptionPane.YES_OPTION) {
                    // Eliminar de la base de datos
                    Connection conn = ConexionBD.conectar();
                    String tabla = tipo.equals("cd") ? "cd" : "dvd";

                    PreparedStatement pstmt = conn.prepareStatement("DELETE FROM " + tabla + " WHERE cdidentificacion = ?");
                    pstmt.setString(1, codigo);

                    int filasAfectadas = pstmt.executeUpdate();

                    if (filasAfectadas > 0) {
                        JOptionPane.showMessageDialog(null, "✅ " + (tipo.equals("cd") ? "CD" : "DVD") + " eliminado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "❌ Error al eliminar el material");
                    }

                    pstmt.close();
                    conn.close();
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al eliminar el material: " + e.getMessage());
        }
    }
}
