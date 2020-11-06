package com.bdl.mypets;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bdl.mypets.db.ConstructorPets;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    ArrayList<Datos_Mascotas> mascotas;
    private RecyclerView ListaMascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        ListaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        ListaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializaAdaptador();
        return v;
    }

    public void inicializaAdaptador (){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getContext());
        ListaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas () {

       mascotas = new ArrayList<Datos_Mascotas>();

        ConstructorPets ctrPets = new ConstructorPets(getContext());

        mascotas.addAll(ctrPets.obtenerDatos());

        //mascotas.add(new Datos_Mascotas("Labrador",R.drawable.perro6,1));
        //mascotas.add(new Datos_Mascotas("Men in black",R.drawable.perro1,2));
       // mascotas.add(new Datos_Mascotas("Rotwailer",R.drawable.perro2,3));
       // mascotas.add(new Datos_Mascotas("Ovejero Aleman",R.drawable.perro3,4));
        //mascotas.add(new Datos_Mascotas("Bouvier de Berna",R.drawable.perro5,5));

    }
}
