package com.example.navdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item1:
                        Toast.makeText(MainActivity.this, "Clicked item 1", Toast.LENGTH_SHORT).show(); break;

                    case R.id.item2:
                        Toast.makeText(MainActivity.this, "Clicked item 2", Toast.LENGTH_SHORT).show(); break;

                    case R.id.item3:
                        Toast.makeText(MainActivity.this, "Clicked item 3", Toast.LENGTH_SHORT).show(); break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        switch (item.getItemId()){
            case R.id.miAddContact: Toast.makeText(this, "Clicked add contacts", Toast.LENGTH_SHORT).show(); break;
            case R.id.miSettings: Toast.makeText(this, "Clicked settings", Toast.LENGTH_SHORT).show(); break;
            case R.id.miFav: Toast.makeText(this, "Clicked favorite", Toast.LENGTH_SHORT).show(); break;
            case R.id.miFeedback: Toast.makeText(this, "Clicked send feedback", Toast.LENGTH_SHORT).show(); break;
            case R.id.miClose: finish(); break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_bar_menu, menu);
        return true;
    }
}