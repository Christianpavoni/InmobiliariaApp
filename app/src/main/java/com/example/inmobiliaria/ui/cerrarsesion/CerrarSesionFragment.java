package com.example.inmobiliaria.ui.cerrarsesion;

import androidx.lifecycle.ViewModelProviders;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inmobiliaria.R;

public class CerrarSesionFragment extends Fragment {

    private CerrarSesionViewModel mViewModel;

    public static CerrarSesionFragment newInstance() {
        return new CerrarSesionFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {



        AlertDialog.Builder alertDialog=new AlertDialog.Builder(getContext());
        alertDialog.setMessage("¿Esta seguro que quiere cerrar sesion?");
        alertDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                getActivity().finish();

            }
        });
        alertDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.perfilFragment);
            }
        });

        alertDialog.show();



        return null;
    }


}