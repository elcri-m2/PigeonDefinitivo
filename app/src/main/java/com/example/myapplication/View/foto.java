package com.example.myapplication.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class foto extends AppCompatActivity {

    //En esta clase podremos anexar una foto a nuestro perfil

    private EditText fot;
    FirebaseAuth Auth;
    FirebaseUser user;

    private FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        fot = (EditText) findViewById(R.id.Imagen);
        mFirestore = FirebaseFirestore.getInstance();
    }
//metodo para subir la foto
    public void SubirFoto(View view) {

        String Foto = fot.getText().toString();

        posFoto(Foto);
        Intent intent = new Intent(getApplicationContext(), Infromacion.class);
        startActivity(intent);
    }

    private void posFoto(String foto) {

        Map<String, Object> map =new HashMap<>();
        map.put("Foto", foto);
        Auth = FirebaseAuth.getInstance();
        user = Auth.getCurrentUser();
        String uid = user.getEmail();

        mFirestore.collection("Datosusuario").document(uid+"a").set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getApplicationContext(), "Foto subida con exito", Toast.LENGTH_SHORT).show();
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Error, No se pudo subir la foto", Toast.LENGTH_SHORT).show();
            }
        });
    }

}

