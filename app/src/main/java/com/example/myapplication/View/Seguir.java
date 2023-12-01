package com.example.myapplication.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.modelView.MetodosFirebaseAplicacion;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
/*
Por medio de esta clase el usuario puede seguir
 a los distintos Usuarios que crean contenido
 */
public class Seguir extends AppCompatActivity {
    private EditText nom;
    FirebaseAuth Auth;
    FirebaseUser user;
    private FirebaseFirestore mFirestore;
    private String Nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguir);

        nom=(EditText) findViewById(R.id.QuieroSeguir);

        Auth = FirebaseAuth.getInstance();
        user = Auth.getCurrentUser();
        mFirestore = FirebaseFirestore.getInstance();
        String uid = user.getUid();
        String usu = nom.getText().toString();

        mFirestore.collection("Datosusuario").document(uid).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Nombre= document.getString("nombre");
                    }
                }
            }
        });
    }
    public void Seguirsi(View view) {

        String usu =nom.getText().toString();

        mFirestore = FirebaseFirestore.getInstance();

        mFirestore.collection("MisUsuarios").document(usu).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        seguir(usu);
                        Intent intent = new Intent(getApplicationContext(), SIGUE.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Error, el usuario no existe", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Error, el usuario no existe", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void seguir(String nom) {
        MetodosFirebaseAplicacion Obtener = new MetodosFirebaseAplicacion();
        Obtener.NombreAsin().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    mFirestore = FirebaseFirestore.getInstance();
                    Map<String, Object> map = new HashMap<>();
                    mFirestore.collection("Mis"+task.getResult()).document("Noticias"+String.valueOf(nom)).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getApplicationContext(), "Siguiendo"+ Seguir.this.nom, Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "Acción no realizada con exito", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else {
                }
            }
        });

    }
    public void DejarDeSeguir(View view){
        MetodosFirebaseAplicacion Obtener = new MetodosFirebaseAplicacion();
        Obtener.NombreAsin().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    mFirestore = FirebaseFirestore.getInstance();
                    String usu =nom.getText().toString();
                    DocumentReference docRef = mFirestore.collection("Mis"+task.getResult()).document("Noticias"+usu);

                    docRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Intent intent = new Intent(getApplicationContext(), SIGUE.class);
                            startActivity(intent);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "Error, al eliminar el usuario", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else {
                }
            }
        });
    }
}