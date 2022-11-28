package com.example.cafeteria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        rcv.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        rcv.setAdapter(new AdaptadorRcv());
    }

    private void initViews() {
        this.rcv = findViewById(R.id.rec_Principal);
    }
}