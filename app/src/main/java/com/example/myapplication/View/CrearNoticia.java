package com.example.myapplication.View;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Model.SubirDatosFirebase;
import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
/*
En esta clase se crearan las noticias
 */
public class CrearNoticia extends AppCompatActivity {

    private EditText nom, not, lin, ima, vid;
    private TextView hola;
    private static String PaisOrigen,Nombre,Pais,TipoNoticia;
    private Spinner spin, spin2;
    FirebaseAuth Auth;
    FirebaseUser user;
    private FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_noticia);

        nom = (EditText) findViewById(R.id.NombreNoticia);
        not = (EditText) findViewById(R.id.Contenido);
        lin = (EditText) findViewById(R.id.Link);
        ima = (EditText) findViewById(R.id.Imagen);
        vid = (EditText) findViewById(R.id.Video);
        spin = (Spinner) findViewById(R.id.Paisss);
        spin2 = (Spinner) findViewById(R.id.TipoNoticia);

        Auth = FirebaseAuth.getInstance();
        user = Auth.getCurrentUser();
        mFirestore = FirebaseFirestore.getInstance();
        String uid = user.getUid();
        SubirDatosFirebase m = new SubirDatosFirebase();
        m.Pais();


        String[] Paisesss = {"Colombia", "Mexico", "Ecuador", "Peru"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Paisesss);
        spin.setAdapter(adapter);

        String[] TipoNoticiaa = {"Entretenimiento", "Deportes", "Economía", "Politica y Sociedad", "Ciencia"};

        ArrayAdapter<String> adapterr = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, TipoNoticiaa);
        spin2.setAdapter(adapterr);
    }
    /*
    Este metodo permite Crear las noticias, ya que es el que le
    da ejecucion a los metodos que estan en la clase SubirDatosFirebase
    Tambien nos ayuda a obtener la informcaion para creaar la notici
     */
    public void Crear(View view) {
        SubirDatosFirebase m = new SubirDatosFirebase();

        String nombreNoticia = nom.getText().toString();
        String Noticia = not.getText().toString();
        String Link = lin.getText().toString();
        String Imagen = ima.getText().toString();
        CrearNoticia.Pais = (String) spin.getSelectedItem();
        CrearNoticia.TipoNoticia = (String) spin2.getSelectedItem();
        String Video = vid.getText().toString();
        if (nombreNoticia.isEmpty() | Noticia.isEmpty() | Link.isEmpty()) {
            Toast.makeText(this, "Debes llenar Todos los Campos Obligatorios", Toast.LENGTH_LONG).show();
        }
        if (!nombreNoticia.isEmpty() && !Noticia.isEmpty() && !Link.isEmpty()) {
            getTipoNoticia();
            getPaisNoticia();


            m.BreakNews(nombreNoticia, Noticia, Link, Imagen, Pais, Video, TipoNoticia, PaisOrigen);
            m.ElMundoHoy(nombreNoticia, Noticia, Link, Imagen, Pais, Video, TipoNoticia, PaisOrigen);
            m.NoticiasPaises(nombreNoticia, Noticia, Link, Imagen, Pais, Video, TipoNoticia, PaisOrigen);
            m.MisNoicias(nombreNoticia, Noticia, Link, Imagen, Pais, Video, TipoNoticia, PaisOrigen);

            Intent intent = new Intent(getApplicationContext(), HOMME.class);
            startActivity(intent);
        }
    }
    //Gets necesarios para compartir la informacion c
    // on los diferentes metodos que se ven involucrados en la creacion de la noticia
    public String getTipoNoticia(){
        return CrearNoticia.TipoNoticia;
    }
    public String getPaisNoticia(){
        return CrearNoticia.Pais;
    }
}