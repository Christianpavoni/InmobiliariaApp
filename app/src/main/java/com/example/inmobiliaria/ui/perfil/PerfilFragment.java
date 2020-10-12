package com.example.inmobiliaria.ui.perfil;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.modelo.Propietario;

public class PerfilFragment extends Fragment {

    private PerfilViewModel vm;

    private EditText etNombre;
    private EditText etApellido;
    private EditText etEmail;
    private EditText etPassword;
    private Button btEditar;
    private Button btAceptar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.perfil_fragment, container, false);
        inicializar(root);
        return root;
    }

    public void inicializar(View view){

        etNombre=view.findViewById(R.id.etNombre);
        etApellido=view.findViewById(R.id.etApellido);
        etEmail=view.findViewById(R.id.etEmail);
        etPassword=view.findViewById(R.id.etPassword);
        btEditar=view.findViewById(R.id.btEditar);
        btAceptar=view.findViewById(R.id.btAceptar);

        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PerfilViewModel.class);
        vm.getPropietario().observe(getViewLifecycleOwner(), new Observer<Propietario>() {
            @Override
            public void onChanged(Propietario propietario) {
                etNombre.setText(propietario.getNombre());
                etApellido.setText(propietario.getApellido());
                etEmail.setText(propietario.getEmail());
                etPassword.setText(propietario.getPassword());
            }
        });

        vm.recuperarPropietario();
        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etNombre.setEnabled(true);
                etApellido.setEnabled(true);
                etEmail.setEnabled(true);
                etPassword.setEnabled(true);
                btAceptar.setVisibility(View.VISIBLE);
                btEditar.setVisibility(View.GONE);
            }
        });

        btAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                etNombre.setEnabled(false);
                etApellido.setEnabled(false);
                etEmail.setEnabled(false);
                etPassword.setEnabled(false);
                btAceptar.setVisibility(View.GONE);
                btEditar.setVisibility(View.VISIBLE);
            }
        });


    }
}