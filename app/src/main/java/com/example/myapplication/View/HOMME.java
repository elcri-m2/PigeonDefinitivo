package com.example.myapplication.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.modelView.MetodosFirebaseAplicacion;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
/*
Esta clase HOMME sera la pantalla principal
de la aplicacion y el punto de inicio para
ir a cualquier parte de la aplicacion
 */
public class HOMME extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homme);



    }
    //ir a perfil, Donde se puede ver la informacion del usuario en curso
    public void Perfil (View view){
        Intent perfil= new Intent(this, Infromacion.class);
        startActivity(perfil);

    }

    //Ir a la clase siguiendo
    public void IrSiguiendo (View view){
        Intent irSiguiendo= new Intent(this, SIGUE.class);
        startActivity(irSiguiendo);

    }
    //Ir a ver las noticias de breakNews
    public void IrBreak (View view){
        MetodosFirebaseAplicacion Obtener= new MetodosFirebaseAplicacion();

        Obtener.PaisAsin().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    Intent irBreak= new Intent(getApplicationContext(), BREAK.class);
                    irBreak .putExtra("mensaje", task.getResult());
                    startActivity(irBreak);
                    startActivity(irBreak);

                } else {
                }
            }
        });

    }
    //Ir a ver las noticias del mundo
    public void IrMundo (View view){
        Intent irMundo= new Intent(this, MUNDO_PAISES.class);
        startActivity(irMundo);

    }
    //Ir a crear una noticia
    public void Crear (View view){
        Intent crear= new Intent(this, CrearNoticia.class);
        startActivity(crear);

    }
    //Ir a consultar un usuario
    public void Consultar (View view){
        Intent consultar= new Intent(this, Conir.class);
        startActivity(consultar);

    }


}

