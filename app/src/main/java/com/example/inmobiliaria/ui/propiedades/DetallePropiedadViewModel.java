package com.example.inmobiliaria.ui.propiedades;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bumptech.glide.Glide;
import com.example.inmobiliaria.R;
import com.example.inmobiliaria.modelo.Inmueble;
import com.example.inmobiliaria.modelo.Propietario;
import com.example.inmobiliaria.request.ApiClient;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetallePropiedadViewModel extends AndroidViewModel {
    private MutableLiveData<Inmueble> inmueble;
    private Context context;

    public DetallePropiedadViewModel(@NonNull Application application) {
        super(application);
        this.context=application.getApplicationContext();
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

    public void editarInmueble(Inmueble i,Bundle bundle){

        Inmueble in= (Inmueble) bundle.getSerializable("inmueble");

        i.setIdPropietario(in.getIdPropietario());
        i.setIdInmueble(in.getIdInmueble());
        i.setFoto(in.getFoto());

        SharedPreferences sp= context.getSharedPreferences("data",0);
        String token = sp.getString("token","");

        Call<Inmueble> prop= ApiClient.getMyApiInterface().editarInmueble(token,i);

        prop.enqueue(new Callback<Inmueble>() {
            @Override
            public void onResponse(Call<Inmueble> call, Response<Inmueble> response) {
                if(response.isSuccessful()){
                    inmueble.setValue(response.body());
                    Toast.makeText(context,"Actualizado con exito.",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(context,"Error al actualizar el perfil.",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Inmueble> call, Throwable t) {
                Toast.makeText(context,"Error al actualizar el perfil",Toast.LENGTH_LONG).show();
            }
        });

    }
}