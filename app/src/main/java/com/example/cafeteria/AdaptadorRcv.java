package com.example.cafeteria;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cafeteria.vistas.HolderRcV;

import java.util.ArrayList;

public class AdaptadorRcv extends RecyclerView.Adapter<HolderRcV> {

    ArrayList<HolderData> lista;
    public AdaptadorRcv() {
        this.lista = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            lista.add(new HolderData("bocata" + i));
        }

    }

    @NonNull
    @Override
    public HolderRcV onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rcv_item, parent, false);
        return new HolderRcV(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderRcV holder, int position) {
        holder.setTitulo(lista.get(position).nombre);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
