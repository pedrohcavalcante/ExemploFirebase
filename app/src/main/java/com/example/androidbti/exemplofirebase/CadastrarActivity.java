package com.example.androidbti.exemplofirebase;

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

public class CadastrarActivity extends AppCompatActivity {

    private EditText emailCadastro;
    private EditText senhaCadastro;
    
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        emailCadastro = findViewById(R.id.edt_email);
        senhaCadastro = findViewById(R.id.edt_senha);
        firebaseAuth = FirebaseAuth.getInstance();
        
    }

    public void cadastrar(View view) {
        String email = emailCadastro.getText().toString().trim();
        String senha = senhaCadastro.getText().toString();
        
        firebaseAuth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(CadastrarActivity.this, "Rolou", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CadastrarActivity.this, "Não rolou", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
