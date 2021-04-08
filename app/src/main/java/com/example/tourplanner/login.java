package com.example.tourplanner;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    EditText mailEdittext, passEditText;
    Button loginButton,signUpButton;
    FirebaseAuth myAuth;
    boolean validity = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mailEdittext = findViewById(R.id.email_login);
        passEditText = findViewById(R.id.pass_login);

        loginButton = (Button) findViewById(R.id.signBtId);
        signUpButton = findViewById(R.id.signUpBtId);

        myAuth = FirebaseAuth.getInstance();
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this,register.class));
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkField(mailEdittext);
                checkField(passEditText);
                if(validity){
                    myAuth.signInWithEmailAndPassword(mailEdittext.getText().toString(),passEditText.getText().toString())
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    Toast.makeText(login.this, "Signed In Succesfully!", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(login.this, MainActivity.class));
                                    mailEdittext.setText("");
                                    passEditText.setText("");
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(login.this, "Something Wrong! Try again", Toast.LENGTH_LONG).show();

                        }
                    });
                }else {
                    Toast.makeText(getApplicationContext(),"Enter Valid email and Password",Toast.LENGTH_LONG).show();
                }

            }
        });



    }
    public boolean checkField(EditText textField){
        if(textField.getText().toString().isEmpty()){
            textField.setError("Error");
            validity = false;
        }else {
            validity = true;
        }

        return validity;
    }


}