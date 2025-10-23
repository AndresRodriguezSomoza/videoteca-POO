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

    // Métodos Getters
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnio() { return anio; }
    public String getEditorial() { return editorial; }

    // Método abstracto (cada tipo mostrará su información)
    public abstract String mostrarInfo();
}