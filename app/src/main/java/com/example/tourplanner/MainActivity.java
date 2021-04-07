package com.example.tourplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    NavigationView navView;
    ActionBarDrawerToggle myToggle;
    DrawerLayout myDrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                }
                return true;
            }
        });
    }


}