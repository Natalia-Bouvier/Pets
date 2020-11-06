package com.bdl.mypets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bdl.mypets.db.ConstantesBD;
import com.bdl.mypets.db.ConstructorPets;

import java.util.ArrayList;

public class MascotaAdaptador  extends RecyclerView.Adapter <MascotaAdaptador.MascotasViewHolder>{

    ArrayList<Datos_Mascotas> mascotas;
    Context context;

    public MascotaAdaptador (ArrayList<Datos_Mascotas> mascotas, Context context){
        this.mascotas = mascotas;
        this.context = context;
    }

    @Override
    public MascotasViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);

        return new MascotasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotasViewHolder mascotasViewHolder, int position) {
        final Datos_Mascotas mascota = mascotas.get(position);
        mascotasViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotasViewHolder.tvNombre.setText(mascota.getNombre_mascota());
        mascotasViewHolder.tvCont.setText(String.valueOf(mascota.getFav()));
        mascotasViewHolder.btLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int contador = mascota.getFav();
                mascota.setFav(++contador);
                mascotasViewHolder.tvCont.setText(String.valueOf(contador));
                ConstructorPets ctrPets = new ConstructorPets(context);
                ctrPets.dalLike(mascota);
            }
        });
        mascotasViewHolder.imgFavorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista
        return mascotas.size();
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private ImageButton btLike;
        private TextView tvNombre;
        private TextView tvCont;
        private ImageView imgFavorito;

         public MascotasViewHolder(View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            btLike = (ImageButton) itemView.findViewById(R.id.btLike);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvCont = (TextView) itemView.findViewById(R.id.tvCont);
            imgFavorito = (ImageView) itemView.findViewById(R.id.imgFavorito);
        }
    }

}
