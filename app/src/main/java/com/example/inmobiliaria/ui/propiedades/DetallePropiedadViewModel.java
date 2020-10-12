package com.example.inmobiliaria.ui.propiedades;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria.modelo.Inmueble;
import com.example.inmobiliaria.modelo.Propietario;

import java.util.Objects;

public class DetallePropiedadViewModel extends AndroidViewModel {
    private MutableLiveData<Inmueble> inmueble;

    public DetallePropiedadViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<Inmueble> getInmueble() {
        if(inmueble==null){
            inmueble=new MutableLiveData<>();
        }
        return inmueble;
    }

    public void recuperarInmueble(Bundle bundle){
        Inmueble i= (Inmueble) bundle.getSerializable("inmueble");
        inmueble.setValue(i);


    }
}