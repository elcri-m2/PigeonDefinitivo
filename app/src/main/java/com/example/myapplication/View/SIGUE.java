package com.example.myapplication.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Model.LlamarDatosFirebase;
import com.example.myapplication.R;
import com.example.myapplication.View.Seguir;
import com.example.myapplication.modelView.MetodosFirebaseAplicacion;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.squareup.picasso.Picasso;
/*
Etsa clase muestra las noticias de los usuarios que sigue el dueño de la cuenta
 */
public class SIGUE extends AppCompatActivity {
    private TextView NombreNoticia,Noticia,Video,Link,TipoNoticia,PaisOrigen,Fecha;
    private ImageView ImagenNoticia;
    public static int k;
    LlamarDatosFirebase c= new LlamarDatosFirebase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigue);
        SIGUE.k=c.sizeX;
        Noticia = findViewById(R.id.NoticiaC);
        NombreNoticia = findViewById(R.id.nombreNoticiaC2);
        Video=  findViewById(R.id.VideoC);
        Link= findViewById(R.id.LinkC);
        TipoNoticia=findViewById(R.id.TipoNoticiaN);
        PaisOrigen=findViewById(R.id.PaisOrigenC);
        ImagenNoticia= findViewById(R.id.ImagenNoticiaC);
    }
    public void Seguir (View view){
        Intent seguir= new Intent(this, Seguir.class);
        startActivity(seguir);
    }
    public void Adelante(View view) {
        SIGUE.k--;
        c.i=SIGUE.k;
        PonerNoticia();
    }
    public void Atras (View view) {

        if(SIGUE.k>0) {
            SIGUE.k++;
            c.i=SIGUE.k;
            PonerNoticia();
        }
    }
    public void PonerNoticia(){
        MetodosFirebaseAplicacion H = new MetodosFirebaseAplicacion();
        H.PaisOrigenAsinS().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    PaisOrigen.setText(task.getResult());
                } else {
                }
            }
        });
        H.NombreNoticiaAsinS().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    NombreNoticia.setText(task.getResult());
                } else {
                }
            }
        });
        H.NoticiaAsinS().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    Noticia.setText(task.getResult());
                } else {
                }
            }
        });
        H.VideoAsinS().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    Video.setText(task.getResult());
                } else {
                }
            }
        });
        H.LinkAsinS().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    Link.setText(task.getResult());
                } else {
                }
            }
        });
        H.TipoNoticiaAsinS().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    TipoNoticia.setText(task.getResult());
                } else {
                }
            }
        });
        H.ImagenAsinS().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    String foto = String.valueOf(task.getResult());
                    Picasso.get().load(foto).into(ImagenNoticia);
                } else {
                }
            }
        });
    }
}