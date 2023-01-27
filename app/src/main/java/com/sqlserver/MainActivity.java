package com.sqlserver;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
//implements NavigationView.OnNavigationItemSelectedListener
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Menu menu;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);

        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);

        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView, navController);

//        textView=findViewById(R.id.textView);
//        toolbar=findViewById(R.id.toolbar);

//        setSupportActionBar(toolbar);
//
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.menuPolyclinics:
//                Intent intent = new Intent(MainActivity.this, com.sqlserver.polyclinic.MainActivity.class);
//                startActivity(intent);
//                break;
//
//            case R.id.menuDoctors:
//                Intent intent1 = new Intent(MainActivity.this, com.sqlserver.doctor.MainActivity.class);
//                startActivity(intent1);
//                break;
//        }
//
//        drawerLayout.closeDrawer(GravityCompat.START);
//        return true;
//    }
}

















