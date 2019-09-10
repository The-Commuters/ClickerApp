package com.usn.Clickergame;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ClickerFragment extends Fragment {

    TextView counterDisplay ;
    TextView responseDisplay;

    GameState game;

    final static int COMBO_BASE = 10;
    final static int COMBO_MINIMUM = 3;
    final static int MULTIPLIER_BASE = 1;
    final static int MULTIPLIER_MAXIMUM = 10;

    // variabler som faktis blir brukt
    int counter = 0;
    int clickMultiplier = 1;
    int comboChountDown = COMBO_BASE;
    int comboLevel = MULTIPLIER_MAXIMUM;
    FloatingActionButton fab;

    //private fragment1.OnFragmentInteractionListener mListener;


    // Creates a ClickerFragment Constructor
    public ClickerFragment() {

    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        game = new GameState();

        fab = view.findViewById(R.id.fab);
        counterDisplay = view.findViewById(R.id.counterDisplay);
        responseDisplay = view.findViewById(R.id.responseTextMain);


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


    // Overrides the onCreateView and inflates the fragment to the size of the screen
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.activity_clicker, container, false);
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    }


