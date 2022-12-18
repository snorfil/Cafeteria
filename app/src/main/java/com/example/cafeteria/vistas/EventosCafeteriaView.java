package com.example.cafeteria.vistas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cafeteria.R;
import com.example.cafeteria.adaptadores.AdaptadorEventList;


public class EventosCafeteriaView extends Fragment {

    RecyclerView recyclerView ;
    AdaptadorEventList adaptadorEventList;




    public EventosCafeteriaView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_eventos_cafeteria, container, false);
        recyclerView = v.findViewById(R.id.event_list_rcv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        adaptadorEventList = new AdaptadorEventList();
        recyclerView.setAdapter(adaptadorEventList);

        return v ;
    }
}