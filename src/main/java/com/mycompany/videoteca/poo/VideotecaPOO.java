package com.mycompany.videoteca.poo;

import javax.swing.*;import java.util.ArrayList;
import java.util.List;

public class VideotecaPOO {
    static List<MaterialEscrito> materialesEscritos = new ArrayList<>();
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
            String[] opciones = {"Registrar Libro", "Registrar Revista", "Ver Materiales", "Volver"};
            
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
                    return;
                default:
                    return;
            }
        }
    }
    
    public static void menuAudiovisual() {
        while (true) {
            String[] opciones = {"Registrar CD", "Registrar DVD", "Ver Materiales", "Volver"};
            
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
                    return;
                default:
                    return;
            }
        }
    }
    
    public static void ingresarLibro() {
    String titulo = JOptionPane.showInputDialog("Título del libro:");
    String autor = JOptionPane.showInputDialog("Autor:");
    int anio = Integer.parseInt(JOptionPane.showInputDialog("Año de publicación:"));
    String editorial = JOptionPane.showInputDialog("Editorial:");
    String genero = JOptionPane.showInputDialog("Género:");
    int paginas = Integer.parseInt(JOptionPane.showInputDialog("Número de páginas:"));

    Libro libro = new Libro(titulo, autor, anio, editorial, genero, paginas);
    materialesEscritos.add(libro);

    JOptionPane.showMessageDialog(null, "✅ Libro registrado correctamente.");
}
    
    public static void ingresarRevista() {
    String titulo = JOptionPane.showInputDialog("Título de la revista:");
    String autor = JOptionPane.showInputDialog("Autor o editor:");
    int anio = Integer.parseInt(JOptionPane.showInputDialog("Año de publicación:"));
    String editorial = JOptionPane.showInputDialog("Editorial:");
    int edicion = Integer.parseInt(JOptionPane.showInputDialog("Número de edición:"));
    String categoria = JOptionPane.showInputDialog("Categoría:");

    Revista revista = new Revista(titulo, autor, anio, editorial, edicion, categoria);
    materialesEscritos.add(revista);

    JOptionPane.showMessageDialog(null, "✅ Revista registrada correctamente.");
}
    
    
    public static void ingresarCD() {
    String titulo = JOptionPane.showInputDialog("Título del CD:");
    String artista = JOptionPane.showInputDialog("Artista o grupo:");
    int anio = Integer.parseInt(JOptionPane.showInputDialog("Año de lanzamiento:"));
    String genero = JOptionPane.showInputDialog("Género musical:");
    int duracion = Integer.parseInt(JOptionPane.showInputDialog("Duración (en minutos):"));
    
    String cdInfo = "🎵 CD\nTítulo: " + titulo +
                    "\nArtista: " + artista +
                    "\nAño: " + anio +
                    "\nGénero: " + genero +
                    "\nDuración: " + duracion + " min";
    
    materialesAudiovisuales.add(cdInfo);
    JOptionPane.showMessageDialog(null, "✅ CD registrado correctamente.");
}
    
    public static void ingresarDVD() {
    String titulo = JOptionPane.showInputDialog("Título del DVD:");
    String director = JOptionPane.showInputDialog("Director:");
    int anio = Integer.parseInt(JOptionPane.showInputDialog("Año de lanzamiento:"));
    String genero = JOptionPane.showInputDialog("Género cinematográfico:");
    int duracion = Integer.parseInt(JOptionPane.showInputDialog("Duración (en minutos):"));
    
    String dvdInfo = "💿 DVD\nTítulo: " + titulo +
                     "\nDirector: " + director +
                     "\nAño: " + anio +
                     "\nGénero: " + genero +
                     "\nDuración: " + duracion + " min";
    
    materialesAudiovisuales.add(dvdInfo);
    JOptionPane.showMessageDialog(null, "✅ DVD registrado correctamente.");
}
    public static void mostrarEscritos() {
    if (materialesEscritos.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No hay materiales escritos registrados.");
        return;
    }

    StringBuilder sb = new StringBuilder("📚 MATERIALES ESCRITOS REGISTRADOS:\n\n");
    for (MaterialEscrito m : materialesEscritos) {
        sb.append(m.mostrarInfo()).append("\n--------------------\n");
    }

    JOptionPane.showMessageDialog(null, sb.toString());
}
    
    public static void mostrarAudiovisuales() {
    if (materialesAudiovisuales.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No hay materiales audiovisuales registrados.");
        return;
    }

    StringBuilder sb = new StringBuilder("🎬 MATERIALES AUDIOVISUALES REGISTRADOS:\n\n");
    for (String m : materialesAudiovisuales) {
        sb.append(m).append("\n--------------------\n");
    }

    JOptionPane.showMessageDialog(null, sb.toString());
}
    }