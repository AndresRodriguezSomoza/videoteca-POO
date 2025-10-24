package com.mycompany.videoteca.poo;

public abstract class CD extends MaterialAudiovisual {
    
     private String artista;
    private int numeroCanciones;
    private String discografica;

    public CD (String cdidentificacion, String title, int onStock,
                      String genre, int duracion, String artista, 
                      int numeroCanciones, String discografica) {
        super(cdidentificacion, title, onStock, genre, duracion);
        this.artista = artista;
        this.numeroCanciones = numeroCanciones;
        this.discografica = discografica;
    }

    // Getters y Setterss
    public String getArtista() { return artista; }
    public void setArtista(String artista) { this.artista = artista; }
    public int getNumeroCanciones() { return numeroCanciones; }
    public void setNumeroCanciones(int numeroCanciones) { this.numeroCanciones = numeroCanciones; }
    public String getDiscografica() { return discografica; }
    public void setDiscografica(String discografica) { this.discografica = discografica; }

    @Override
    public String ShowInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append("💿 DISCO DE MÚSICA\n")
          .append("Código: ").append(getCdidentificacion())
          .append("\nTítulo: ").append(getTitle())
          .append("\nArtista: ").append(artista)
          .append("\nDiscográfica: ").append(discografica)
          .append("\nGénero: ").append(getGenre())
          .append("\nDuración: ").append(getDuracion()).append(" minutos")
          .append("\nNúmero de canciones: ").append(numeroCanciones)
          .append("\nEn stock: ").append(getOnStock());
        return sb.toString();
    }
    
    
    
    
    
}
