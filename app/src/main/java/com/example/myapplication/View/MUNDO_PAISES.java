package com.example.myapplication.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;
/*
Esta clase nos permitira navegar entre ver
Las Noticias del mundo hoy y Buscar un pais
 */
public class MUNDO_PAISES extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mundo_paises);
    }
    public void BuscaUn (View view){
        Intent buscaun= new Intent(this, MUNDOBUS.class);
        startActivity(buscaun);

    }
    public void MundoHoy (View view){
        Intent mundohoy= new Intent(this, MUNDOPA.class);
        startActivity(mundohoy);

    }
}