package com.example.myapplication.Model;

import androidx.annotation.NonNull;

import com.example.myapplication.View.BREAK;
import com.example.myapplication.View.Conir;
import com.example.myapplication.View.SIGUE;
import com.example.myapplication.modelView.MetodosAplicacion;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class LlamarDatosFirebase {
    private  FirebaseFirestore mFirestore;
    private  FirebaseAuth Auth;
    private  FirebaseUser user;
    public static String Coleccion,UID;
    public static int i,sizeX;

    /*
    En esta clase se Implementaran Interfaces que nos permitiran consultar
    a firebase, y que esta consulta vaya en sincronia con la ejecucion de la aplicacion
     */

    public interface OnDatosUsuarioObtainedListener {
        void onPaisObtained(String pais);
        void onGeneroObtained(String pais);
        void onTipoUsurioObtained(String pais);
        void onUIDObtained(String pais);
        void onNombreObtained(String pais);
        void onFotoObtained(String foto);
    }

    public interface OnDatosConsultarObtainedListener {
        void onPaisObtained(String pais);
        void onGeneroObtained(String pais);
        void onTipoUsurioObtained(String pais);
        void onUIDObtained(String pais);
        void onNombreObtained(String pais);
        void onFotoObtained(String foto);
        void onCorreoObtained(String foto);
        void onPuntuacionObtained(String foto);
        void onNumPunObtained(String foto);
        void onComentarioObtained(String foto);
        //void onPaisComObtained(String foto);
    }
    public interface OnNotciaObtainedListener {
        void onNombreNoticiaObtained(String pais);
        void onNoticiaObtained(String pais);
        void onLinkObtained(String pais);
        void onImagenObtained(String pais);
        void onPaisObtained(String pais);
        void onUIDObtained(String pais);
        void onPaisOrigenObtained(String pais);
        void onfechaObtained(String pais);
        void onVideoObtained(String pais);
        void onTipoNoticiaObtained(String pais);
    }
    public void setColeccion(String coleccion){
        LlamarDatosFirebase.Coleccion= coleccion;
    }

    /*
    Estos metodos get nos permitiran obtener distintos valores que se modifican en las diferentes clase,
    el metodo getColeccion nos ayuda a obtener el valor que se le da a coleccion en las diferentes clases
    y esto nos sirve para hacer la consulta a firebase, lo mismo sucede con getIndice
     */
    public String getColeccion(){

        return LlamarDatosFirebase.Coleccion;
    }
    public int getIndice(){

        return LlamarDatosFirebase.i;
    }

    /*
    En este metodo se obtendran los datos que luego seran mostrados en la
    clase Infromcion, esta nos muestra toda la informacion del usuario
     */
    public void datosUsuario(final OnDatosUsuarioObtainedListener listener) {
        mFirestore = FirebaseFirestore.getInstance();
        Auth = FirebaseAuth.getInstance();
        user = Auth.getCurrentUser();
        String uid = user.getEmail();
        mFirestore.collection("Datosusuario").document(uid).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override

            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document != null && document.exists()) {
                        listener.onPaisObtained(document.getString("pais"));
                        listener.onGeneroObtained(document.getString("genero"));
                        listener.onTipoUsurioObtained(document.getString("tipoUsuario"));
                        listener.onNombreObtained(document.getString("nombre"));
                        listener.onUIDObtained(document.getString("UID"));
                    }
                }
            }
        });
    }
    /*
    Este metodo es para la clase Consul la cual requiere mostrar
    por pantalla la informacion del usuario consultado, en este
    metodo se obtine la puntuacion del Usuario y demas informacion
     */
    public void datosConsultar(final OnDatosConsultarObtainedListener listener) {
        mFirestore = FirebaseFirestore.getInstance();
        mFirestore.collection("MisUsuarios").document(Conir.Usuario()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document != null && document.exists()) {
                        String col = document.getString("Correo");
                        mFirestore = FirebaseFirestore.getInstance();
                        mFirestore.collection("Datosusuario").document(col).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if (task.isSuccessful()) {
                                    DocumentSnapshot document = task.getResult();
                                    if (document != null && document.exists()) {
                                        listener.onPaisObtained(document.getString("pais"));
                                        listener.onGeneroObtained(document.getString("genero"));
                                        listener.onTipoUsurioObtained(document.getString("tipoUsuario"));
                                        listener.onNombreObtained(document.getString("nombre"));
                                        listener.onUIDObtained(document.getString("UID"));
                                        listener.onCorreoObtained(document.getString("correo"));
                                    }
                                }
                            }
                        });
                    }
                }
            }
        });
        mFirestore.collection("MisUsuarios").document(Conir.Usuario()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document != null && document.exists()) {
                        String col = document.getString("Correo");
                        mFirestore = FirebaseFirestore.getInstance();
                        mFirestore.collection("Datosusuario").document(col+"a").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if (task.isSuccessful()) {
                                    DocumentSnapshot document = task.getResult();
                                    if (document != null && document.exists()) {
                                        listener.onFotoObtained(document.getString("Foto"));
                                    }
                                }
                            }
                        });
                    }
                }
            }
        });
        mFirestore.collection(Conir.Usuario()).document("puntua").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        listener.onPuntuacionObtained("Puntuación:  "+document.getString("Puntuacion"));
                        listener.onNumPunObtained("Número de Calificaciones: "+document.getString("NumPun"));
                    } else {
                    }
                }

            }
        });
        mFirestore.collection(Conir.Usuario()).document(String.valueOf(getIndice())).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        listener.onComentarioObtained(document.getString("Pais")+"\n"+document.getString("Comentario")+"bbbb");
                    } else {
                    }
                }

            }
        });
    }

    /*
    Con este metodo obtenemos las noticias y las
    mostramos en las diferentes clses que se encargan de hacer esta accion
     */
    public void Noticia(final OnNotciaObtainedListener listener) {
        BREAK Noticia = new BREAK();
        mFirestore = FirebaseFirestore.getInstance();
        mFirestore.collection(getColeccion()).document(String.valueOf(getIndice())).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document != null && document.exists()) {
                        listener.onNombreNoticiaObtained(document.getString("nombre")+"-"+document.getString("NombreNoticia"));
                        listener.onNoticiaObtained(document.getString("Noticia"));
                        listener.onLinkObtained(document.getString("Link"));
                        listener.onImagenObtained(document.getString("Imagen"));
                        listener.onPaisObtained(document.getString("Pais"));
                        listener.onUIDObtained(document.getString("UID"));
                        listener.onPaisOrigenObtained(document.getString("PaisOrigen"));
                        listener.onfechaObtained(document.getString("fecha"));
                        listener.onVideoObtained(document.getString("Video"));
                        listener.onTipoNoticiaObtained(document.getString("TipoNoticia"));
                    }
                }
            }
        });
    }
    //Este metodo nos permite mostrar las noticias de
    // los Usuarios que el Usuario sigue
    public void NoticiasSeguir(final OnNotciaObtainedListener listener){
        MetodosAplicacion z = new MetodosAplicacion();
        mFirestore = FirebaseFirestore.getInstance();
        CollectionReference collectionRef = mFirestore.collection("MisSamuel Alcantara");
        ArrayList<DocumentSnapshot> MisSeguir = new ArrayList<>();
        collectionRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    MisSeguir.add(documentSnapshot);
                }
                SIGUE J= new SIGUE();
                for(int i = 0; i==MisSeguir.size();i++){
                    CollectionReference collectione = mFirestore.collection(String.valueOf(z.Fecha()+MisSeguir.get(i)));
                    int finalI = i;
                    collectione.get().addOnSuccessListener(queryDocumentSnapshotss -> {
                        LlamarDatosFirebase.sizeX= queryDocumentSnapshotss.size();
                        for(getIndice();getIndice()==0;){
                            mFirestore.collection(String.valueOf(z.Fecha()+MisSeguir.get(finalI))).document(String.valueOf(getIndice())).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                    if (task.isSuccessful()) {
                                        DocumentSnapshot document = task.getResult();
                                        if (document != null && document.exists()) {
                                            listener.onNombreNoticiaObtained(document.getString("NombreNoticia"));
                                            listener.onNoticiaObtained(document.getString("Noticia"));
                                            listener.onLinkObtained(document.getString("Link"));
                                            listener.onImagenObtained(document.getString("Imagen"));
                                            listener.onPaisObtained(document.getString("Pais"));
                                            listener.onUIDObtained(document.getString("UID"));
                                            listener.onPaisOrigenObtained(document.getString("PaisOrigen"));
                                            listener.onfechaObtained(document.getString("fecha"));
                                            listener.onVideoObtained(document.getString("Video"));
                                            listener.onTipoNoticiaObtained(document.getString("TipoNoticia"));
                                        }
                                    }
                                }
                            });
                        }
                        LlamarDatosFirebase.i=1;
                        J.k=1;
                    }).addOnFailureListener(e -> {
                        System.err.println("Error al obtener la colección: " + e.getMessage());
                    });
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
            }
        });
    }
}