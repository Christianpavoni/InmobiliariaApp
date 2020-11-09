package com.example.inmobiliaria.request;

import com.example.inmobiliaria.modelo.Contrato;
import com.example.inmobiliaria.modelo.Inmueble;
import com.example.inmobiliaria.modelo.Propietario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public class ApiClient {

    private static final String PATH="http://131.72.73.36:45501/api/";
    private static MyApiInterface myApiInterface;

    public static MyApiInterface getMyApiInterface(){

        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(PATH)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        myApiInterface=retrofit.create(MyApiInterface.class);

        return myApiInterface;

    }

    public interface MyApiInterface{
        @FormUrlEncoded
        @POST("Propietarios/login")
        Call<String> obtenerToken(@Field("Usuario") String usuario,@Field("Clave") String clave);

        @GET("Propietarios")
        Call<Propietario> obtenerPropietario(@Header("Authorization") String authorization);

        @PUT("Propietarios")
        Call<Propietario> editarPropietario(@Header("Authorization") String authorization,@Body Propietario propietario);

        @GET("Inmuebles")
        Call<ArrayList<Inmueble>> obtenerInmuebles(@Header("Authorization") String authorization);

        @PUT("Inmuebles")
        Call<Inmueble> editarInmueble(@Header("Authorization") String authorization,@Body Inmueble inmueble);

        @GET("Contratos/inmueble/{IdInmueble}")
        Call<ArrayList<Contrato>> obtenerContratosPorInmueble(@Header("Authorization") String authorization, @Path("IdInmueble") int IdInmueble);

    }


}
