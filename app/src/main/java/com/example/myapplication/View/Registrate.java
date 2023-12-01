package com.example.myapplication.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

// esta clase es la que nos permite crear el
// perfil del usuarioe en la base de datos de firebase Auth
public class Registrate extends AppCompatActivity {

    private EditText ete,etp;
    private static FirebaseAuth mAuth;

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
        setContentView(R.layout.activity_registrate);

        ete= (EditText)findViewById(R.id.correoB);
        etp= (EditText)findViewById(R.id.contrasenaB);
        mAuth = FirebaseAuth.getInstance();
    }
    public void Registrar (View view) {

        String correo = ete.getText().toString();
        String contrasena = etp.getText().toString();

        if (correo.length() == 0) {
            Toast.makeText(this, "Debes ingresar tu correo", Toast.LENGTH_LONG).show();
        }
        if (contrasena.length() == 0) {
            Toast.makeText(this, "Debes ingresar tu contraseña", Toast.LENGTH_LONG).show();
        }
        if (contrasena.length() != 0 && correo.length() != 0) {
            Toast.makeText(this, "Registro en proceso....", Toast.LENGTH_LONG).show();

            mAuth.createUserWithEmailAndPassword(correo, contrasena)
                    .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Registrate.this, "Su perfil ha sido creado",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), RegistrarDatosUsuario.class);
                                startActivity(intent);


                            } else {
                                // If sign in fails, display a message to the user.

                                Toast.makeText(Registrate.this, "Vuelvalo a intentar.",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        }}
    public static String Uid(){
       FirebaseUser User = mAuth.getCurrentUser();
        String uid = User.getUid();
        String UID = uid;

        return UID;
    }
    public static String Correo(){
        FirebaseUser User = mAuth.getCurrentUser();
        String correo = User.getEmail();

        return correo;
    }

}