package com.example.care.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.care.HeightWrappingViewPager;
import com.example.care.R;
import com.example.care.home.Fragments.FragmentClinicalSummary;
import com.example.care.home.Fragments.FragmentConnectedHealth;
import com.example.care.home.Fragments.FragmentHealthTimeline;
import com.example.care.home.Fragments.FragmentLabs;
import com.example.care.home.Fragments.ViewPageAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MyHealth extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mToggle;

    private TabLayout tabLayout;
    private HeightWrappingViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_health);
        setTitle("My Health");
        mDrawerLayout =findViewById(R.id.drawer_layout);
        tabLayout = findViewById(R.id.tablayout);

        viewPager = findViewById(R.id.view_pager);
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager());
        viewPageAdapter.AddFragment(new FragmentClinicalSummary(),"Clinical Summary");
        viewPageAdapter.AddFragment(new FragmentConnectedHealth(),"Connected Health");
        viewPageAdapter.AddFragment(new FragmentHealthTimeline(),"Health Timeline");
        viewPageAdapter.AddFragment(new FragmentLabs(),"Labs");

        viewPager.setAdapter(viewPageAdapter);
        tabLayout.setupWithViewPager(viewPager);


        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.drawer_open,R.string.drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView =  findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().findItem(R.id.fourth).setCheckable(true).setChecked(true);
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
                startActivity(new Intent(MyHealth.this,Home.class));
                finish();
                break;

            case R.id.second:  startActivity(new Intent(MyHealth.this,HealthJourney.class));
                finish();
                break;

            case R.id.third: startActivity(new Intent(MyHealth.this,HealthTribe.class));
                finish();
                break;

            case R.id.fourth:
                break;

            case R.id.fifth : startActivity(new Intent(MyHealth.this,MyDoctors.class));
                finish();
                break;

            case R.id.sixth : startActivity(new Intent(MyHealth.this,Medications.class));
                finish();
                break;

            case R.id.seventh : startActivity(new Intent(MyHealth.this,Claims.class));
                finish();
                break;

            case R.id.eight : startActivity(new Intent(MyHealth.this,Calendar.class));
                finish();
                break;

            case R.id.nine : startActivity(new Intent(MyHealth.this,MyBenefits.class));
                finish();
                break;

            case R.id.ten : startActivity(new Intent(MyHealth.this,Support.class));
                finish();
                break;


            case R.id.eleven : startActivity(new Intent(MyHealth.this,Settings.class));
                finish();
                break;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(MyHealth.this,Home.class));
        finish();
    }
}
