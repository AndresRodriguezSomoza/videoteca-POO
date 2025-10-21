package com.mycompany.videoteca.poo;

public class DVD extends MaterialAudiovisual {
    private String director;
    
    public DVD(String codigo, String titulo, int unidadesDisponibles, 
               String duracion, String genero, String director) {
        super(codigo, titulo, unidadesDisponibles, duracion, genero);
        this.director = director;
    }
    
    @Override
    public String mostrarInformacion() {
        return "DVD:\n" +
               "Código: " + codigo + "\n" +
               "Título: " + titulo + "\n" +
               "Director: " + director + "\n" +
               "Género: " + genero + "\n" +
               "Duración: " + duracion + "\n" +
               "Unidades: " + unidadesDisponibles;
    }
}
