package com.bdl.mypets.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.bdl.mypets.Datos_Mascotas;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos( Context context) {
        super(context, ConstantesBD.DATABASE_NAME, null, ConstantesBD.DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryCreateTablePets = "CREATE TABLE " + ConstantesBD.TABLE_PETS + "(" +
                                      ConstantesBD.TABLE_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                      ConstantesBD.TABLE_PETS_NOMBRE + " TEXT, " +
                                      ConstantesBD.TABLE_PETS_FOTO + " INTEGER" +
                                      ")";

        String queryCreateTableFav = "CREATE TABLE " + ConstantesBD.TABLE_FAV_PET + "(" +
                                                      ConstantesBD.TABLE_FAV_PET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                      ConstantesBD.TABLE_FAV_PET_ID_PETS + " INTEGER," +
                                                      ConstantesBD.TABLE_FAV_PET_NUMFAV + " INTEGER, " +
                                                      "FOREIGN KEY (" + ConstantesBD.TABLE_FAV_PET_ID_PETS + ") " +
                                                      "REFERENCES "+ ConstantesBD.TABLE_PETS + "(" + ConstantesBD.TABLE_PETS_ID + ")" +
                ")";

        sqLiteDatabase.execSQL(queryCreateTablePets);
        sqLiteDatabase.execSQL(queryCreateTableFav);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + ConstantesBD.TABLE_PETS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + ConstantesBD.TABLE_FAV_PET);
        onCreate(sqLiteDatabase);

    }

    public ArrayList<Datos_Mascotas> obtenerTodosLasMascotas() {
        ArrayList<Datos_Mascotas> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBD.TABLE_PETS;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor registros = sqLiteDatabase.rawQuery(query, null);

        while (registros.moveToNext()) {

            Datos_Mascotas mascotaActual= new Datos_Mascotas();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre_mascota(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));


            // OBTENGO FAVORITOS
            String queryFavoritos = "SELECT * FROM " + ConstantesBD.TABLE_FAV_PET + " WHERE " + ConstantesBD.TABLE_FAV_PET_ID_PETS + " = " +  mascotaActual.getId();
            Cursor registrosFavoritos = sqLiteDatabase.rawQuery(queryFavoritos, null);
            int cantFavoritos = registrosFavoritos.getCount();
            mascotaActual.setFav(cantFavoritos);

            mascotas.add(mascotaActual);

        }

        sqLiteDatabase.close();


        return mascotas;
    }

    public ArrayList<Datos_Mascotas> obtenerTop5Mascotas() {
        ArrayList<Datos_Mascotas> mascotas = new ArrayList<>();

        String queryTop5 = "SELECT " + ConstantesBD.TABLE_FAV_PET_ID_PETS + ", COUNT(" + ConstantesBD.TABLE_FAV_PET_NUMFAV + ") as ContFav" + " FROM " + ConstantesBD.TABLE_FAV_PET + " GROUP BY " + ConstantesBD.TABLE_FAV_PET_ID_PETS + " ORDER BY ContFav DESC LIMIT 5";
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor registrosTop5 = sqLiteDatabase.rawQuery(queryTop5, null);

        while (registrosTop5.moveToNext()) {

            int idMascota = registrosTop5.getInt(0);
            int cantFav = registrosTop5.getInt(1);


            String queryMascota = "SELECT * FROM " + ConstantesBD.TABLE_PETS + " WHERE " + ConstantesBD.TABLE_PETS_ID + " = " + idMascota;
            Cursor registrosMascotas = sqLiteDatabase.rawQuery(queryMascota, null);

            if(registrosMascotas.moveToNext()){
                Datos_Mascotas mascotaActual= new Datos_Mascotas();
                mascotaActual.setId(registrosMascotas.getInt(0));
                mascotaActual.setNombre_mascota(registrosMascotas.getString(1));
                mascotaActual.setFoto(registrosMascotas.getInt(2));
                mascotaActual.setFav(cantFav);

                mascotas.add(mascotaActual);
            }
        }

        sqLiteDatabase.close();

        return mascotas;
    }

    public void insertarMascotas(ContentValues contentValues){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(ConstantesBD.TABLE_PETS,null, contentValues);
        sqLiteDatabase.close();
    }

    public void insertarLikeMascotas(ContentValues cv){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_FAV_PET, null, cv);
        db.close();
    }
}
