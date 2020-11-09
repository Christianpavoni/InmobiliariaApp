package com.example.inmobiliaria.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.inmobiliaria.R;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsuario;
    private EditText etPassword;
    private Button btLogin;
    private LoginActivityViewModel vm;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inicializar();
    }

    public void inicializar(){
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LoginActivityViewModel.class);

        vm.getMsg().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String msg) {
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
            }
        });

        etUsuario=findViewById(R.id.etUsuario);
        etPassword=findViewById(R.id.etPassword);
        btLogin=findViewById(R.id.btLogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    vm.iniciarSesion(etUsuario.getText().toString(),etPassword.getText().toString());
            }
        });



    }
}
