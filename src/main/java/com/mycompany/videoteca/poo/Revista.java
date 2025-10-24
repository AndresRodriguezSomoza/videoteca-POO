package com.mycompany.videoteca.poo;

public class Revista extends MaterialEscrito {
    private int numeroEdicion;
    private String categoria;

    public Revista(String titulo, String autor, int anio, String editorial, int numeroEdicion, String categoria) {
        super(titulo, autor, anio, editorial);
        this.numeroEdicion = numeroEdicion;
        this.categoria = categoria;
    }

    public int getNumeroEdicion() { return numeroEdicion; }
    public String getCategoria() { return categoria; }

    @Override
    public String mostrarInfo() {
        return "📰 REVISTA\nTítulo: " + titulo +
               "\nAutor: " + autor +
               "\nAño: " + anio +
               "\nEditorial: " + editorial +
               "\nEdición: " + numeroEdicion +
               "\nCategoría: " + categoria;
    }
}