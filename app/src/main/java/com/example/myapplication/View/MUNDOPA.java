package com.example.myapplication.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.View.Colombia;
import com.example.myapplication.View.Ecuador;
import com.example.myapplication.View.Mexico;
import com.example.myapplication.View.Peru;

public class MUNDOPA extends AppCompatActivity {
    /*
    Esta clase nos permitira navegar a los diferentes paises
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mundopa);
    }

    public void Colombia (View view){
        Intent colombia= new Intent(this, Colombia.class);
        startActivity(colombia);

    }
    public void Mexico (View view){
        Intent mexico= new Intent(this, Mexico.class);
        startActivity(mexico);

    }
    public void Peru (View view){
        Intent peru= new Intent(this, Peru.class);
        startActivity(peru);

    }
    public void Ecuador (View view){
        Intent ecuador= new Intent(this, Ecuador.class);
        startActivity(ecuador);

    }

}