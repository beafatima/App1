package com.example.app1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public abstract class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle;
        toggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    protected abstract void setSupportActionBar(Toolbar toolbar);


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
        int id = item.getItemId();

        if (id == R.id.gameplay) {
            intent = new Intent(MainActivity.this, GameplayActivity.class);
            startActivity(intent);
        } else if (id == R.id.archive) {
            Toast.makeText(MainActivity.this, "Archive Selected", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.history) {
            Toast.makeText(MainActivity.this, "History Selected", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.profile) {
            Toast.makeText(MainActivity.this, "Profile Selected", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.faqs) {
            Toast.makeText(MainActivity.this, "FAQs Selected", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.feedback) {
            Toast.makeText(MainActivity.this, "Feedback Selected", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.logout) {
            Toast.makeText(MainActivity.this, "Logout Selected", Toast.LENGTH_SHORT).show();
        }

        // Close the navigation drawer=
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}









