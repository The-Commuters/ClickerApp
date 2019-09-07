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

    final static int COMBO_BASE = 10;
    final static int COMBO_MINIMUM = 3;
    final static int MULTIPLIER_BASE = 1;
    final static int MULTIPLIER_MAXIMUM = 10;

    // default verdier
    int counter = 0;
    int clickMultiplier = 1;
    int comboChountDown = COMBO_BASE;
    int comboLevel = MULTIPLIER_MAXIMUM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //toolbar.collapseActionView();



        FloatingActionButton fab = findViewById(R.id.fab);
        counterDisplay = findViewById(R.id.counterDisplay);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateCounter();

            }
        });
    }

    public void updateCounter() {

        counter = counter + clickMultiplier;
        counterDisplay.setText("Points: " + counter);

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
