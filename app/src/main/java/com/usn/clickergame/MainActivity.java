package com.usn.clickergame;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;



public class MainActivity extends AppCompatActivity
/*implements NavigationView.OnNavigationItemSelectedListener*/ {

    GameState game;

    private Data model;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        model = ViewModelProviders.of(this).get(com.usn.clickergame.Data.class);

        game = new GameState(1);

        model.mGame.postValue(game);

        game.setCounter(sharedPreferences.getInt("counter", 1));
        game.setComboStrength(sharedPreferences.getInt("strength", 1));
        game.setComboLevel(sharedPreferences.getInt("length", 1));
        game.setClickMultiplier(sharedPreferences.getInt("click", 1));

        //ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


    }

    @Override
    protected void onPause() {
        super.onPause();
        sharedPreferences.edit().putInt("counter", game.getCounter()).apply();
        sharedPreferences.edit().putInt("strength", game.getComboStrength()).apply();
        sharedPreferences.edit().putInt("length", game.getComboLength()).apply();
        sharedPreferences.edit().putInt("click", game.getClickMultiplier()).apply();

    }

}


/*
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
*/


