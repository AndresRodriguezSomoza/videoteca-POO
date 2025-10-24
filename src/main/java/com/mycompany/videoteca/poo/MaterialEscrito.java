package com.mycompany.videoteca.poo;

public abstract class MaterialEscrito {
    protected String titulo;
    protected String autor;
    protected int anio;
    protected String editorial;

    public MaterialEscrito(String titulo, String autor, int anio, String editorial) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.editorial = editorial;
    }

    public abstract String mostrarInfo();
}