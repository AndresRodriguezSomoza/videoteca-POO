package com.mycompany.videoteca.poo;

public class Libro extends MaterialEscrito {

    private String autor;
    private int numeroDePaginas;
    private String isbn;
    private int añoDePublicacion;

    public Libro(String cdidentificacion, String title, int onStock,
            String publisher, String autor, int numeroDePaginas,
            String isbn, int añoDePublicacion) {
        super(cdidentificacion, title, onStock, publisher);
        this.autor = autor;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.añoDePublicacion = añoDePublicacion;
    }

    // Getters y Setters
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAñoDePublicacion() {
        return añoDePublicacion;
    }

    public void setAñoDePublicacion(int añoDePublicacion) {
        this.añoDePublicacion = añoDePublicacion;
    }

    @Override
    public String ShowInformation() {
        return "📘 LIBRO\n"
                + "Código: " + getCdidentificacion()
                + "\nTítulo: " + getTitle()
                + "\nAutor: " + autor
                + "\nISBN: " + isbn
                + "\nAño de publicación: " + añoDePublicacion
                + "\nEditorial: " + publisher
                + "\nPáginas: " + numeroDePaginas
                + "\nEn stock: " + getOnStock();
    }
}
