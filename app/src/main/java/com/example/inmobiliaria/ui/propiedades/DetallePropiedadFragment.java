package com.example.inmobiliaria.ui.propiedades;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.modelo.Inmueble;

import java.util.ArrayList;

public class DetallePropiedadFragment extends Fragment {

    private DetallePropiedadViewModel vm;

    private ImageView ivFoto;
    private EditText etDireccion;
    private EditText etCantDeAmbientes;
    private Spinner spTipoDeInmueble;
    private Spinner spTipoDeUso;
    private EditText etPrecio;
    private CheckBox cbDisponible;
    private Button btEditar;
    private Button btAceptar;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.detalle_propiedad_fragment, container, false);
        inicializar(root);
        return root;


    }

    public void inicializar(View view){
        ivFoto=view.findViewById(R.id.ivFoto);
        etDireccion=view.findViewById(R.id.etDireccion);
        etCantDeAmbientes=view.findViewById(R.id.etCantDeAmbientes);

        spTipoDeInmueble=view.findViewById(R.id.spTipoDeInmueble);
        ArrayAdapter adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,Inmueble.getTipoDeInmuebles());
        spTipoDeInmueble.setAdapter(adapter);
        spTipoDeInmueble.setEnabled(false);

        spTipoDeUso=view.findViewById(R.id.spTipoDeUso);
        ArrayAdapter adapter2=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,Inmueble.getTipoDeUsos());
        spTipoDeUso.setAdapter(adapter2);
        spTipoDeUso.setEnabled(false);

        etPrecio=view.findViewById(R.id.etPrecio);
        cbDisponible=view.findViewById(R.id.cbDisponible);
        btEditar=view.findViewById(R.id.btEditar);
        btAceptar=view.findViewById(R.id.btAceptar);

        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etDireccion.setEnabled(true);
                etCantDeAmbientes.setEnabled(true);
                etPrecio.setEnabled(true);
                cbDisponible.setEnabled(true);
                spTipoDeInmueble.setEnabled(true);
                spTipoDeUso.setEnabled(true);
                btAceptar.setVisibility(View.VISIBLE);
                btEditar.setVisibility(View.GONE);

            }
        });

        btAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                etDireccion.setEnabled(false);
                etCantDeAmbientes.setEnabled(false);
                etPrecio.setEnabled(false);
                spTipoDeInmueble.setEnabled(false);
                spTipoDeUso.setEnabled(false);
                cbDisponible.setEnabled(false);
                btAceptar.setVisibility(View.GONE);
                btEditar.setVisibility(View.VISIBLE);
            }
        });

        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(DetallePropiedadViewModel.class);
        vm.getInmueble().observe(getViewLifecycleOwner(), new Observer<Inmueble>() {

            @Override
            public void onChanged(Inmueble inmueble) {

                etDireccion.setText(inmueble.getDireccion());
                etCantDeAmbientes.setText(inmueble.getCantDeAmbientes()+"");
                spTipoDeInmueble.setSelection(Inmueble.getTipoDeInmuebles().indexOf(inmueble.getTipoDeInmueble()));
                spTipoDeUso.setSelection(Inmueble.getTipoDeUsos().indexOf(inmueble.getTipoDeUso()));
                etPrecio.setText("$"+inmueble.getPrecio());
                cbDisponible.setChecked(inmueble.getDisponible());
                ivFoto.setImageResource(inmueble.getFoto());

            }
        });

        vm.recuperarInmueble(getArguments());





    }


}