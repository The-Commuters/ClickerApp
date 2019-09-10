package com.usn.Clickergame;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.usn.Clickergame.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity
/*implements NavigationView.OnNavigationItemSelectedListener*/ {

    GameState game;
    TextView counterDisplay ;
    TextView responseDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


    }



/*
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
*/

}