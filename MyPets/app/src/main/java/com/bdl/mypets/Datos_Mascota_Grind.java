package com.bdl.mypets;

public class Datos_Mascota_Grind {

    private int fotoPerro;
    private String Megusta;
    int hueso_amarillo;

    public Datos_Mascota_Grind(int fotoPerro, String megusta, int hueso_amarillo) {
        this.fotoPerro = fotoPerro;
        Megusta = megusta;
        this.hueso_amarillo = hueso_amarillo;
    }

    public int getFotoPerro() {
        return fotoPerro;
    }

    public void setFotoPerro(int fotoPerro) {
        this.fotoPerro = fotoPerro;
    }

    public String getMegusta() {
        return Megusta;
    }

    public void setMegusta(String megusta) {
        Megusta = megusta;
    }

    public int getHueso_amarillo() {
        return hueso_amarillo;
    }

    public void setHueso_amarillo(int hueso_amarillo) {
        this.hueso_amarillo = hueso_amarillo;
    }
}
