package com.example.inmobiliaria.ui.inquilinos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.modelo.Inmueble;
import com.example.inmobiliaria.modelo.Inquilino;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class InquilinosViewModel extends ViewModel {

    private MutableLiveData<List<Inquilino>> inquilinos;

    public InquilinosViewModel() {

    }

    public LiveData<List<Inquilino>> getInquilinos() {
        if(inquilinos==null){
            inquilinos=new MutableLiveData<List<Inquilino>>();
        }
        return inquilinos;
    }

    public void recuperarInquilinos(){

        List<Inquilino> lista= new ArrayList<>();
        lista.add(new Inquilino(1,"Lopez","Alberto", BigInteger.valueOf(35916930),BigInteger.valueOf(266548952), "albertolopez@gmail.com", "cesida","Lopez Juan", BigInteger.valueOf(15654897),BigInteger.valueOf(266548973),"lopezjuan@gmail.com"));
        lista.add(new Inquilino(2,"Alcaraz","Luciano", BigInteger.valueOf(39912930),BigInteger.valueOf(266548970), "alcarazluciano@gmail.com", "cesida","Lopez Juan", BigInteger.valueOf(15654897),BigInteger.valueOf(266548973),"lopezjuan@gmail.com"));

        inquilinos.setValue(lista);

    }

}