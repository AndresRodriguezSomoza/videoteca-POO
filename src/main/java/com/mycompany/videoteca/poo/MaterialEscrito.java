package com.mycompany.videoteca.poo;

//La clase 'MaterialEscrito' tiene herencia de la clase 'Material'
public abstract class MaterialEscrito extends Material {
    protected String publisher;

    public MaterialEscrito(String cdidentificacion, String title, int onStock, String publisher) {
        super(cdidentificacion, title, onStock);
        this.publisher = publisher;
    }

    // Getter y Setter
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public abstract String ShowInformation();
}
