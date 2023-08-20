package com.example.tp1;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private Context context;
    public MainActivityViewModel(@NonNull Application application){
        super(application);
        context = application.getApplicationContext();
    }

    public void enviar(String palabra){
        if(palabra.length() == 0){
            Toast.makeText(context, "Debes ingresar una palabra ", Toast.LENGTH_LONG).show();
        }else{
            Intent intent = new Intent(context, TraducidoActivity.class);
            intent.putExtra("Palabra", palabra);
            intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}