package com.example.myapplication.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Model.LlamarDatosFirebase;
import com.example.myapplication.R;
import com.example.myapplication.View.Conir;
import com.example.myapplication.modelView.MetodosFirebaseAplicacion;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;
/*
En esta clse el usuario podra ver la informacion relacionada
con el usuario que consulto, como su puntuacion y etc
 */
public class Consul extends AppCompatActivity {

    ImageView Imagen;

    private FirebaseFirestore mFirestore;
    private TextView UsuarioNom,Lpuntuacion, NumPUN,Correo,Genero,Pais,TipoUsuario,Comentario;
    private String uid;
    String coleccion = Conir.Usuario();
    int i;
    LlamarDatosFirebase c= new LlamarDatosFirebase();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consul);
        UsuarioNom = findViewById(R.id.UsuarioNombre);
        UsuarioNom.setText(coleccion);
        Lpuntuacion = findViewById(R.id.lapuntuacion);
        NumPUN= findViewById(R.id.numpu);
        Correo = findViewById(R.id.correo);
        Genero = findViewById(R.id.generoo);
        Pais = findViewById(R.id.pais);
        TipoUsuario = findViewById(R.id.tipoUsuario);
        Comentario = findViewById(R.id.Comentario);
        Imagen= findViewById(R.id.imagen);
    }
    /*
    Este metodo nos permitira obtener la informacion
    de la clase MetodosAplicacionFirebase, la cual nos
    da datos de forma sincronica a la ejecuccion de la plicacion
     */
    public void PonerInformacion(){

        MetodosFirebaseAplicacion Obtener= new MetodosFirebaseAplicacion();

        Obtener.PaisAsin().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    //Pais.setText(task.getResult());
                } else {
                }
            }
        });
        Obtener.PaisAsinC().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    Pais.setText(task.getResult());
                } else {
                }
            }
        });

        Obtener.GeneroAsinC().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    Genero.setText(task.getResult());
                } else {

                }
            }
        });
        Obtener.TipoUsuarioAsinC().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    TipoUsuario.setText(task.getResult());
                } else {
                }
            }
        });
        Obtener.CorreoAsinC().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    Correo.setText(task.getResult());
                } else {
                }
            }
        });
        Obtener.PuntuacionAsinC().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    Lpuntuacion.setText(task.getResult());
                } else {
                }
            }
        });
        Obtener.NumPunAsinC().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    NumPUN.setText(task.getResult());
                } else {
                }
            }
        });
        Obtener.FotoAsinC().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    String foto = task.getResult();
                    Picasso.get().load(foto).into(Imagen);
                } else {
                }
            }
        });
    }
    //Estos metodos nos permitiran navegar entre
    // los diferentes comentarios que tiene un usuario
    public void Adelante(View view) {
        i++;
        c.i=i;
        PonerComentarios();
        PonerInformacion();

    }
    public void Atras (View view) {

        if(i>0) {
            i--;
            c.i=i;
            PonerComentarios();
            PonerInformacion();

        }
    }
    public void PonerComentarios(){
        MetodosFirebaseAplicacion Obtener= new MetodosFirebaseAplicacion();
        Obtener.PaisAsin().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    //Pais.setText(task.getResult());
                } else {
                }
            }
        });
        Obtener.ComentarioAsinC().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    Comentario.setText(task.getResult());
                } else {
                }
            }
        });

    }
}





