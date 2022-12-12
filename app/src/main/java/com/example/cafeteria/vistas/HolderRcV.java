package com.example.cafeteria.vistas;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cafeteria.R;

public class HolderRcV extends RecyclerView.ViewHolder {
    TextView texto;
    ImageView promoView;

    public HolderRcV(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        texto = itemView.findViewById(R.id.titulo);
        promoView = itemView.findViewById(R.id.img_promocional);
    }
    public void setTitulo(String titulo){
        texto.setText(titulo);
    }

    public void setPromo(boolean isPromo) {
        if (isPromo){
            promoView.setVisibility(View.VISIBLE);
        }else{
            promoView.setVisibility(View.GONE);
        }

    }
}
