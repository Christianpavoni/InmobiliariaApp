package com.example.inmobiliaria.ui.contratos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.inmobiliaria.R;
import com.example.inmobiliaria.modelo.Contrato;
import com.example.inmobiliaria.modelo.Inmueble;
import com.example.inmobiliaria.modelo.Pago;
import com.example.inmobiliaria.ui.pagos.PagosFragment;
import com.example.inmobiliaria.ui.pagos.PagosViewModel;

import java.util.ArrayList;
import java.util.List;

public class ContratosFragment extends Fragment {

    private ContratosViewModel vm;
    private ListView listaInmuebles;
    private ArrayAdapter<Inmueble> adapter;
    Inmueble inmueble;

    public static ContratosFragment newInstance() {
        return new ContratosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
         View root =inflater.inflate(R.layout.contratos_fragment, container, false);
        inicializar(root);
         return root;
    }

    public void inicializar(final View view){

        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ContratosViewModel.class);

        listaInmuebles=view.findViewById(R.id.listaInmueblesC);


        vm.getInmuebles().observe(getViewLifecycleOwner(), new Observer<ArrayList<Inmueble>>() {
            @Override
            public void onChanged(ArrayList<Inmueble> inmuebles) {

                //Generar List View
                adapter=new ContratosFragment.ListaAdapter(getContext(),R.layout.pagos_item,inmuebles,getLayoutInflater());
                listaInmuebles.setAdapter(adapter);

                listaInmuebles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        inmueble = adapter.getItem(i);
                        assert inmueble != null;

                        vm.getListaContratos().observe(getViewLifecycleOwner(), new Observer<ArrayList<Contrato>>() {
                            @Override
                            public void onChanged(ArrayList<Contrato> contratos) {
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("contratos", contratos);
                                Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.listaContratosFragment, bundle);
                            }
                        });

                        vm.cargarListaDeContratos(inmueble.getIdInmueble());


                    }
                });
            }
        });


        vm.cargarInmuebles();


    }

    public class ListaAdapter extends ArrayAdapter<Inmueble> {
        private Context context;
        private List<Inmueble> lista;
        private LayoutInflater li;

        public ListaAdapter(@NonNull Context context, int resource, @NonNull List<Inmueble> objects, LayoutInflater li) {
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
                itemView=li.inflate(R.layout.pagos_item,parent,false);
            }
            Inmueble inmueble= lista.get(position);

            ImageView foto=itemView.findViewById(R.id.ivFoto);
            Glide.with(getContext())
                    .load("http://131.72.73.36:45501"+inmueble.getFoto())
                    .placeholder(R.drawable.ic_launcher_background)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .fitCenter()
                    .into(foto);

            TextView direccion=itemView.findViewById(R.id.tvDireccion);
            direccion.setText(inmueble.getDireccion());

            return itemView;
        }
    }
}