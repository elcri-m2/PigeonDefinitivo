package com.example.myapplication.Model;

import androidx.annotation.NonNull;

import com.example.myapplication.View.Conir;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
/*
Este clase obtiene los datos de la clase calificar
y los sube a firebase
 */

public class CalificarFirebase {
    private FirebaseFirestore mFirestore;
    private FirebaseAuth Auth;
    private FirebaseUser user;
    public static int sizeC;
    String Usuari = Conir.Usuario();
    static String Puntuac,NumPun,Pais;
    public static String uid;


    public String uid(){
        Auth = FirebaseAuth.getInstance();
        user = Auth.getCurrentUser();
        CalificarFirebase.uid = user.getEmail();
        return CalificarFirebase.uid;
    }


    public void TamanoC(){
        mFirestore = FirebaseFirestore.getInstance();

        CollectionReference collection = mFirestore.collection(Usuari);
        // Obtiene el número de documentos en la colección
        collection.get().addOnSuccessListener(queryDocumentSnapshots -> {
            int sizeC = queryDocumentSnapshots.size();
            CalificarFirebase.sizeC= sizeC;
        }).addOnFailureListener(e -> {
            System.err.println("Error al obtener la colección: " + e.getMessage());
        });
    }
    public int getsizeC(){
        return CalificarFirebase.sizeC;
    }
    public void Calificacion(){
        mFirestore = FirebaseFirestore.getInstance();
        mFirestore.collection(Usuari).document("puntua").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        CalificarFirebase.Puntuac = document.getString("Puntuacion");
                        CalificarFirebase.NumPun= document.getString("NumPun");

                    } else {
                    }
                }

            }
        });

        mFirestore.collection("Datosusuario").document(uid()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        CalificarFirebase.Pais = document.getString("pais");
                    } else {
                    }
                }
            }
        });
    }
    public String getPuntuac(){
        Calificacion();

        return CalificarFirebase.Puntuac;
    }
    public String getNumPun(){
        Calificacion();
        return CalificarFirebase.NumPun;
    }
    public void posPuntuacion(String puntuacion){
        mFirestore = FirebaseFirestore.getInstance();

        int c= Integer.parseInt(getPuntuac())* Integer.parseInt(getNumPun());
        int e= c+Integer.parseInt(puntuacion);
        int k= Integer.parseInt(getNumPun())+1;
        int j= e/k;

        String miPuntuacion= Integer.toString(j);
        String NumpunActualizado= Integer.toString(k);

        Map<String, Object> map = new HashMap<>();
        map.put("Puntuacion", miPuntuacion);
        map.put("NumPun", NumpunActualizado);
        mFirestore.collection(Usuari).document("puntua").set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
            }
        });
    }
    public void posCalificar(String comentario) {

        Map<String, Object> map = new HashMap<>();
        map.put("Pais",Pais);
        map.put("Comentario", comentario);
        int docu = getsizeC()+1;;
        mFirestore = FirebaseFirestore.getInstance();

        mFirestore.collection(Usuari).document(String.valueOf(docu)).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
            }
        });
    }

}
