package com.example.androidbti.exemplofirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class ActivityPrincipal extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void sair(View view) {
        firebaseAuth.signOut();
        finish();
    }
}
