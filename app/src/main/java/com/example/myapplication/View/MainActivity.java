package com.example.myapplication.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
/*
En esta clase se dar el ingreso al Usuario
 */
public class MainActivity extends AppCompatActivity {


    private EditText ete,etp;

    private FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), HOMME.class);
            startActivity(intent);
            finish();

        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ete= (EditText)findViewById(R.id.correoA);
        etp= (EditText)findViewById(R.id.contrasenaA);

        mAuth = FirebaseAuth.getInstance();
    }
    //Por medio de este metodo se ingresa a la aplicacion
    public void Ingresar (View view){

        //BaseDeDatos adminn = new BaseDeDatos(this,"administracion", null, 1);
        //SQLiteDatabase Bases = adminn.getWritableDatabase();

        String correo= ete.getText().toString();
        String contrasena= etp.getText().toString();

        if (correo.isEmpty()){
            Toast.makeText(this,"Debes ingresar tu correo",Toast.LENGTH_LONG).show();
        }
        if (contrasena.isEmpty()){
            Toast.makeText(this,"Debes ingresar tu contraseña",Toast.LENGTH_LONG).show();
        }
        else{
        mAuth.signInWithEmailAndPassword(correo, contrasena)
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Ha ingresado con exito",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), HOMME.class);
                            startActivity(intent);
                            finish();

                        } else {
                            Toast.makeText(MainActivity.this, "Vuelvalo a intentar.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        }
    }
    //este metodo no llvara a una pantalla
    // la cual nos permitira registrar un usuario
    public void Haceregistro (View view){
        Intent haceregistro= new Intent(this, Registrate.class);
        startActivity(haceregistro);

    }
}