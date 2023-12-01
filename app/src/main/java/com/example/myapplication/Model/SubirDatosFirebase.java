package com.example.myapplication.Model;

import androidx.annotation.NonNull;

import com.example.myapplication.View.CrearNoticia;
import com.example.myapplication.modelView.MetodosAplicacion;
import com.example.myapplication.modelView.MetodosFirebaseAplicacion;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//Desde esta clase se subiran los datos a firebase

public class SubirDatosFirebase {
    private FirebaseFirestore mFirestore;
    private FirebaseAuth Auth;
    private FirebaseUser user;
    public static String PaisOrigen,Nombre;
    public static int sizeM,sizeN,sizeB,sizeE;
    MetodosAplicacion v= new MetodosAplicacion();

    //Aplico una interfaz la cual la utiliza el
    // metodo Tamaño para obter los datos y ir
    // en sincronia con la aplicacion
    public interface OnTamanoObtainedListener {
        void onSizeBObtained(String pais);
        void onSizeNObtained(String pais);
        void onSizeMObtained(String pais);
        void onSizeEObtained(String pais);
    }

    //Con este metodo Obengo datos para crear la noticia
    public void Pais() {
        Auth = FirebaseAuth.getInstance();
        user = Auth.getCurrentUser();
        mFirestore = FirebaseFirestore.getInstance();
        String uid = user.getEmail();
        mFirestore.collection("Datosusuario").document(uid).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        String PaisOrigen = document.getString("pais");
                        String Nombre= document.getString("nombre");
                        SubirDatosFirebase.Nombre=Nombre;
                        SubirDatosFirebase.PaisOrigen=PaisOrigen;
                    }
                }
            }
        });
    }
    //Metodo para obtener tamaÑo de las colecciones de firebase y en base a eso mostrarlas
    public void Tamano(final SubirDatosFirebase.OnTamanoObtainedListener listener) {
        CrearNoticia p= new CrearNoticia();
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.M.yyyy");
        String fecha = sdf.format(currentDate);
        Pais();
        mFirestore = FirebaseFirestore.getInstance();
        CollectionReference collectione = mFirestore.collection(fecha+"Noticias"+getNombree());

        // Obtiene el número de documentos en la colección
        collectione.get().addOnSuccessListener(queryDocumentSnapshots -> {
            int sizeM = queryDocumentSnapshots.size();
            listener.onSizeMObtained(String.valueOf(sizeM));
            SubirDatosFirebase.sizeM= sizeM;
        }).addOnFailureListener(e -> {
            System.err.println("Error al obtener la colección: " + e.getMessage());
        });

        mFirestore = FirebaseFirestore.getInstance();
        CollectionReference collectionRef = mFirestore.collection(fecha);

        // Obtiene el número de documentos en la colección
        collectionRef.get().addOnSuccessListener(queryDocumentSnapshots -> {
            int sizeE = queryDocumentSnapshots.size();
            SubirDatosFirebase.sizeE= sizeE;
            listener.onSizeEObtained(String.valueOf(sizeE));

        }).addOnFailureListener(e -> {
            System.err.println("Error al obtener la colección: " + e.getMessage());
        });
        mFirestore = FirebaseFirestore.getInstance();
        CollectionReference collectionRe = mFirestore.collection(p.getPaisNoticia()+p.getTipoNoticia());

        // Obtiene el número de documentos en la colección
        collectionRe.get().addOnSuccessListener(queryDocumentSnapshots -> {
            int sizeN = queryDocumentSnapshots.size();
            SubirDatosFirebase.sizeN= sizeN;
            listener.onSizeNObtained(String.valueOf(sizeN));

        }).addOnFailureListener(e -> {
            System.err.println("Error al obtener la colección: " + e.getMessage());
        });
        mFirestore = FirebaseFirestore.getInstance();
        CollectionReference collectionR = mFirestore.collection(fecha+p.getPaisNoticia());

        // Obtiene el número de documentos en la colección
        collectionR.get().addOnSuccessListener(queryDocumentSnapshots -> {
            int sizeB = queryDocumentSnapshots.size();
            SubirDatosFirebase.sizeB= sizeB;
            listener.onSizeBObtained(String.valueOf(sizeB));

        }).addOnFailureListener(e -> {
            System.err.println("Error al obtener la colección: " + e.getMessage());
        });
    }
    public String getPaisOrigenn(){
        return SubirDatosFirebase.PaisOrigen;
    }
    public String getNombree(){
        return SubirDatosFirebase.Nombre;
    }

    //Metodo para subir noticias en MisNoicias
    public void MisNoicias(String nombreNoticia, String noticia, String link, String imagen, String pais, String video, String tipoNoticia, String paisOrigen) {
        MetodosFirebaseAplicacion Obtener= new MetodosFirebaseAplicacion();
        Obtener.SizeMAsin().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {

                    Auth = FirebaseAuth.getInstance();
                    user = Auth.getCurrentUser();
                    String uid = user.getUid();
                    mFirestore = FirebaseFirestore.getInstance();


                    Map<String, Object> map = new HashMap<>();
                    map.put("NombreNoticia", nombreNoticia);
                    map.put("Noticia", noticia);
                    map.put("Link", link);
                    map.put("Imagen", imagen);
                    map.put("UID", uid);
                    map.put("Pais", pais);
                    map.put("TipoNoticia", tipoNoticia);
                    map.put("Video", video);
                    map.put("fecha", v.Fecha());
                    map.put("PaisOrigen",getPaisOrigenn());
                    map.put("nombre",getNombree());

                    int docu = Integer.parseInt(task.getResult())+1;

                    mFirestore.collection("Noticias"+getNombree()).document(String.valueOf(docu)).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                        }
                    });
                } else {
                }
            }
        });
    }
    //Metodo para subir noticias en BreakNews

    public void BreakNews(String nombreNoticia, String noticia, String link, String imagen, String pais, String video, String tipoNoticia, String paisOrigen) {

        MetodosFirebaseAplicacion Obtener= new MetodosFirebaseAplicacion();
        Obtener.SizeBAsin().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    mFirestore = FirebaseFirestore.getInstance();
                    Auth = FirebaseAuth.getInstance();
                    user = Auth.getCurrentUser();
                    String uid = user.getUid();

                    Map<String, Object> map = new HashMap<>();
                    map.put("NombreNoticia", nombreNoticia);
                    map.put("Noticia", noticia);
                    map.put("Link", link);
                    map.put("Imagen", imagen);
                    map.put("UID", uid);
                    map.put("Pais", pais);
                    map.put("TipoNoticia", tipoNoticia);
                    map.put("Video", video);
                    map.put("fecha", v.Fecha());
                    map.put("PaisOrigen",getPaisOrigenn());
                    map.put("nombre",getNombree());
                    int docu = Integer.parseInt(task.getResult())+1;

                    mFirestore.collection(v.Fecha()+pais).document(String.valueOf(docu)).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                        }
                    });
                } else {
                }
            }
        });
    }

    //Metodo para subir noticias en ElMundoHoy

    public void ElMundoHoy(String nombreNoticia, String noticia, String link, String imagen, String pais, String video, String tipoNoticia, String paisOrigen) {

        MetodosFirebaseAplicacion Obtener= new MetodosFirebaseAplicacion();
        Obtener.SizeEAsin().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    mFirestore = FirebaseFirestore.getInstance();
                    Auth = FirebaseAuth.getInstance();
                    user = Auth.getCurrentUser();
                    String uid = user.getUid();

                    Map<String, Object> map = new HashMap<>();
                    map.put("NombreNoticia", nombreNoticia);
                    map.put("Noticia", noticia);
                    map.put("Link", link);
                    map.put("Imagen", imagen);
                    map.put("UID", uid);
                    map.put("Pais", pais);
                    map.put("TipoNoticia", tipoNoticia);
                    map.put("Video", video);
                    map.put("fecha", v.Fecha());
                    map.put("PaisOrigen",getPaisOrigenn());
                    map.put("nombre",getNombree());
                    int docu = Integer.parseInt(task.getResult())+1;
                    mFirestore.collection(v.Fecha()).document(String.valueOf(docu)).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                        }
                    });
                } else {
                }
            }
        });
    }
    //Metodo para subir noticias por paises

    public void NoticiasPaises(String nombreNoticia, String noticia, String link, String imagen, String pais, String video, String tipoNoticia, String paisOrigen) {

        MetodosFirebaseAplicacion Obtener= new MetodosFirebaseAplicacion();
        Obtener.SizeNAsin().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()) {
                    mFirestore = FirebaseFirestore.getInstance();
                    Auth = FirebaseAuth.getInstance();
                    user = Auth.getCurrentUser();
                    String uid = user.getUid();

                    Map<String, Object> map = new HashMap<>();
                    map.put("NombreNoticia", nombreNoticia);
                    map.put("Noticia", noticia);
                    map.put("Link", link);
                    map.put("Imagen", imagen);
                    map.put("UID", uid);
                    map.put("Pais", pais);
                    map.put("TipoNoticia", tipoNoticia);
                    map.put("Video", video);
                    map.put("fecha", v.Fecha());
                    map.put("PaisOrigen",getPaisOrigenn());
                    map.put("nombre",getNombree());
                    int docu = Integer.parseInt(task.getResult())+1;
                    mFirestore.collection(pais+tipoNoticia).document(String.valueOf(docu)).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                        }
                    });
                } else {
                }
            }
        });
    }
}
