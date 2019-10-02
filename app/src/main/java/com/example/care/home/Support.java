package com.example.care.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.care.R;
import com.google.android.material.navigation.NavigationView;

public class Support extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    NavigationView navigationView;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mToggle;

    CardView mail,center,chat,call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        setTitle("Support");
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.drawer_open,R.string.drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().findItem(R.id.ten).setCheckable(true).setChecked(true);

        mail = findViewById(R.id.mail);
        center = findViewById(R.id.knowledge);
        chat = findViewById(R.id.chat);
        call = findViewById(R.id.call);

        //Email Us

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Support.this,"Email Us",Toast.LENGTH_SHORT).show();
            }
        });

        //Knowledge Centre

        center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Support.this,"Knowledge Center",Toast.LENGTH_SHORT).show();
            }
        });

        //Live Chat

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Support.this,"Live Chat",Toast.LENGTH_SHORT).show();
            }
        });

        //Schedule a Call

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Support.this,"Schedule a Call",Toast.LENGTH_SHORT).show();
            }
        });





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
                startActivity(new Intent(Support.this,Home.class));
                finish();
                break;

            case R.id.second:  startActivity(new Intent(Support.this,HealthJourney.class));
                finish();
                break;

            case R.id.third: startActivity(new Intent(Support.this,HealthTribe.class));
                finish();
                break;

            case R.id.fourth: startActivity(new Intent(Support.this,MyHealth.class));
                finish();
                break;

            case R.id.fifth : startActivity(new Intent(Support.this,MyDoctors.class));
                finish();
                break;

            case R.id.sixth : startActivity(new Intent(Support.this,Medications.class));
                finish();
                break;

            case R.id.seventh : startActivity(new Intent(Support.this,Claims.class));
                finish();
                break;

            case R.id.eight : startActivity(new Intent(Support.this,Calendar.class));
                finish();
                break;

            case R.id.nine : startActivity(new Intent(Support.this,MyBenefits.class));
                finish();
                break;

            case R.id.ten :
                break;


            case R.id.eleven : startActivity(new Intent(Support.this,Settings.class));
                finish();
                break;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Support.this,Home.class));
        finish();
    }
}
