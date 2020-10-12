package com.example.inmobiliaria.ui.inquilinos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.modelo.Inquilino;
import com.example.inmobiliaria.modelo.Propietario;
import com.example.inmobiliaria.ui.perfil.PerfilViewModel;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class InquilinosFragment extends Fragment {

    private InquilinosViewModel vm;
    private ArrayList<Inquilino> lista=new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.inquilinos_fragment, container, false);
        inicializar(root);
        return root;
    }

    public void inicializar(final View view){

        final ListView lv=view.findViewById(R.id.listaInquilinos);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InquilinosViewModel.class);

        vm.getInquilinos().observe(getViewLifecycleOwner(), new Observer<List<Inquilino>>() {
            @Override
            public void onChanged(List<Inquilino> inquilinos) {
                ArrayAdapter<Inquilino> adapter=new ListaAdapter(getContext(),R.layout.inquilinos_item,inquilinos,getLayoutInflater());
                lv.setAdapter(adapter);
            }
        });

       vm.recuperarInquilinos();


    }

    public class ListaAdapter extends ArrayAdapter<Inquilino> {
        private Context context;
        private List<Inquilino> lista;
        private LayoutInflater li;

        public ListaAdapter(@NonNull Context context, int resource, @NonNull List<Inquilino> objects, LayoutInflater li) {
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
                itemView=li.inflate(R.layout.inquilinos_item,parent,false);
            }
            Inquilino inquilino= lista.get(position);

            TextView apellido=itemView.findViewById(R.id.tvApellido);
            apellido.setText(inquilino.getApellido());

            TextView nombre=itemView.findViewById(R.id.tvNombre);
            nombre.setText(inquilino.getNombre());

            TextView dni=itemView.findViewById(R.id.tvDni);
            dni.setText(inquilino.getDni()+"");

            TextView telefono=itemView.findViewById(R.id.tvTelefono);
            telefono.setText(inquilino.getTelefono()+"");

            TextView garante=itemView.findViewById(R.id.tvGarante);
            garante.setText(inquilino.getNombreGarante());

            return itemView;
        }
    }

}