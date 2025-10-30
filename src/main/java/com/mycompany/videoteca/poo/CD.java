package com.mycompany.videoteca.poo;

//La clase 'CD' tiene herencia de la clase 'MaterialAudiovisual'
public abstract class CD extends MaterialAudiovisual {

    private String artista;
    private int numeroCanciones;

    public CD(String cdidentificacion, String title, int onStock,
            String genre, int duracion, String artista,
            int numeroCanciones) {
        super(cdidentificacion, title, onStock, genre, duracion);
        this.artista = artista;
        this.numeroCanciones = numeroCanciones;
    }

    // Getters y Setters
    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getNumeroCanciones() {
        return numeroCanciones;
    }

    public void setNumeroCanciones(int numeroCanciones) {
        this.numeroCanciones = numeroCanciones;
    }

    @Override
    public String ShowInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append("💿 DISCO DE MÚSICA\n")
                .append("Código: ").append(getCdidentificacion())
                .append("\nTítulo: ").append(getTitle())
                .append("\nArtista: ").append(artista)
                .append("\nGénero: ").append(getGenre())
                .append("\nDuración: ").append(getDuracion()).append(" minutos")
                .append("\nNúmero de canciones: ").append(numeroCanciones)
                .append("\nEn stock: ").append(getOnStock());
        return sb.toString();
    }
}
