package com.example.myapplication.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class Ecuador extends AppCompatActivity {
       /*
Esta clase nos permitira navegar a las noticias de Ecuador
 */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecuador);
    }
    //ir a ver las noticias de entretenimiento
    public void Entretenimiento (View view){
        Intent intent = new Intent(this, Entretenimiento.class);
        intent .putExtra("mensaje", "EcuadorEntretenimiento");
        startActivity(intent);
    }
    //ir a ver las noticias de deportes
    public void Deportes (View view){
        Intent intent= new Intent(this, Deportes.class);
        intent .putExtra("mensaje", "EcuadorDeportes");
        startActivity(intent);
    }

    //ir a ver las noticias de sociedad

    public void Social (View view){
        Intent intent= new Intent(this, Sociedad.class);
        intent .putExtra("mensaje", "EcuadorPolitica y Sociedad");
        startActivity(intent);
    }
    //Ir a ver las noticias de ciencia

    public void Ciencia (View view){
        Intent intent= new Intent(this, Ciencia.class);
        intent .putExtra("mensaje", "EcuadorCiencia");
        startActivity(intent);
    }
    //Ir a ver las noticias de economia

    public void Economia (View view){
        Intent intent= new Intent(this, Economia.class);
        intent .putExtra("mensaje", "EcuadorEconomía");
        startActivity(intent);
    }
}