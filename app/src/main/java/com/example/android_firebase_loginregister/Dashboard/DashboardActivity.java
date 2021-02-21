package com.example.android_firebase_loginregister.Dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_firebase_loginregister.Login.LoginActivity;
import com.example.android_firebase_loginregister.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class DashboardActivity extends AppCompatActivity {

    //Variáveis:
    private FirebaseAuth firebaseAuth;
    private TextView textView_userId;
    private TextView textView_userEmail;
    private Button button_resetEmail;
    private FloatingActionButton floatingActionButton;
    //Função para usuário sair do estado de logado;
    private void usuarioSair() {
        System.out.println("\nusuarioSair:\nUsuário saindo...");
        firebaseAuth.getInstance().signOut();
    }

    //Função para retornar email do usuário;
    private FirebaseAuth usuarioEmail(FirebaseAuth firebaseAuth) {
        System.out.println("\nusuarioSair:\nUsuário saindo...");

        return firebaseAuth;
    }

    //Finaliza o activity atual e redireciona para o Login
    public void acessaLoginActivity() {
        finish();
        startActivity(new Intent(this, LoginActivity.class));
    }

    //Função para inicializar variáveis para onCrate;
    private void inicializarVariaveis() {
        textView_userId = findViewById(R.id.activity_dashboard_textView_userId);
        textView_userEmail = findViewById(R.id.activity_dashboard_textView_userEmail);
    }

    private void setTextoVariaveis() {
        textView_userId.setText(" Usuário UID: "+firebaseAuth.getInstance().getCurrentUser().getUid());
        textView_userEmail.setText(" Usuário Email: "+firebaseAuth.getInstance().getCurrentUser().getEmail().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        
        floatingActionButton = findViewById(R.id.activity_dashboard_fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuarioSair();
                acessaLoginActivity();
            }
        });

        button_resetEmail = findViewById(R.id.activity_dashboard_button_resetEmail);

        button_resetEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Button reset");
            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();
        inicializarVariaveis();
        setTextoVariaveis();
    }
}