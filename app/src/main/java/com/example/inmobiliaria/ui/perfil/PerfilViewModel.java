package com.example.inmobiliaria.ui.perfil;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria.modelo.Propietario;
import com.example.inmobiliaria.request.ApiClient;
import com.google.gson.Gson;

import java.math.BigInteger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Body;

public class PerfilViewModel extends AndroidViewModel {

    private MutableLiveData<Propietario> propietario;
    private Context context;


    public PerfilViewModel( @NonNull Application application) {
        super(application);
        this.context=application.getApplicationContext();

    }

    public LiveData<Propietario> getPropietario() {
        if(propietario==null){
            propietario=new MutableLiveData<>();
        }
        return propietario;
    }

    public void recuperarPropietario(){

        SharedPreferences sp= context.getSharedPreferences("data",0);
        String token = sp.getString("token","");
        Call<Propietario> prop= ApiClient.getMyApiInterface().obtenerPropietario(token);

        prop.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                if(response.isSuccessful()){

                    SharedPreferences sp=context.getSharedPreferences("propietario",0);
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putString("nombre",response.body().getNombre());
                    editor.putString("apellido",response.body().getApellido());
                    editor.putString("email",response.body().getEmail());
                    editor.putString("dni",response.body().getDni()+"");
                    editor.putString("telefono",response.body().getTelefono()+"");
                    editor.putString("clave",response.body().getClave());
                    editor.commit();

                    propietario.setValue(response.body());

                }
                else{
                    Toast.makeText(context,"Error al cargar perfil.",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Propietario> call, Throwable t) {
                Toast.makeText(context,"Error al recuperar datos.",Toast.LENGTH_LONG).show();
            }
        });


    }

    public void editarPropietario(String nombre,String apellido,String email,String dni, String telefono){

        SharedPreferences sp= context.getSharedPreferences("data",0);
        String token = sp.getString("token","");

        SharedPreferences sp2=context.getSharedPreferences("propietario",0);
        String clave=sp2.getString("clave","");

        Propietario p=new Propietario();
        p.setNombre(nombre);
        p.setApellido(apellido);
        p.setEmail(email);
        p.setDni(dni);
        p.setTelefono(telefono);
        p.setClave(clave);


        Call<Propietario> prop= ApiClient.getMyApiInterface().editarPropietario(token,p);

        prop.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response) {

                if(response.isSuccessful()){

                    SharedPreferences sp=context.getSharedPreferences("propietario",0);
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putString("nombre",response.body().getNombre());
                    editor.putString("apellido",response.body().getApellido());
                    editor.putString("email",response.body().getEmail());
                    editor.putString("dni",response.body().getDni()+"");
                    editor.putString("telefono",response.body().getTelefono()+"");
                    editor.putString("clave",response.body().getClave());
                    editor.commit();

                    propietario.setValue(response.body());
                    Toast.makeText(context,"Actualizado con exito.",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(context,"Error al actualizar el perfil.",Toast.LENGTH_LONG).show();
                    recuperarPropietario();
                }
            }

            @Override
            public void onFailure(Call<Propietario> call, Throwable t) {
                Toast.makeText(context,"Error al actualizar el perfil.",Toast.LENGTH_LONG).show();
            }
        });


    }

}