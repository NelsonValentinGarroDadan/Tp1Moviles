package com.example.tp1;

import java.io.Serializable;

public class Palabra implements Serializable {
    private String palabra;
    private String Traduccion;
    private int Logo;

    public Palabra(String palabra, String traduccion, int logo) {
        this.palabra = palabra;
        this.Traduccion = traduccion;
        this.Logo = logo;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getTraduccion() {
        return Traduccion;
    }

    public void setTraduccion(String traduccion) {
        Traduccion = traduccion;
    }

    public int getLogo() {
        return Logo;
    }

    public void setLogo(int logo) {
        Logo = logo;
    }
}
