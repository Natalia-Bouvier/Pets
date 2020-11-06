package com.bdl.mypets.db;

import android.content.ContentValues;
import android.content.Context;

import com.bdl.mypets.Datos_Mascotas;
import com.bdl.mypets.R;

import java.util.ArrayList;

public class ConstructorPets {

    private Context context;
    public ConstructorPets(Context context) {
        this.context = context;

    }



    public ArrayList<Datos_Mascotas> obtenerDatos() {
       /* ArrayList<Datos_Mascotas> mascotas = new ArrayList<>();
        mascotas.add(new Datos_Mascotas("Labrador", R.drawable.perro6));
        mascotas.add(new Datos_Mascotas("Men in black",R.drawable.perro1));
        mascotas.add(new Datos_Mascotas("Rotwailer",R.drawable.perro2));
        mascotas.add(new Datos_Mascotas("Ovejero",R.drawable.perro3));
        mascotas.add(new Datos_Mascotas("Bouvier de Flandes",R.drawable.perro5));
        return mascotas;*/

        BaseDatos sqLiteDatabase = new BaseDatos(context);
        insertarCincoMascotas(sqLiteDatabase);
        return sqLiteDatabase.obtenerTodosLasMascotas();
    }

    public ArrayList<Datos_Mascotas> obtenerDatosTop5() {
        BaseDatos sqLiteDatabase = new BaseDatos(context);
        insertarCincoMascotas(sqLiteDatabase);
        return sqLiteDatabase.obtenerTop5Mascotas();
    }

    public void insertarCincoMascotas(BaseDatos sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Labrador");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO,R.drawable.perro6);

        sqLiteDatabase.insertarMascotas(contentValues);

        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Men in black");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO,R.drawable.perro1);

        sqLiteDatabase.insertarMascotas(contentValues);

        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Rotwailer");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO,R.drawable.perro2);

        sqLiteDatabase.insertarMascotas(contentValues);

        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Ovejero Aleman");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO,R.drawable.perro3);

        sqLiteDatabase.insertarMascotas(contentValues);

        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Bouvier de Berna");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO,R.drawable.perro5);

        sqLiteDatabase.insertarMascotas(contentValues);
    }

    public void dalLike(Datos_Mascotas mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues cv = new ContentValues();
        cv.put(ConstantesBD.TABLE_FAV_PET_ID_PETS, mascota.getId());
        cv.put(ConstantesBD.TABLE_FAV_PET_NUMFAV, 1);
        db.insertarLikeMascotas(cv);
    }
}
