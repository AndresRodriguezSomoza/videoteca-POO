package com.mycompany.videoteca.poo;

public class Revista extends MaterialEscrito {
    private String periodicidad;
    private String fechaPublicacion;
    
    public Revista(String codigo, String titulo, int unidadesDisponibles, String editorial,
                   String periodicidad, String fechaPublicacion) {
        super(codigo, titulo, unidadesDisponibles, editorial);
        this.periodicidad = periodicidad;
        this.fechaPublicacion = fechaPublicacion;
    }
    
    @Override
    public String mostrarInformacion() {
        return "REVISTA:\n" +
               "Código: " + codigo + "\n" +
               "Título: " + titulo + "\n" +
               "Editorial: " + editorial + "\n" +
               "Periodicidad: " + periodicidad + "\n" +
               "Fecha: " + fechaPublicacion + "\n" +
               "Unidades: " + unidadesDisponibles;
    }
}
