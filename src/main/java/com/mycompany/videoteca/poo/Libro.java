package com.mycompany.videoteca.poo;

public class Libro extends MaterialEscrito {
    private String genero;
    private int paginas;

    public Libro(String titulo, String autor, int anio, String editorial, String genero, int paginas) {
        super(titulo, autor, anio, editorial);
        this.genero = genero;
        this.paginas = paginas;
    }

    @Override
    public String mostrarInfo() {
        return "📘 LIBRO\n" +
               "Título: " + titulo +
               "\nAutor: " + autor +
               "\nAño: " + anio +
               "\nEditorial: " + editorial +
               "\nGénero: " + genero +
               "\nPáginas: " + paginas;
    }
}