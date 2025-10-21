package com.mycompany.videoteca.poo;

public class CD extends MaterialAudiovisual {
    private String artista;
    private int numeroCanciones;
    
    public CD(String codigo, String titulo, int unidadesDisponibles, 
              String duracion, String genero, String artista, int numeroCanciones) {
        super(codigo, titulo, unidadesDisponibles, duracion, genero);
        this.artista = artista;
        this.numeroCanciones = numeroCanciones;
    }
    
    @Override
    public String mostrarInformacion() {
        return "CD AUDIO:\n" +
               "Código: " + codigo + "\n" +
               "Título: " + titulo + "\n" +
               "Artista: " + artista + "\n" +
               "Género: " + genero + "\n" +
               "Duración: " + duracion + "\n" +
               "Canciones: " + numeroCanciones + "\n" +
               "Unidades: " + unidadesDisponibles;
    }
}
