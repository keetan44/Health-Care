package com.example.care.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.care.R;
import com.google.android.material.navigation.NavigationView;

public class Settings extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    NavigationView navigationView;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mToggle;
    CardView insuranceProviders,healthAssessments,familyHealthHistory,allergies,langugae,subscriptions,payments,security,notifications,logOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setTitle("Settings");
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.drawer_open,R.string.drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().findItem(R.id.eleven).setCheckable(true).setChecked(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu,menu);
        return true;
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
                startActivity(new Intent(Settings.this,Home.class));
                finish();
                break;

            case R.id.second:  startActivity(new Intent(Settings.this,HealthJourney.class));
                finish();
                break;

            case R.id.third: startActivity(new Intent(Settings.this,HealthTribe.class));
                finish();
                break;

            case R.id.fourth: startActivity(new Intent(Settings.this,MyHealth.class));
                finish();
                break;

            case R.id.fifth : startActivity(new Intent(Settings.this,MyDoctors.class));
                finish();
                break;

            case R.id.sixth : startActivity(new Intent(Settings.this,Medications.class));
                finish();
                break;

            case R.id.seventh : startActivity(new Intent(Settings.this,Claims.class));
                finish();
                break;

            case R.id.eight : startActivity(new Intent(Settings.this,Calendar.class));
                finish();
                break;

            case R.id.nine : startActivity(new Intent(Settings.this,MyBenefits.class));
                finish();
                break;

            case R.id.ten : startActivity(new Intent(Settings.this,Support.class));
                finish();
                break;


            case R.id.eleven :
                break;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Settings.this,Home.class));
        finish();
    }



}
