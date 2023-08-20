package com.example.tp1;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

public class TraducidoActivityViewModel extends AndroidViewModel{

    private Context context;
    private List<Palabra> palabras = new ArrayList<Palabra>();
    private MutableLiveData<Palabra> palabraM;
    public TraducidoActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();

        palabras.add(new Palabra("Bicicleta","Bike",R.drawable.bicicleta));
        palabras.add(new Palabra("Casa","Home",R.drawable.casa));
        palabras.add(new Palabra("Auto","Car",R.drawable.auto));
        palabras.add(new Palabra("Auriculares","Earrphone",R.drawable.auriculares));
        palabras.add(new Palabra("Zapatillas","Shoes",R.drawable.zapatillas));
    }

    public MutableLiveData<Palabra> getPalabraM(){
        if(palabraM == null){
            palabraM= new MutableLiveData<Palabra>(new Palabra("","No se encontro",R.drawable.notfound));
        }
        return palabraM;
    }
    public void traducir(String pal){
        for(int i = 0; i <palabras.size();i++){
            if(pal.equals(palabras.get(i).getPalabra())){
               palabraM.setValue(palabras.get(i));
            }
        }
    }
    public void volver(){
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}