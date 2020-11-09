package com.example.inmobiliaria.ui.contratos;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.modelo.Contrato;
import com.example.inmobiliaria.modelo.Inmueble;
import com.example.inmobiliaria.modelo.Inquilino;
import com.example.inmobiliaria.modelo.Pago;
import com.example.inmobiliaria.modelo.Propietario;
import com.example.inmobiliaria.request.ApiClient;

import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContratosViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<ArrayList<Inmueble>> inmuebles;
    private MutableLiveData<ArrayList<Contrato>> listaContratos;

    public ContratosViewModel(@NonNull Application application) {
        super(application);
        this.context=application.getApplicationContext();
    }

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

        SharedPreferences sp= context.getSharedPreferences("data",0);
        String token = sp.getString("token","");

        Call<ArrayList<Inmueble>> prop= ApiClient.getMyApiInterface().obtenerInmuebles(token);

        prop.enqueue(new Callback<ArrayList<Inmueble>>() {
            @Override
            public void onResponse(Call<ArrayList<Inmueble>> call, Response<ArrayList<Inmueble>> response) {
                if(response.isSuccessful()){
                    inmuebles.postValue(response.body());
                }
                else{
                    Toast.makeText(context,"Error al cargar inmuebles.",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Inmueble>> call, Throwable t) {
                Toast.makeText(context,"Error al recuperar datos",Toast.LENGTH_LONG).show();
            }
        });

    }

    public void cargarListaDeContratos(int idInmueble) {

        SharedPreferences sp= context.getSharedPreferences("data",0);
        String token = sp.getString("token","");

        Call<ArrayList<Contrato>> prop= ApiClient.getMyApiInterface().obtenerContratosPorInmueble(token,idInmueble);

        prop.enqueue(new Callback<ArrayList<Contrato>>() {
            @Override
            public void onResponse(Call<ArrayList<Contrato>> call, Response<ArrayList<Contrato>> response) {
                if(response.isSuccessful()){
                    listaContratos.postValue(response.body());
                }
                else{
                    Toast.makeText(context,"Error al cargar contratos.",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Contrato>> call, Throwable t) {
                Toast.makeText(context,"Error al recuperar datos: "+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }
}