package com.example.myapplication.modelView;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MetodosAplicacion {

    public String Fecha(){
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.M.yyyy");
        String fecha = sdf.format(currentDate);
        return fecha;
    }
}
