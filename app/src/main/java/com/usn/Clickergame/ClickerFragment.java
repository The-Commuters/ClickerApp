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
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ClickerFragment extends Fragment {

    TextView counterDisplay ;
    TextView responseDisplay;
    TextView clickingStrengthDisplay;
    TextView comboLengthDisplay;
    TextView comboMultiplierDisplay;

    GameState game;

    private Data model;


    FloatingActionButton fab;

    //private fragment1.OnFragmentInteractionListener mListener;


    // Creates a ClickerFragment Constructor
    public ClickerFragment() {

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        fab = view.findViewById(R.id.fab);
        counterDisplay = view.findViewById(R.id.counterDisplay);
        responseDisplay = view.findViewById(R.id.responseTextMain);
        clickingStrengthDisplay = view.findViewById(R.id.upgrade1NumberMain);
        comboLengthDisplay = view.findViewById(R.id.upgrade2NumberMain);
        comboMultiplierDisplay = view.findViewById(R.id.upgrade3NumberMain);

        updateUpgrades();


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateCounter();

            }
        });
    }

    /*
    @Override
    public void onResume() {
        super.onResume();
        buttonResponse();
        updateUpgrades();
        counterDisplay.setText("Points: " + game.getCounter());
    }

     */

//    @Override
//    public void onResume(){
//        super.onResume();
//        game = model.mGame.getValue();
//        counterDisplay.setText("hii");
//    }





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
        updateUpgrades();

    }


    // Overrides the onCreateView and inflates the fragment to the size of the screen
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         model = ViewModelProviders.of(getActivity()).get(Data.class);
         game = model.mGame.getValue();

        return inflater.inflate(R.layout.activity_clicker, container, false);
    }

    public void updateUpgrades(){
        clickingStrengthDisplay.setText("" + game.getClickMultiplier());
        comboLengthDisplay.setText("" + game.getComboLevel());
        comboMultiplierDisplay.setText("" + game.getComboStrength());
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


