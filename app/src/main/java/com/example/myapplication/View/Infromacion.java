package com.example.myapplication.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.modelView.MetodosFirebaseAplicacion;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

/*
En esta clase se mostrara la informacion del Usuario
 */
public class Infromacion extends AppCompatActivity {

    FirebaseAuth Auth;
    FirebaseUser user;
    TextView Correo,Nombre,Genero,Pais,TipoUsuario;
    private FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infromacion);

        Correo = findViewById(R.id.datos);
        Nombre =  findViewById(R.id.Nombre);
        Genero = findViewById(R.id.Genero);
        Pais = findViewById(R.id.Pais);
        TipoUsuario = findViewById(R.id.TipoUsuario);
        Auth = FirebaseAuth.getInstance();
        user = Auth.getCurrentUser();

        if (user == null){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }else {
            Correo.setText(user.getEmail());
            ponerDatos();
        }
    }
    /*
    Este metodo nos permitira obtener la informacion
    de la clase MetodosAplicacionFirebase, la cual nos
    da datos de forma sincronica a la ejecuccion de la plicacion
     */
    public void ponerDatos(){
        MetodosFirebaseAplicacion Obtener= new MetodosFirebaseAplicacion();
        Obtener.PaisAsin().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    Pais.setText(task.getResult());
                } else {
                }
            }
        });
        Obtener.NombreAsin().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    Nombre.setText(task.getResult());
                } else {
                }
            }
        });
        Obtener.GeneroAsin().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    Genero.setText(task.getResult());
                } else {

                }
            }
        });
        Obtener.TipoUsuarioAsin().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    TipoUsuario.setText(task.getResult());
                } else {
                }
            }
        });
    }
//Metodo para salir del perfil
    public void Salir (View view){

        FirebaseAuth.getInstance().signOut();
        Intent irSiguiendo= new Intent(getApplicationContext(), MainActivity.class);
        startActivity(irSiguiendo);

    }
    //Metodo para ir a la pagina foto
    public void FOTO (View view){
        Intent foto= new Intent(this, com.example.myapplication.View.foto.class);
        startActivity(foto);

    }
    //metodo para borrar la cuenta
    public void BorrarCuenta (View view){

        user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d("Firebase", "Usuario eliminado");
                            FirebaseAuth.getInstance().signOut();
                            Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(), "El usuario se eliminó con éxito", Toast.LENGTH_SHORT).show();
                        } else {
                            Log.d("Firebase", "Error al eliminar el usuario");
                            Toast.makeText(getApplicationContext(), "Ocurrió un error al eliminar el usuario", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
}