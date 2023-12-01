package com.example.myapplication.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;
/*
Esta clase nos permitira navegar a las noticias de Colombia
 */
public class Colombia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colombia);
    }
    //ir a ver las noticias de entretenimiento

    public void Entretenimiento (View view){
        Intent intent = new Intent(this, Entretenimiento.class);
        intent .putExtra("mensaje", "ColombiaEntretenimiento");
        startActivity(intent);
    }
    //ir a ver las noticias de deportes

    public void Deportes (View view){
        Intent intent= new Intent(this, Deportes.class);
        intent .putExtra("mensaje", "ColombiaDeportes");
        startActivity(intent);
    }
    //ir a ver las noticias de sociedad

    public void Social (View view){
        Intent intent= new Intent(this, Sociedad.class);
        intent .putExtra("mensaje", "ColombiaPolitica y Sociedad");
        startActivity(intent);
    }
    //Ir a ver las noticias de ciencia

    public void Ciencia (View view){
        Intent intent= new Intent(this, Ciencia.class);
        intent .putExtra("mensaje", "ColombiaCiencia");
        startActivity(intent);
    }
    //Ir a ver las noticias de economia

    public void Economia (View view){
        Intent intent= new Intent(this, Economia.class);
        intent .putExtra("mensaje", "ColombiaEconomía");
        startActivity(intent);
    }
}