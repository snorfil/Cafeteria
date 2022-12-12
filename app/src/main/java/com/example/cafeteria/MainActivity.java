package com.example.cafeteria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cafeteria.vistas.Login;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcv;
    TextView menu1;
    FrameLayout contenedor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        listeners();
        rcv.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        rcv.setAdapter(new AdaptadorRcv());
    }

    private void listeners() {
        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.contenedor,new Login(),"login").
                        commit();
            }
        });
    }

    private void initViews() {
        this.contenedor = findViewById(R.id.contenedor);
        this.rcv = findViewById(R.id.rec_Principal);
        this.menu1 = findViewById(R.id.menu_1);
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment f = fm.findFragmentByTag("login");
        if (f != null){
            FragmentTransaction ft = fm.beginTransaction();
            ft.remove(f);
            ft.commit();
        }
        else{
            super.onBackPressed();
        }
    }
}