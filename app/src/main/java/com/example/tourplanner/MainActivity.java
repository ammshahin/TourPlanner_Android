package com.example.tourplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    NavigationView navView;
    ActionBarDrawerToggle myToggle;
    DrawerLayout myDrawer;
    FirebaseAuth myAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myAuth = FirebaseAuth.getInstance();

        Toolbar toolbar = findViewById(R.id.toolId);
        setSupportActionBar(toolbar);

        navView = findViewById(R.id.navId);
        myDrawer = findViewById(R.id.drawerId);

        myToggle = new ActionBarDrawerToggle(this, myDrawer, toolbar,R.string.open,R.string.close);
        myDrawer.addDrawerListener(myToggle);
        myToggle.syncState();

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menuId:
                        Toast.makeText(getApplicationContext(),"home is opened!",Toast.LENGTH_SHORT).show();
                        myDrawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.itemId:
                        Toast.makeText(getApplicationContext(),"Items is opened!",Toast.LENGTH_SHORT).show();
                        myDrawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.contactId:
                        Toast.makeText(getApplicationContext(),"Contact page is opened!",Toast.LENGTH_SHORT).show();
                        myDrawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.logoutId:
                        Toast.makeText(getApplicationContext(),"Logged Out Succesfully",Toast.LENGTH_LONG).show();
                        myDrawer.closeDrawer(GravityCompat.START);
                        myAuth.getInstance().signOut();
                        startActivity(new Intent(MainActivity.this,login.class));
                        break;
                }
                return true;
            }
        });
    }


}