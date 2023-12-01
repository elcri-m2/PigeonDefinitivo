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
import com.example.myapplication.modelView.MetodosAplicacion;
import com.example.myapplication.modelView.MetodosFirebaseAplicacion;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.squareup.picasso.Picasso;
/*
En esta clse se mostraran las noticias ddiarias
del pais en el que se encuentra el usuario
 */
public class BREAK extends AppCompatActivity {
    private TextView NombreNoticia,Noticia,TipoNoticia,PaisOrigen;
    private EditText Video,Link;
    private ImageView ImagenNoticia;
    int i;

    public static String Coleccion;

    LlamarDatosFirebase c= new LlamarDatosFirebase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_break);
        MetodosAplicacion v= new MetodosAplicacion();
        BREAK.Coleccion=v.Fecha()+getIntent().getStringExtra("mensaje");;
        Noticia = findViewById(R.id.NoticiaC);
        NombreNoticia = findViewById(R.id.nombreNoticiaC2);
        Video= (EditText)findViewById(R.id.videoC);
        Link= (EditText)findViewById(R.id.linkC);
        TipoNoticia=findViewById(R.id.TipoNoticiaN);
        PaisOrigen=findViewById(R.id.PaisOrigenC);
        ImagenNoticia= findViewById(R.id.ImagenNoticiaC);
    }
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
        H.TipoNoticiaAsin().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    TipoNoticia.setText(task.getResult());
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

    public void Adelante(View view) {
        i++;
        c.Coleccion= Coleccion;
        setNumero(i);
        c.i=i;
        getNumero();
        PonerNoticia();
    }
    public void Atras (View view) {

        if(i>0) {
            i--;
            c.Coleccion= Coleccion;
            c.i=i;
            setNumero(i);
            getNumero();
            PonerNoticia();

        }
    }
    public void setNumero(int i){
        this.i=i;
    }
    public String getNumero(){
        return String.valueOf(this.i);
    }
}
