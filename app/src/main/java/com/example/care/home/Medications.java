package com.example.care.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SearchView;

import com.example.care.R;
import com.google.android.material.navigation.NavigationView;

public class Medications extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    NavigationView navigationView;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medications);
        setTitle("Medications & Pharmacies");
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.drawer_open,R.string.drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().findItem(R.id.sixth).setCheckable(true).setChecked(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();


        switch (id)
        {
            case R.id.first:
                startActivity(new Intent(Medications.this,Home.class));
                finish();
                break;

            case R.id.second:  startActivity(new Intent(Medications.this,HealthJourney.class));
                finish();
                break;

            case R.id.third: startActivity(new Intent(Medications.this,HealthTribe.class));
                finish();
                break;

            case R.id.fourth: startActivity(new Intent(Medications.this,MyHealth.class));
                finish();
                break;

            case R.id.fifth : startActivity(new Intent(Medications.this,MyDoctors.class));
                finish();
                break;

            case R.id.sixth :
                break;

            case R.id.seventh : startActivity(new Intent(Medications.this,Claims.class));
                finish();
                break;

            case R.id.eight : startActivity(new Intent(Medications.this,Calendar.class));
                finish();
                break;

            case R.id.nine : startActivity(new Intent(Medications.this,MyBenefits.class));
                finish();
                break;

            case R.id.ten : startActivity(new Intent(Medications.this,Support.class));
                finish();
                break;


            case R.id.eleven : startActivity(new Intent(Medications.this,Settings.class));
                finish();
                break;

        }
        return false;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Medications.this,Home.class));
        finish();
    }
}
