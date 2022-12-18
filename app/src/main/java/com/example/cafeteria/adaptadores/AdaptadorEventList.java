package com.example.cafeteria.adaptadores;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cafeteria.R;
import com.example.cafeteria.modelos.DataEvent;
import com.example.cafeteria.vistas.HolderEventList;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AdaptadorEventList extends RecyclerView.Adapter<HolderEventList> {
    ArrayList<DataEvent> lista;

    public AdaptadorEventList() {
        lista = new ArrayList<DataEvent>();
        for (int i = 0; i < 10; i++) {

            lista.add(addData());
        }

    }

    private DataEvent addData() {

        DataEvent data = new DataEvent();
        String[] f = timeToDateTime(new Date().getTime());
        data.fecha = f[0];
        data.hora = f[1];
        data.titulo = "Torneo de ajedez";
        data.descripcion = "Descripcion suave";
        return data;
    }

    @NonNull
    @Override
    public HolderEventList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rcv_event_item, parent, false);
        return new HolderEventList(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderEventList holder, int position) {
        holder.update(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
    private String[] timeToDateTime(long time) {
        Date date = new Date(time);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String[] dateTime = {dateFormat.format(date), timeFormat.format(date)};
        return dateTime;
    }
}
