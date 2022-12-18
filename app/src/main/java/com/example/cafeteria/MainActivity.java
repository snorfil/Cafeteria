package com.example.cafeteria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.telephony.TelephonyCallback;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cafeteria.adaptadores.AdaptadorRcv;
import com.example.cafeteria.vistas.Login;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcv;
    ConstraintLayout fondoMenu;
    TextView puntos;
    TextView titulo_puntos;
    TextView eventos;
    FrameLayout contenedor;
    ImageView img_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        listeners();
        rcv.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        rcv.setAdapter(new AdaptadorRcv());
    }

    @SuppressLint("ClickableViewAccessibility")
    private void listeners() {
        fondoMenu.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {


                float x = event.getX();
                float y = event.getY();

                int action = event.getAction();

                // Check which action occurred
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Code for when the user presses down on the view
                        break;
                    case MotionEvent.ACTION_MOVE:
                        revision(x);
                        break;
                    case MotionEvent.ACTION_UP:
                        revision(x);
                        getSupportFragmentManager().
                                beginTransaction().
                                replace(R.id.contenedor,new Login(),"login").
                                commit();
                        return false;
                }
                return true;
            }

        });

    }

    private void revision(float x) {
        if(isWithinXBounds(x,puntos)){
        Log.e("entro en puntos","jf");
}
        if(isWithinXBounds(x,img_user)){
            Log.e("entro en img_user","jf");
        }
        if(isWithinXBounds(x,titulo_puntos)){
            Log.e("entro en titulo_puntos","jf");
        }
        if(isWithinXBounds(x,eventos)){
            Log.e("entro en eventos","jf");
        }
    }

    public boolean isWithinXBounds(float x, View view) {
        // Get the view's location
        int[] location = new int[2];
        view.getLocationOnScreen(location);

        // Calculate the view's coordinates
        int viewX = location[0];

        // Check if the x coordinate is within the view
        if (x > viewX && x < (viewX + view.getWidth())) {
            // The x coordinate is within the view
            return true;
        } else {
            // The x coordinate is outside the view
            return false;
        }
    }

    private void initViews() {
        this.img_user = findViewById(R.id.img_usuario);
        this.fondoMenu = findViewById(R.id.fondo_menu);
        this.contenedor = findViewById(R.id.contenedor);
        this.rcv = findViewById(R.id.rec_Principal);
        this.eventos = findViewById(R.id.menu_eventos);
        this.puntos = findViewById(R.id.puntos);
        this.titulo_puntos = findViewById(R.id.puntos_titulo);
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