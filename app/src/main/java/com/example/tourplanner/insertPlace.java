package com.example.tourplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class insertPlace extends AppCompatActivity {
    EditText pName, pPrice, pOffer, pDetails, pImgUrl;
    Button submit;
    boolean valid = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_place);

        pName = findViewById(R.id.placeNameId);
        pPrice = findViewById(R.id.placePriceId);
        pOffer = findViewById(R.id.placeOfferId);
        pDetails = findViewById(R.id.placeDetailsId);
        pImgUrl = findViewById(R.id.placeImageId);
        submit = findViewById(R.id.submitPlaceId);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkField(pName);
                checkField(pPrice);
                checkField(pOffer);
                checkField(pDetails);
                checkField(pImgUrl);

                if(valid){
                    String name = pName.getText().toString().trim();
                    String price = pPrice.getText().toString().trim();
                    String offer = pOffer.getText().toString().trim();
                    String detail = pDetails.getText().toString().trim();
                    String imurl = pImgUrl.getText().toString().trim();

                    model obj = new model(detail,imurl,name,offer,price);
                    FirebaseDatabase db = FirebaseDatabase.getInstance();
                    DatabaseReference node = db.getReference("places");
                    node.child(name).setValue(obj);
                    Toast.makeText(getApplicationContext(),"Wow! new place added Succesfully",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }else{
                    Toast.makeText(getApplicationContext(),"Sorry! make sure to fil all fields",Toast.LENGTH_LONG).show();

                }


            }
        });

    }


    public void createPlace(View view) {



    }
    public boolean checkField(EditText textField){
        if(textField.getText().toString().isEmpty()){
            textField.setError("Error");
            valid = false;
        }else {
            valid = true;
        }

        return valid;
    }
}