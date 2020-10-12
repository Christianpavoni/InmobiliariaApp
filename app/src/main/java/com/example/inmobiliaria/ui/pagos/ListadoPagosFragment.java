package com.example.inmobiliaria.ui.pagos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.modelo.Pago;

import java.util.ArrayList;
import java.util.List;

public class ListadoPagosFragment extends Fragment {

    private ListadoPagosViewModel vm;
    private ArrayList<Pago> lista=new ArrayList<>();
    private ListView listaPagos;
    private ArrayAdapter<Pago> adapter;

    public static ListadoPagosFragment newInstance() {
        return new ListadoPagosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.lista_pagos_fragment, container, false);
        inicializar(root);
        return root;
    }

    public void inicializar(View view) {
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ListadoPagosViewModel.class);

        listaPagos=view.findViewById(R.id.listaPagos);


        vm.getListaPagos().observe(getViewLifecycleOwner(), new Observer<ArrayList<Pago>>() {
            @Override
            public void onChanged(ArrayList<Pago> pagos) {

                //Generar List View
                adapter=new ListaAdapter(getContext(),R.layout.lista_pagos_item,pagos,getLayoutInflater());
                listaPagos.setAdapter(adapter);

            }
        });

        vm.cargarPagos(getArguments());
    }

    public class ListaAdapter extends ArrayAdapter<Pago> {
        private Context context;
        private List<Pago> lista;
        private LayoutInflater li;

        public ListaAdapter(@NonNull Context context, int resource, @NonNull List<Pago> objects, LayoutInflater li) {
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
                itemView=li.inflate(R.layout.lista_pagos_item,parent,false);
            }
            Pago pago= lista.get(position);

            TextView idpago=itemView.findViewById(R.id.tvIdPago);
            idpago.setText(pago.getIdPago()+"");

            TextView importe=itemView.findViewById(R.id.tvImporte);
            importe.setText(pago.getImporte()+"");

            TextView fecha=itemView.findViewById(R.id.tvFechaPago);
            fecha.setText(pago.getFechaDePago()+"");

            return itemView;
        }
    }

}