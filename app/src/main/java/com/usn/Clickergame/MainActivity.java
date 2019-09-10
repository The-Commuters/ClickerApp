package com.usn.Clickergame;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.usn.Clickergame.ui.main.SectionsPagerAdapter;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

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

        game = new GameState();

        FloatingActionButton fab = findViewById(R.id.fab);
        counterDisplay = findViewById(R.id.counterDisplay);
        responseDisplay = findViewById(R.id.responseTextMain);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateCounter();

            }
        });


    }

    public void updateCounter() {
        int summ = game.getClickMultiplier(); // summens base er hvor mangen poeng du får i et trykk
        game.adjustComboChountDown(-1);// ved og trykke bygger du deg kombo
        buttonResponse(); //respons blir vist til bruker
        if (game.getComboChountDown() <= 0){ // om nedtellingen til komboen blir 0 så får man kombo bonusen som er en ganging av poengene tjent
            summ = summ * game.getComboStrength();
            game.setComboChountDown(game.getComboLevel()); // så startes kombo-nedtellingen igjen
        }
        game.adjustCounter(summ);
        counterDisplay.setText("Points: " + game.getCounter());
        //tellMe();

    }

    public void updateUpgrades(){

    }

    private void buttonResponse(){


        if (game.getComboChountDown() == 0){
            responseDisplay.setText("you earned " + (game.getComboStrength() * game.getClickMultiplier()) + " extra points!");
        }
        else if(game.getComboChountDown() == 1){
            responseDisplay.setText("combo in " + game.getComboChountDown() + " click!");
        }
        else{
            responseDisplay.setText("combo in " + game.getComboChountDown() + " clicks!");
        }

    }

/*
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
*/

}