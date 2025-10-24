package com.mycompany.videoteca.poo;

public abstract class Material {
  
    private String Cdidentificacion;
    private String title;
    private int OnStock;

    public Material() {
    }

    public Material(String Cdidentificacion, String title, int OnStock) {
        this.Cdidentificacion = Cdidentificacion;
        this.title = title;
        this.OnStock = OnStock;
    }
    
    //Getters
    public String getCdidentificacion() {
        return Cdidentificacion;
    }

    public String getTitle() {
        return title;
    }

    public int getOnStock() {
        return OnStock;
    }
    
    //Setters
    public void setCdidentificacion(String Cdidentificacion) {
        this.Cdidentificacion = Cdidentificacion;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOnStock(int OnStock) {
        this.OnStock = OnStock;
    }
    
    //Metodo crear CD-ID
    public String createCD (String identification){
    return "CD-"+identification+"-"+System.currentTimeMillis();
    }
    
    public abstract String ShowInformation();
}
