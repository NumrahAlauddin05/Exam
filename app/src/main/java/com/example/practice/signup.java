package com.example.practice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {
    EditText emailET;
    EditText passEt;
    EditText nameet;
    FirebaseDatabase database;
    FirebaseAuth auth;
    DatabaseReference refrence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        init();
    }

    private void init() {

        emailET = findViewById(R.id.emailET);
        passEt = findViewById(R.id.passET);
        nameet= findViewById(R.id.editText);
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        refrence = database.getReference();


    }

    public void signupBtn(View view) {

        final String name = nameet.getText().toString();

        final String email = emailET.getText().toString();
        final String pass = passEt.getText().toString();

        Log.e("name",name); Log.e("email",email);
        Log.e("pass", pass);

        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Log.e("pass", pass);
                    String key = auth.getCurrentUser().getUid();
                    Log.e("key", key);
                    User user=new User(email,pass,name);
                    refrence.child(key).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                            Intent intent = new Intent(signup.this,Home.class);
                            intent.putExtra("name",name);
                            intent.putExtra("pass",pass);
                            intent.putExtra("email",email);
                            startActivity(intent);}
                            else{
                                Toast.makeText(signup.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                } else {
                    Toast.makeText(signup.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
