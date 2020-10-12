package com.example.inmobiliaria.ui.contratos;

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

public class ContratosViewModel extends ViewModel {
    private Context context;
    private MutableLiveData<ArrayList<Inmueble>> inmuebles;
    private MutableLiveData<ArrayList<Contrato>> listaContratos;

    public LiveData<ArrayList<Inmueble>> getInmuebles() {
        if (inmuebles == null) {
            inmuebles = new MutableLiveData<>();
        }
        return inmuebles;
    }

    public LiveData<ArrayList<Contrato>> getListaContratos() {
        if (listaContratos == null) {
            listaContratos = new MutableLiveData<>();
        }
        return listaContratos;
    }

    public void cargarInmuebles() {
        ArrayList<Inmueble> lista = new ArrayList<>();
        lista.add(new Inmueble(1,"Almirante Brown 750",2,"Casa","Residencial",20000d,true, R.drawable.casa1,1,new Propietario()));
        lista.add(new Inmueble(2,"Javier Loyola 1365",3,"Casa","Residencial",20000d,false,R.drawable.casa2,1,new Propietario()));

        this.inmuebles.setValue(lista);

    }

    public void cargarListaDeContratos(String direccion) {

        ArrayList<Contrato> lista = new ArrayList<>();
        Inquilino i= new Inquilino();
        Inmueble in=new Inmueble();

        if(direccion.equals("Almirante Brown 750")) {
            i.setNombre("Javier");
            i.setApellido("Jaaq");
            in.setDireccion("Almirante Brown 750");
            lista.add(new Contrato(1, "prueba", new Date(), new Date(), 20000, 1, i, 1, in));

        }

        if(direccion.equals("Javier Loyola 1365")) {
            i.setNombre("Alberto");
            i.setApellido("Gutierrez");
            in.setDireccion("Javier Loyola 1365");
            lista.add(new Contrato(2, "prueba2", new Date(), new Date(), 22200, 1, i, 1, in));
        }

        this.listaContratos.setValue(lista);

    }
}