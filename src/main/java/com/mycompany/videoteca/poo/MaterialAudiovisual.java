package com.mycompany.videoteca.poo;

public abstract class MaterialAudiovisual extends Material {
    
    private String genre;
    private int duracion;

    public MaterialAudiovisual() {
        super();
    }

    // Constructor corregido - el orden debe ser consistente
    public MaterialAudiovisual(String cdidentificacion, String title, int onStock, 
                              String genre, int duracion) {
        super(cdidentificacion, title, onStock);
        this.genre = genre;
        this.duracion = duracion;
    }

    // Getters y Setters (usando minúsculas para atributos)
    public String getGenre() {
        return genre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    

   
    
    
    
}
