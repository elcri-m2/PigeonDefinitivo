package com.example.myapplication.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;
/*
Esta clase nos permitira navegar a las noticias de Peru
 */
public class Peru extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peru);
    }
    //ir a ver las noticias de entretenimiento

    public void Entretenimiento (View view){
        Intent intent = new Intent(this, Entretenimiento.class);
        intent .putExtra("mensaje", "PeruEntretenimiento");
        startActivity(intent);
    }
    //ir a ver las noticias de deportes

    public void Deportes (View view){
        Intent intent= new Intent(this, Deportes.class);
        intent .putExtra("mensaje", "PeruDeportes");
        startActivity(intent);
    }
    //ir a ver las noticias de sociedad
    public void Social (View view){
        Intent intent= new Intent(this, Sociedad.class);
        intent .putExtra("mensaje", "PeruPolitica y Sociedad");
        startActivity(intent);
    }
    //Ir a ver las noticias de ciencia
    public void Ciencia (View view){
        Intent intent= new Intent(this, Ciencia.class);
        intent .putExtra("mensaje", "PeruCiencia");
        startActivity(intent);
    }
    //Ir a ver las noticias de economia
    public void Economia (View view){
        Intent intent= new Intent(this, Economia.class);
        intent .putExtra("mensaje", "PeruEconomía");
        startActivity(intent);
    }
}