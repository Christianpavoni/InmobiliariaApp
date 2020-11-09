package com.example.inmobiliaria.ui.pagos;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.modelo.Contrato;
import com.example.inmobiliaria.modelo.Inmueble;
import com.example.inmobiliaria.modelo.Inquilino;
import com.example.inmobiliaria.modelo.Pago;
import com.example.inmobiliaria.modelo.Propietario;

import java.util.ArrayList;
import java.util.Date;

public class PagosViewModel extends ViewModel {

    private Context context;
    private MutableLiveData<ArrayList<Inmueble>> inmuebles;
    private MutableLiveData<ArrayList<Pago>> listaPagos;

    public LiveData<ArrayList<Inmueble>> getInmuebles() {
        if (inmuebles == null) {
            inmuebles = new MutableLiveData<>();
        }
        return inmuebles;
    }

    public LiveData<ArrayList<Pago>> getListaPagos() {
        if (listaPagos == null) {
            listaPagos = new MutableLiveData<>();
        }
        return listaPagos;
    }

    public void cargarInmuebles() {
        ArrayList<Inmueble> lista = new ArrayList<>();
        lista.add(new Inmueble(1,"Almirante Brown 750",2,"Casa","Residencial",20000,"Disponible", "R.drawable.casa1",1));
        lista.add(new Inmueble(2,"Javier Loyola 1365",3,"Casa","Residencial",20000,"Suspendido","R.drawable.casa2",1));

        this.inmuebles.setValue(lista);

    }

    public void cargarListaDePagos(String direccion) {

        ArrayList<Pago> lista = new ArrayList<>();

        if(direccion.equals("Almirante Brown 750")) {
            lista.add(new Pago(1, 25000, new Date(),1,new Contrato()));
            lista.add(new Pago(2, 30000, new Date(),1,new Contrato()));
        }

        if(direccion.equals("Javier Loyola 1365")) {
            lista.add(new Pago(3, 15000, new Date(),2,new Contrato()));
            lista.add(new Pago(4, 17000, new Date(),2,new Contrato()));
        }

        this.listaPagos.setValue(lista);

    }

}