package com.bdl.mypets;

public class Datos_Mascotas {

    private String nombre_mascota;
    private int foto;
    int fav;

    public Datos_Mascotas(String nombre_mascota, int foto) {
        this.nombre_mascota = nombre_mascota;
        this.foto = foto;
    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public int getFoto() {
        return foto;
    }

    public int getFav() {
        return fav;
    }

    public void setFav(int fav) {
        this.fav = fav;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
