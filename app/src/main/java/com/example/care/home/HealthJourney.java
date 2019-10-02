package com.example.care.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.care.R;
import com.google.android.material.navigation.NavigationView;

public class HealthJourney extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    NavigationView navigationView;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_journey);
        setTitle("Health Journey & Rewards");
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().findItem(R.id.second).setCheckable(true).setChecked(true);
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
                startActivity(new Intent(HealthJourney.this, Home.class));
                finish();
                break;

            case R.id.second:
                break;

            case R.id.third:
                startActivity(new Intent(HealthJourney.this, HealthTribe.class));
                finish();
                break;

            case R.id.fourth:
                startActivity(new Intent(HealthJourney.this, MyHealth.class));
                finish();
                break;

            case R.id.fifth:
                startActivity(new Intent(HealthJourney.this, MyDoctors.class));
                finish();
                break;

            case R.id.sixth:
                startActivity(new Intent(HealthJourney.this, Medications.class));
                finish();
                break;

            case R.id.seventh:
                startActivity(new Intent(HealthJourney.this, Claims.class));
                finish();
                break;

            case R.id.eight:
                startActivity(new Intent(HealthJourney.this, Calendar.class));
                finish();
                break;

            case R.id.nine:
                startActivity(new Intent(HealthJourney.this, MyBenefits.class));
                finish();
                break;

            case R.id.ten:
                startActivity(new Intent(HealthJourney.this, Support.class));
                finish();
                break;


            case R.id.eleven:
                startActivity(new Intent(HealthJourney.this, Settings.class));
                finish();
                break;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(HealthJourney.this,Home.class));
        finish();
    }
}

