package com.example.myapplication.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;

//Esta clase nos permitira movernos entre las diferentes pantallas

public class Conir extends AppCompatActivity {
    static EditText editText;

    private FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conir);
        editText = findViewById(R.id.MiUsuarioFav);
        mFirestore = FirebaseFirestore.getInstance();
    }
    //Ir a la clase calificar
    public void Calificar(View view) {
        String nomn = editText.getText().toString();

        mFirestore.collection("MisUsuarios").document(nomn).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                Intent intent = new Intent(getApplicationContext(), Calificar.class);
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
    //Ir a consultar

    public void Consutar(View view) {
        String nomn = editText.getText().toString();
        if(nomn.isEmpty()){

            Toast.makeText(getApplicationContext(), "No has Ingresado Ningun Usuario", Toast.LENGTH_SHORT).show();

        }else{

        mFirestore.collection("MisUsuarios").document(nomn).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                Intent intent = new Intent(getApplicationContext(), Consul.class);
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
    }
    public static String Usuario() {
        String nombre = editText.getText().toString();

        return nombre;
    }
}
