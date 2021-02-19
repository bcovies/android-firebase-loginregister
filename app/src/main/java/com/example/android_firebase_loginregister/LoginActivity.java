package com.example.android_firebase_loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    //Variáveis:
    private EditText editText_email;
    private EditText editText_password;
    private Button button_login;
    private Button button_register;
    private String email;
    private String password;
    private FirebaseAuth firebaseAuth;

    //Função para verificar se usuário está logado;
    private boolean usuarioLogado() {
        final FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        boolean logado = false;
        if (currentUser != null) {
            System.out.println("\nUsuário ESTÁ logado");
            logado = true;
        } else {
            System.out.println("\nUsuário NÃO está logado");
        }
        return logado;
    }
    //função inicalizar outra acitivy
    public void acessaDashboardActivity() {
        finish();
        startActivity(new Intent(this, DashboardActivity.class));
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (usuarioLogado()) {
            acessaDashboardActivity();
        }
    }


    //Função para inicializar variáveis para onCrate;
    private void inicializarVariaveis() {
        editText_email = findViewById(R.id.activity_main_editTextTextEmailAddress);
        editText_password = findViewById(R.id.activity_main_editTextTextPassword);
        button_login = findViewById(R.id.activity_main_buttonLogin);
        button_register = findViewById(R.id.activity_main_buttonRegister);
    }

    //Aloca EditText para email e password;
    public void alocarVariaveisString() {
        email = editText_email.getText().toString();
        password = editText_password.getText().toString();
    }

    //Função para Alocar firebaseAuth e permitir a criação da função para criar login no Firebase;
    private void inicializaFirebaseAuth() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    //Função que cadastra o usuário no banco de dados Firebase;
    private void cadastrarUsuarioFirebase(String email, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    System.out.println("\nCadastrado com sucesso!");
                    acessaDashboardActivity();
                }
            }
        });
    }

    //Função que acessa o usuário no banco de dados Firebase;
    private void acessarUsuarioFirebase(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    System.out.println("\nAcessado com sucesso!");
                    acessaDashboardActivity();
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Inicializa as variáveis;
        inicializarVariaveis();
        //Inicializa FirebaseAuth;
        inicializaFirebaseAuth();
        //Cria um "Listener" para botão de login;
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alocarVariaveisString();
                System.out.println("\nBotão Login:\nEmail: " + email + "\nSenha: " + password);
                acessarUsuarioFirebase(email, password);
            }
        });
        //Cria um "Listener" para o botão de register;
        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alocarVariaveisString();
                //Aloca Variáveis necessárias para condição de registro;
                final boolean emailArroba = email.contains("@");
                final int tamanhoSenha = password.length();
                //Cria condicional para filtrar condições para criar conta para Firebase;
                if (tamanhoSenha > 5 && emailArroba) {
                    System.out.println("\nBotão Register:\nEmail: " + email + "\nSenha: " + password + "\nTamanho senha: " + tamanhoSenha);
                    cadastrarUsuarioFirebase(email, password);

                } else {
                    System.out.println("\nCondição necessária não alcançada");
                }
            }
        });
    }


}