package com.example.inmobiliaria.ui.propiedades;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.modelo.Inmueble;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class PropiedadesFragment extends Fragment {

    private PropiedadesViewModel vm;
    private ViewPager2 viewPage;
    private TabLayout tabLayout;
    private AppBarLayout appBar;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.propiedades_fragment, container, false);
        inicializar(root);
        return root;
    }

    public void inicializar(View view){

        viewPage=view.findViewById(R.id.viewPage);
        appBar=view.findViewById(R.id.appBar);
        tabLayout=new TabLayout(getContext());

        appBar.addView(tabLayout);



        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PropiedadesViewModel.class);

        vm.getInmuebles().observe(getViewLifecycleOwner(), new Observer<List<Inmueble>>() {
            @Override
            public void onChanged(List<Inmueble> inmuebles) {
                ViewPageAdapter vpa=new ViewPageAdapter(getParentFragmentManager(),getLifecycle());

                int n=1;
                for (Inmueble inmueble :inmuebles) {

                    Bundle bundle=new Bundle();
                    bundle.putSerializable("inmueble",inmueble);
                    DetallePropiedadFragment f=new DetallePropiedadFragment();
                    f.setArguments(bundle);
                    vpa.addFragment(f);
                    n++;

                }

                viewPage.setAdapter(vpa);
                new TabLayoutMediator(tabLayout, viewPage, new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText("Inmueble "+(position+1));
                    }
                }).attach();
            }
        });
        vm.recuperarInmuebles();

    }

    public class ViewPageAdapter extends FragmentStateAdapter {

        private List<Fragment> fragmentList= new ArrayList<>();

        public ViewPageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getItemCount() {
            return fragmentList.size();
        }


        public void addFragment(Fragment fragment){
            fragmentList.add(fragment);
        }
    }
}