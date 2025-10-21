package com.mycompany.videoteca.poo;

public abstract class Material {
    protected String codigo;
    protected String titulo;
    protected int unidadesDisponibles;
    
    public Material(String codigo, String titulo, int unidadesDisponibles) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.unidadesDisponibles = unidadesDisponibles;
    }
    
    // Getters
    public String getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public int getUnidadesDisponibles() { return unidadesDisponibles; }
    
    // Método abstracto
    public abstract String mostrarInformacion();
}
