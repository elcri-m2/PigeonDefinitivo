package com.example.myapplication.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Model.LlamarDatosFirebase;
import com.example.myapplication.R;
import com.example.myapplication.modelView.MetodosFirebaseAplicacion;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.squareup.picasso.Picasso;

/*
Esta clase muestra todo lo relacionado con las noticias de interes social y politico

 */
public class Sociedad extends AppCompatActivity {

    private String Coleccion;
    private TextView NombreNoticia,Noticia,PaisOrigen,Fecha;
    private EditText Video,Link;

    private ImageView ImagenNoticia;
    int i=0;
    LlamarDatosFirebase c= new LlamarDatosFirebase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sociedad);
        Coleccion=getIntent().getStringExtra("mensaje");
        Noticia = findViewById(R.id.NoticiaC);
        NombreNoticia = findViewById(R.id.NombreNoticiaC);
        Video= (EditText)findViewById(R.id.videoC7);
        Link= (EditText)findViewById(R.id.linkC7);
        PaisOrigen=findViewById(R.id.PaisOrigenC);
        Fecha=findViewById(R.id.FechaC);
        ImagenNoticia= findViewById(R.id.ImagenNoticiaC);
    }
    //Este metodo nos permitira  poner los datos en los diferentes TextView
    /*
    Este metodo nos permitira obtener la informacion
    de la clase MetodosAplicacionFirebase, la cual nos
    da datos de forma sincronica a la ejecuccion de la plicacion
     */
    public void PonerNoticia(){
        MetodosFirebaseAplicacion H = new MetodosFirebaseAplicacion();
        H.PaisOrigenAsin().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    PaisOrigen.setText(task.getResult());
                } else {
                }
            }
        });
        H.NombreNoticiaAsin().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    NombreNoticia.setText(task.getResult());
                } else {
                }
            }
        });
        H.NoticiaAsin().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    Noticia.setText(task.getResult());
                } else {
                }
            }
        });
        H.VideoAsin().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    Video.setText(task.getResult());
                } else {
                }
            }
        });
        H.LinkAsin().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    Link.setText(task.getResult());
                } else {
                }
            }
        });
        H.fechaAsin().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    Fecha.setText(task.getResult());
                } else {
                }
            }
        });
        H.ImagenAsin().addOnCompleteListener(new OnCompleteListener<String>() {
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
    //Estos dos metodos nos permitiran navegar entre las noticias


    public void Adelante(View view) {
        i++;
        c.Coleccion= Coleccion;
        c.i=i;
        PonerNoticia();
    }
    public void Atras (View view) {

        if(i>0) {
            i--;
            c.Coleccion= Coleccion;
            c.i=i;
            PonerNoticia();
        }
    }
}
