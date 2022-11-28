package com.example.cafeteria.vistas;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cafeteria.R;

public class HolderRcV extends RecyclerView.ViewHolder {
    TextView texto;
    public HolderRcV(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        texto = itemView.findViewById(R.id.titulo);
    }
    public void setTitulo(String titulo){
        texto.setText(titulo);
    }
}
