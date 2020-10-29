package com.bdl.mypets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Favorito extends AppCompatActivity {

    ArrayList<Datos_Mascotas> mas;
    private RecyclerView LisMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorito);

        Toolbar ActionBar = findViewById(R.id.actionbar);
        setSupportActionBar(ActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        LisMascotas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);

        LinearLayoutManager llam = new LinearLayoutManager(this);
        llam.setOrientation(LinearLayoutManager.VERTICAL);

        LisMascotas.setLayoutManager(llam);
        iniListaMascotas();
        iniAdaptador();

    }

    public void iniAdaptador (){
        MascotaAdaptador adaptador = new MascotaAdaptador(mas);
        LisMascotas.setAdapter(adaptador);
    }

    public void iniListaMascotas () {

        mas = new ArrayList<Datos_Mascotas>();
        mas.add(new Datos_Mascotas("Labrador",R.drawable.perro6));
        mas.add(new Datos_Mascotas("Men in black",R.drawable.perro1));
        mas.add(new Datos_Mascotas("Rotwailer",R.drawable.perro2));
        mas.add(new Datos_Mascotas("Ovejero",R.drawable.perro3));
        mas.add(new Datos_Mascotas("Bouvier de Flandes",R.drawable.perro5));

    }





}