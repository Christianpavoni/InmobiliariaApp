package com.example.inmobiliaria.ui.perfil;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria.modelo.Propietario;

import java.math.BigInteger;

public class PerfilViewModel extends AndroidViewModel {

    private MutableLiveData<Propietario> propietario;


    public PerfilViewModel( @NonNull Application application) {
        super(application);

    }

    public LiveData<Propietario> getPropietario() {
        if(propietario==null){
            propietario=new MutableLiveData<>();
        }
        return propietario;
    }

    public void recuperarPropietario(){

        Propietario p= new Propietario(1,"Alberto","Gutierrez","agutierrez@gmail.com","123", BigInteger.valueOf(266598124));
        propietario.setValue(p);

    }
}