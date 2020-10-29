package com.bdl.mypets;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptadorGrind extends RecyclerView.Adapter <MascotaAdaptadorGrind.MascotasViewHolder>{

    ArrayList<Datos_Mascota_Grind> mas;

    public MascotaAdaptadorGrind(ArrayList<Datos_Mascota_Grind> mas) {
        this.mas = mas;
    }

    @Override
    public MascotasViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View x = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas_grind, parent, false);

        return new MascotasViewHolder(x);
    }

    @Override
    public void onBindViewHolder(final MascotasViewHolder mascotasViewHolder, int position) {
        final Datos_Mascota_Grind mascotas = mas.get(position);
        mascotasViewHolder.imgFotoPerro.setImageResource(mascotas.getFotoPerro());
        mascotasViewHolder.imgHuesoAmarrillo.setImageResource(mascotas.getHueso_amarillo());
        mascotasViewHolder.tvMegusta.setText(mascotas.getMegusta());

    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista
        return mas.size();
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoPerro;
        private ImageView imgHuesoAmarrillo;
        private TextView tvMegusta;

        public MascotasViewHolder(View itemView) {
            super(itemView);
            imgFotoPerro = (ImageView) itemView.findViewById(R.id.imgFotoPerro);
            imgHuesoAmarrillo = (ImageView) itemView.findViewById(R.id.imgHuesoAmarrillo);
            tvMegusta = (TextView) itemView.findViewById(R.id.tvMegusta);


        }
    }

}
