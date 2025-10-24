package com.mycompany.videoteca.poo;

public class Revista extends MaterialEscrito {
    private int edicion;
    private String categoria;

    public Revista(String titulo, String autor, int anio, String editorial, int edicion, String categoria) {
        super(titulo, autor, anio, editorial);
        this.edicion = edicion;
        this.categoria = categoria;
    }

    @Override
    public String mostrarInfo() {
        return "📰 REVISTA\n" +
               "Título: " + titulo +
               "\nAutor/Editor: " + autor +
               "\nAño: " + anio +
               "\nEditorial: " + editorial +
               "\nEdición: " + edicion +
               "\nCategoría: " + categoria;
    }
}