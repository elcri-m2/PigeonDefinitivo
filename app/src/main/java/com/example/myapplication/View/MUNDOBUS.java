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
Esta clase nos mostrara los datos obtenidos
En la clase LlmarDatosfirebase, aqui se
muestran las noticias diarias del mundo
 */

public class MUNDOBUS extends AppCompatActivity {
    private TextView NombreNoticia,Noticia,TipoNoticia,PaisOrigen,Fecha;
    private EditText Video,Link;

    private ImageView ImagenNoticia;
    int i=0;
    MetodosAplicacion v= new MetodosAplicacion();
    String Coleccion=v.Fecha();
    LlamarDatosFirebase c= new LlamarDatosFirebase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mundobus);
        Noticia = findViewById(R.id.NoticiaC);
        NombreNoticia = findViewById(R.id.NombreNoticiaC);
        Video=  (EditText)findViewById(R.id.videoC2);
        Link= (EditText)findViewById(R.id.linkC2);
        TipoNoticia=findViewById(R.id.TipoNoticiaN);
        PaisOrigen=findViewById(R.id.PaisOrigenC);
        ImagenNoticia= findViewById(R.id.ImagenNoticiaC);
    }
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
    /*
    Con este metodo podemos navegar en las diferentes noticias
     */

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