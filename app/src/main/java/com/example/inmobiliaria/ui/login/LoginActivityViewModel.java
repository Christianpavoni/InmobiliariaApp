package com.example.inmobiliaria.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliaria.MainActivity;
import com.example.inmobiliaria.request.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivityViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<String> msg;

    public LoginActivityViewModel(@NonNull Application application) {
        super(application);
        this.context=application.getApplicationContext();
    }

    public LiveData<String> getMsg() {
        if(msg==null){
            msg=new MutableLiveData<>();
        }
        return msg;
    }

    public void iniciarSesion(String usuario, String password){

        Call<String> token=ApiClient.getMyApiInterface().obtenerToken(usuario,password);
        token.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){

                    SharedPreferences sp=context.getSharedPreferences("data",0);
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putString("token","Bearer "+response.body());
                    editor.commit();

                    Intent i=new Intent(context, MainActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                }else{
                    msg.setValue("El usuario o password son incorrectos.");
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                msg.setValue("Error al recuperar datos.");
            }
        });


    }
}
