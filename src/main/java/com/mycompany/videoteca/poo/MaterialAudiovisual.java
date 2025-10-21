package com.mycompany.videoteca.poo;

public abstract class MaterialAudiovisual extends Material {
    protected String duracion;
    protected String genero;
    
    public MaterialAudiovisual(String codigo, String titulo, int unidadesDisponibles, 
                              String duracion, String genero) {
        super(codigo, titulo, unidadesDisponibles);
        this.duracion = duracion;
        this.genero = genero;
    }
    
    public String getDuracion() { return duracion; }
    public String getGenero() { return genero; }
}
