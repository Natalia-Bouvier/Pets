package com.bdl.mypets;

public class Datos_Mascotas {

    private String nombre_mascota;
    private int foto;
    int fav;
    int id;

    public Datos_Mascotas(String nombre_mascota, int foto, int id) {
        this.nombre_mascota = nombre_mascota;
        this.foto = foto;
        this.id = id;
    }

    public Datos_Mascotas() {

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getFav() {
        return fav;
    }
    public void setFav(int fav) {
        this.fav = fav;
    }

}
