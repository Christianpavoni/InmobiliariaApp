package com.example.inmobiliaria.ui.pagos;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria.modelo.Inquilino;
import com.example.inmobiliaria.modelo.Pago;

import java.util.ArrayList;

public class ListadoPagosViewModel extends ViewModel {


    private MutableLiveData<ArrayList<Pago>> listaPagos;

    public LiveData<ArrayList<Pago>> getListaPagos() {
        if (listaPagos == null) {
            listaPagos = new MutableLiveData<>();
        }
        return listaPagos;
    }

    public void cargarPagos(Bundle bundle){
        ArrayList<Pago> pagos = (ArrayList<Pago>) bundle.getSerializable("pagos");
        listaPagos.setValue(pagos);

    }
}