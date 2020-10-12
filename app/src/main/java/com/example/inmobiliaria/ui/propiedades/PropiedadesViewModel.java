package com.example.inmobiliaria.ui.propiedades;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.modelo.Inmueble;
import com.example.inmobiliaria.modelo.Propietario;

import java.util.ArrayList;
import java.util.List;

public class PropiedadesViewModel extends ViewModel {

    private MutableLiveData<List<Inmueble>> inmuebles;

    public PropiedadesViewModel() {

    }

    public LiveData<List<Inmueble>> getInmuebles() {
        if(inmuebles==null){
            inmuebles=new MutableLiveData<List<Inmueble>>();
        }
        return inmuebles;
    }

    public void recuperarInmuebles(){

        List<Inmueble> lista= new ArrayList<>();
        Inmueble i1= new Inmueble(1,"Almirante Brown 750",2,"Casa","Residencial",20000d,true, R.drawable.casa1,1,new Propietario());
        Inmueble i2= new Inmueble(2,"Javier Loyola 1365",3,"Departamento","Comercial",15000d,false,R.drawable.casa2,1,new Propietario());
        lista.add(i1);
        lista.add(i2);
        inmuebles.setValue(lista);

    }
}