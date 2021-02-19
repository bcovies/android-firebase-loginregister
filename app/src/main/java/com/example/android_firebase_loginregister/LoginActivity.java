package com.example.android_firebase_loginregister;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    //Variáveis:
    EditText editText_email;
    EditText editText_password;
    Button button_login;
    Button button_register;

    //Função para inicializar variáveis para onCrate:
    private void inicializarVariaveis() {
        editText_email = findViewById(R.id.activity_main_editTextTextEmailAddress);
        editText_password = findViewById(R.id.activity_main_editTextTextPassword);
        button_login = findViewById(R.id.activity_main_buttonLogin);
        button_register = findViewById(R.id.activity_main_buttonRegister);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Inicializa as variáveis:
        inicializarVariaveis();
        //Cria um "Listener" para botão de login;
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Botão Login", Toast.LENGTH_SHORT).show();
            }
        });
        //Cria um "Listener" para o botão de register;
        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Botão Register", Toast.LENGTH_SHORT).show();
            }
        });

    }


}