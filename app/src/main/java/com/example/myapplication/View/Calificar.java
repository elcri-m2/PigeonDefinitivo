package com.example.myapplication.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Model.CalificarFirebase;
import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.InputMismatchException;
//En esta clase se calificaran los usuarios
public class Calificar extends AppCompatActivity {

    private EditText pun,com;
    FirebaseAuth Auth;
    FirebaseUser user;
    static String Puntuac,NumPun,nombre;
    private FirebaseFirestore mFirestore;
    private TextView Usur,necesito;
    String Usuari = Conir.Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificar);
        pun = (EditText) findViewById(R.id.puntuacion);
        com = (EditText) findViewById(R.id.comentario);
        Usur = findViewById(R.id.Usu);
        Usur.setText(Usuari);
        CalificarFirebase n= new CalificarFirebase();
        n.Calificacion();
        n.TamanoC();
    }
//Este metodo recopilara todo la informacion para crear la calificacion
    public void calificar(View view) {
        CalificarFirebase n = new CalificarFirebase();
        String puntuacion = pun.getText().toString();
        String comentario = com.getText().toString();
        try {if (puntuacion.isEmpty()){
            Toast.makeText(this,"Debes ingresar una Puntuación",Toast.LENGTH_LONG).show();
        }
            if (5<Integer.parseInt(puntuacion)|0>Integer.parseInt(puntuacion)){
                Toast.makeText(this,"La Calificación es incorrecta",Toast.LENGTH_LONG).show();
            }
            else {
                n.posCalificar(comentario);
                n.posPuntuacion(puntuacion);
                Intent intent = new Intent(getApplicationContext(), HOMME.class);
                startActivity(intent);
            }

        } catch (InputMismatchException e) {
            Toast.makeText(this,"Error: El valor ingresado no es un número entero",Toast.LENGTH_LONG).show();

        }
    }
}