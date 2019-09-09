package com.usn.Clickergame;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView counterDisplay ;
    TextView responseDisplay;

    final static int COMBO_BASE = 10;
    final static int COMBO_MINIMUM = 3;
    final static int COMBO_POWER_BASE = 2;
    final static int MULTIPLIER_BASE = 1;
    final static int MULTIPLIER_MAXIMUM = 10;

    // variabler som faktis blir brukt
    int counter;
    int clickMultiplier;
    int comboChountDown;
    int comboLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //toolbar.collapseActionView();

        counter = 0;
        clickMultiplier = MULTIPLIER_BASE;
        comboChountDown = COMBO_BASE;
        comboLevel = MULTIPLIER_MAXIMUM;



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
        int summ = clickMultiplier; // summens base er hvor mangen poeng du får i et trykk
        comboChountDown--; // ved og trykke bygger du deg kombo
        buttonResponse(); //respons blir vist til bruker
        if (comboChountDown <= 0){ // om nedtellingen til komboen blir 0 så får man kombo bonusen som er en dobling av poengene tjent
            summ = summ * 2;
            comboChountDown = comboLevel; // så startes kombo-nedtellingen igjen
        }
        counter = counter + summ;
        counterDisplay.setText("Points: " + counter);
        //tellMe();

    }

    private void buttonResponse(){


        if (comboChountDown == 0){
            responseDisplay.setText("combo in " + comboLevel + " clicks!");
        }
        else if(comboChountDown == 1){
            responseDisplay.setText("combo in " + comboChountDown + " click!");
        }
        else{
            responseDisplay.setText("combo in " + comboChountDown + " clicks!");
        }

    }

    //metode til testing
    private void tellMe(){
        System.out.println("||||||||||||||||||" +
                "\ncombo chountdown" + comboChountDown +
                "\nPoints: " + counter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
