package com.example.cafeteria.vistas;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cafeteria.R;
import com.example.cafeteria.modelos.DataEvent;

public class HolderEventList extends RecyclerView.ViewHolder {
    TextView titulo_evento;
    TextView des_evento;
    TextView fecha_evento;
    TextView hora_evento;
    public HolderEventList(@NonNull View itemView) {
        super(itemView);
        titulo_evento = itemView.findViewById(R.id.titulo_evento);
        des_evento = itemView.findViewById(R.id.des_evento);
        fecha_evento = itemView.findViewById(R.id.fecha_evento);
        hora_evento = itemView.findViewById(R.id.hora_evento);
    }

    public void update(DataEvent dataEvent) {
        titulo_evento.setText(dataEvent.titulo);
        des_evento.setText(dataEvent.descripcion);
        fecha_evento.setText(dataEvent.fecha);
        hora_evento.setText(dataEvent.hora);
    }
}
