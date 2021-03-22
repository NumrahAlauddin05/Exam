package com.example.practice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    EditText email;
    EditText pass;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

    }

    private void init() {
        auth = FirebaseAuth.getInstance();
        email = findViewById(R.id.name);
        pass = findViewById(R.id.pass);
    }


    public void signupbtn(View view) {
        Intent intent = new Intent(login.this, signup.class);
        startActivity(intent);
    }

    public void login(View view) {

        String mail = email.getText().toString();
        String pas = pass.getText().toString();


        auth.signInWithEmailAndPassword(mail, pas).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    Intent intent = new Intent(login.this, Home.class);
                    startActivity(intent);


                } else {


                    Toast.makeText(login.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
