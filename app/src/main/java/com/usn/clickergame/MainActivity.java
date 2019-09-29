package com.usn.clickergame;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.SavedStateVMFactory;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;



public class MainActivity extends AppCompatActivity
/*implements NavigationView.OnNavigationItemSelectedListener*/ {

    GameState game;

    private Data model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


        model = ViewModelProviders.of(this).get(com.usn.clickergame.Data.class);

        game = new GameState(1);

        model.mGame.postValue(game);

        //ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


    }

}


/*
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
*/


