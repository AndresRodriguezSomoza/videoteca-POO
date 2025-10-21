package com.mycompany.videoteca.poo;

public class Libro extends MaterialEscrito {
    private String autor;
    private int numeroPaginas;
    private String isbn;
    private int añoPublicacion;
    
    public Libro(String codigo, String titulo, int unidadesDisponibles, String editorial,
                 String autor, int numeroPaginas, String isbn, int añoPublicacion) {
        super(codigo, titulo, unidadesDisponibles, editorial);
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.añoPublicacion = añoPublicacion;
    }
    
    @Override
    public String mostrarInformacion() {
        return "LIBRO:\n" +
               "Código: " + codigo + "\n" +
               "Título: " + titulo + "\n" +
               "Autor: " + autor + "\n" +
               "Editorial: " + editorial + "\n" +
               "ISBN: " + isbn + "\n" +
               "Año: " + añoPublicacion + "\n" +
               "Páginas: " + numeroPaginas + "\n" +
               "Unidades: " + unidadesDisponibles;
    }
}
