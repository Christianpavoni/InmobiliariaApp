package com.example.inmobiliaria.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliaria.MainActivity;

public class LoginActivityViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<String> error;

    public LoginActivityViewModel(@NonNull Application application) {
        super(application);
        this.context=application.getApplicationContext();
    }

    public LiveData<String> getError() {
        if(error==null){
            error=new MutableLiveData<>();
        }
        return error;
    }

    public void iniciarSesion(String usuario, String password){
        String user= "cpavoni@gmail.com";
        String pass= "123";
        if(usuario.equals(user) && password.equals(pass)){
            Intent i=new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }else{
            error.setValue("El usuario o password son incorrectos.");
        }

    }
}
