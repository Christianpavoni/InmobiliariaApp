package com.example.inmobiliaria.ui.contratos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.modelo.Contrato;
import com.example.inmobiliaria.modelo.Pago;

import java.util.ArrayList;
import java.util.List;

public class ListadoContratosFragment extends Fragment {

    private ListadoContratosViewModel vm;

    private ListView listaContratos;
    private ArrayAdapter<Contrato> adapter;

    public static ListadoContratosFragment newInstance() {
        return new ListadoContratosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.lista_contratos_fragment, container, false);
        inicializar(root);
        return root;
    }

    public void inicializar(View view) {
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ListadoContratosViewModel.class);

        listaContratos=view.findViewById(R.id.listaContratos);


        vm.getListaContratos().observe(getViewLifecycleOwner(), new Observer<ArrayList<Contrato>>() {
            @Override
            public void onChanged(ArrayList<Contrato> contratos) {

                //Generar List View
                adapter=new ListaAdapter(getContext(),R.layout.lista_contratos_item,contratos,getLayoutInflater());
                listaContratos.setAdapter(adapter);

            }
        });

        vm.cargarContratos(getArguments());
    }

    public class ListaAdapter extends ArrayAdapter<Contrato> {
        private Context context;
        private List<Contrato> lista;
        private LayoutInflater li;

        public ListaAdapter(@NonNull Context context, int resource, @NonNull List<Contrato> objects, LayoutInflater li) {
            super(context, resource, objects);
            this.context=context;
            this.lista=objects;
            this.li=li;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            View itemView=convertView;
            if(itemView==null){
                itemView=li.inflate(R.layout.lista_contratos_item,parent,false);
            }
            Contrato contrato= lista.get(position);

            TextView inmueble=itemView.findViewById(R.id.tvInmueble);
            inmueble.setText(contrato.getInmueble().getDireccion());

            TextView fechaIni=itemView.findViewById(R.id.tvFechaIni);
            fechaIni.setText(contrato.getFechaDeInicio()+"");

            TextView fechaFin=itemView.findViewById(R.id.tvFechaFin);
            fechaFin.setText(contrato.getFechaDeFinalizacion()+"");

            TextView inquilino=itemView.findViewById(R.id.tvInquilino);
            inquilino.setText(contrato.getInquilino().getNombre() + " " + contrato.getInquilino().getApellido());

            return itemView;
        }
    }

}