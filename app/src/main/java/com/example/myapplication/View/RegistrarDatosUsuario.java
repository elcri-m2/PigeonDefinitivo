package com.example.myapplication.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.View.MainActivity;
import com.example.myapplication.View.Registrate;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
/*
En esta clase obtenemos toda la informacion del
usuario para luego subirla a la base de datos de firebase
 */
public class RegistrarDatosUsuario extends  AppCompatActivity {

    private EditText nom;
    private Spinner spin;
    private Spinner spin2;
    private Spinner spin3;
    private FirebaseFirestore mFirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_datos_usuario);


        nom = (EditText) findViewById(R.id.nombre);
        spin = (Spinner) findViewById(R.id.genero);
        spin2 = (Spinner) findViewById(R.id.seleccionepais);
        spin3 = (Spinner) findViewById(R.id.TipodeUsuario);

        mFirestore = FirebaseFirestore.getInstance();



        String[] generos = {"Femenino", "Masculino", "Otro"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, generos);
        spin.setAdapter(adapter);

        String[] paises = {"Colombia", "Mexico", "Ecuador", "Peru"};

        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, paises);
        spin2.setAdapter(adapt);

        String[] Usuarios = {"LECTOR", "PIGEON"};

        ArrayAdapter<String> adap = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Usuarios);
        spin3.setAdapter(adap);

    }

    public void Iralogin(View view) {

        String nombre = nom.getText().toString();
        String Tipogenero = (String) spin.getSelectedItem();
        String Tipopais = (String) spin2.getSelectedItem();
        String TipoUsuario = (String) spin3.getSelectedItem();


        if (nombre.isEmpty()) {
            Toast.makeText(this, "Debes ingresar tu nombre", Toast.LENGTH_LONG).show();
        }
        if (!nombre.isEmpty()) {

            posUser(nombre, Tipogenero, Tipopais, TipoUsuario);
            posUserC();
            Reputacion(nombre);
            MisUsuarios(nombre);
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    }

    private void MisUsuarios(String nombre) {
        Map<String, Object> map = new HashMap<>();
        map.put("Correo", Registrate.Correo());
        mFirestore.collection("MisUsuarios").document(nombre).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                finish();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
            }
        });
    }

    private void Reputacion(String nombre) {
        Map<String, Object> map =new HashMap<>();


        mFirestore.collection(nombre).document().set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

                finish();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Error al ingresar", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void posUser(String nombre, String tipogenero, String tipopais, String tipoUsuario) {
        String UID;
        UID = (String) Registrate.Uid();
        String UUU = String.valueOf(UID);
        Map<String, Object> map =new HashMap<>();
        map.put("nombre", nombre);
        map.put("genero", tipogenero);
        map.put("pais", tipopais);
        map.put("tipoUsuario", tipoUsuario);
        //map.put("Foto", "https://icones.pro/wp-content/uploads/2021/02/icone-utilisateur-vert.png");
        map.put("correo",Registrate.Correo());
        map.put("UID",UUU);
        mFirestore.collection("Datosusuario").document(Registrate.Correo()).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getApplicationContext(), "Creado exitosamente", Toast.LENGTH_SHORT).show();
                finish();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Error al ingresar", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void posUserC() {
        Map<String, Object> map =new HashMap<>();
        map.put("Foto", "https://icones.pro/wp-content/uploads/2021/02/icone-utilisateur-vert.png");
        mFirestore.collection("Datosusuario").document(Registrate.Correo()+"a").set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getApplicationContext(), "Creado exitosamente", Toast.LENGTH_SHORT).show();
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Error al ingresar", Toast.LENGTH_SHORT).show();
            }
        });
    }
}