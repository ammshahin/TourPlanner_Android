package com.example.tourplanner;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {
    Button submitButton,alreadyRegistered;
    EditText name,email,password,phone;
    FirebaseAuth myAuth;
    ProgressBar myBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        myAuth = FirebaseAuth.getInstance();

        submitButton =  findViewById(R.id.submitId);
        alreadyRegistered =  findViewById(R.id.alreadyRegisterdeBt);
        myBar =  findViewById(R.id.proId);

        name = findViewById(R.id.nameId);
        email = findViewById(R.id.emailId);
        password = findViewById(R.id.passId);
        phone = findViewById(R.id.mobileId);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    myAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    Toast.makeText(register.this,"Wow! you signed up succesfully",Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(register.this, MainActivity.class));
                                    finish();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(register.this,"OOps something wrong!",Toast.LENGTH_LONG).show();
                        }
                    });

//                    myAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString())
//                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
//                                @Override
//                                public void onSuccess(AuthResult authResult) {
//                                    Toast.makeText(register.this,"Wow! you signed up succesfully",Toast.LENGTH_LONG).show();
//                                    startActivity(new Intent(register.this, MainActivity.class));
//                                    finish();
//                                }
//                            }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(register.this,"OOps something wrong!",Toast.LENGTH_LONG).show();
//
//                        }
//                    });


            }
        });
        alreadyRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(register.this,
                        login.class));
            }
        });

    }



//    public void submitFunction(View view) {
//
//    }


//    public void alreadyRegisterdFunction(View view) {
//        startActivity(new Intent(register.this,
//                login.class));
//    }
}