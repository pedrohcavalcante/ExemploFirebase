package com.example.androidbti.exemplofirebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText emailLogin;
    private EditText senhaLogin;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailLogin = findViewById(R.id.inserir_email);
        senhaLogin = findViewById(R.id.inserir_senha);

        firebaseAuth = FirebaseAuth.getInstance();

    }

    public void logar(View view) {

        firebaseAuth.signInWithEmailAndPassword(emailLogin.getText().toString().trim(), senhaLogin.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Rolou", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, ActivityPrincipal.class));
                } else {
                    Toast.makeText(LoginActivity.this, "Não rolou", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
