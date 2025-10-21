package com.mycompany.videoteca.poo;

public abstract class MaterialEscrito extends Material {
    protected String editorial;
    
    public MaterialEscrito(String codigo, String titulo, int unidadesDisponibles, String editorial) {
        super(codigo, titulo, unidadesDisponibles);
        this.editorial = editorial;
    }
    
    public String getEditorial() { return editorial; }
}
