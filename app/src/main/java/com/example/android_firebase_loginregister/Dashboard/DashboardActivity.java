package com.example.android_firebase_loginregister.Dashboard;

import android.content.Intent;
import android.os.Bundle;

import com.example.android_firebase_loginregister.Login.LoginActivity;
import com.example.android_firebase_loginregister.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class DashboardActivity extends AppCompatActivity {

    //Variáveis:
    private FirebaseAuth firebaseAuth;
    //Função para usuário sair do estado de logado;
    private void usuarioSair(){
        System.out.println("\nusuarioSair:\nUsuário saindo...");
        firebaseAuth.getInstance().signOut();
    }
    //Finaliza o activity atual e redireciona para o Login
    public void acessaLoginActivity() {
        finish();
        startActivity(new Intent(this, LoginActivity.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        FloatingActionButton fab = findViewById(R.id.activity_dashboard_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuarioSair();
                acessaLoginActivity();
            }
        });
    }
}