package com.mycompany.videoteca.poo;

//La clase 'Revista' tiene herencia de la clase 'MaterialEscrito'
public class Revista extends MaterialEscrito {
    private String periocidad;
    private String fechaPubli;

    public Revista(String cdidentificacion, String title, int onStock, 
                   String publisher, String periocidad, String fechaPubli) {
        super(cdidentificacion, title, onStock, publisher);
        this.periocidad = periocidad;
        this.fechaPubli = fechaPubli;
    }

    // Getters y Setters
    public String getPeriocidad() {
        return periocidad;
    }

    public void setPeriocidad(String periocidad) {
        this.periocidad = periocidad;
    }

    public String getFechaPubli() {
        return fechaPubli;
    }

    public void setFechaPubli(String fechaPubli) {
        this.fechaPubli = fechaPubli;
    }

    @Override
    public String ShowInformation() {
        return "📰 REVISTA\n" +
               "Código: " + getCdidentificacion() +
               "\nTítulo: " + getTitle() +
               "\nEditorial: " + getPublisher() +
               "\nPeriodicidad: " + periocidad +
               "\nFecha de publicación: " + fechaPubli +
               "\nEn stock: " + getOnStock();
    }
}
