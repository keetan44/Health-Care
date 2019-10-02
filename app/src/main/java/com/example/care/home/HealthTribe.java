package com.example.care.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.care.R;
import com.google.android.material.navigation.NavigationView;

public class HealthTribe extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    NavigationView navigationView;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tribe);
        setTitle("Health Tribe");
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().findItem(R.id.third).setCheckable(true).setChecked(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.health_tribe_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        switch (id) {
            case R.id.first:
                startActivity(new Intent(HealthTribe.this, Home.class));
                finish();
                break;

            case R.id.second:
                startActivity(new Intent(HealthTribe.this,HealthJourney.class));
                finish();
                break;

            case R.id.third:
                break;

            case R.id.fourth:
                startActivity(new Intent(HealthTribe.this, MyHealth.class));
                finish();
                break;

            case R.id.fifth:
                startActivity(new Intent(HealthTribe.this, MyDoctors.class));
                finish();
                break;

            case R.id.sixth:
                startActivity(new Intent(HealthTribe.this, Medications.class));
                finish();
                break;

            case R.id.seventh:
                startActivity(new Intent(HealthTribe.this, Claims.class));
                finish();
                break;

            case R.id.eight:
                startActivity(new Intent(HealthTribe.this, Calendar.class));
                finish();
                break;

            case R.id.nine:
                startActivity(new Intent(HealthTribe.this, MyBenefits.class));
                finish();
                break;

            case R.id.ten:
                startActivity(new Intent(HealthTribe.this, Support.class));
                finish();
                break;


            case R.id.eleven:
                startActivity(new Intent(HealthTribe.this, Settings.class));
                finish();
                break;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(HealthTribe.this,Home.class));
        finish();
    }
}
