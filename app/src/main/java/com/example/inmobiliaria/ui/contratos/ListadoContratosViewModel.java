package com.example.inmobiliaria.ui.contratos;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria.modelo.Contrato;
import com.example.inmobiliaria.modelo.Pago;

import java.util.ArrayList;

public class ListadoContratosViewModel extends ViewModel {


    private MutableLiveData<ArrayList<Contrato>> listaContratos;

    public LiveData<ArrayList<Contrato>> getListaContratos() {
        if (listaContratos == null) {
            listaContratos = new MutableLiveData<>();
        }
        return listaContratos;
    }

    public void cargarContratos(Bundle bundle){
        ArrayList<Contrato> contratos = (ArrayList<Contrato>) bundle.getSerializable("contratos");
        listaContratos.setValue(contratos);

    }
}