package com.mycompany.videoteca.poo;

//La clase 'DVD' tiene herencia de la clase 'MaterialAudiovisual'
public abstract class DVD extends MaterialAudiovisual {

    private String director;

    public DVD(String director, String genre, int duracion) {
        super(null, null, 0, genre, duracion);
        this.director = director;
    }

    public DVD(String director, String genre, int duracion,
            String cdidentificacion, String title, int onStock) {
        super(cdidentificacion, title, onStock, genre, duracion);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String ShowInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append("🎬 DVD\n")
                .append("Código: ").append(getCdidentificacion())
                .append("\nTítulo: ").append(getTitle())
                .append("\nDirector: ").append(getDirector())
                .append("\nGénero: ").append(getGenre())
                .append("\nDuración: ").append(getDuracion()).append(" minutos")
                .append("\nEn stock: ").append(getOnStock());
        return sb.toString();
    }
}
