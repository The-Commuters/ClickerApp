package com.usn.clickergame.ui.clicker.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateVMFactory;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.usn.Clickergame.Data;
import com.usn.Clickergame.GameState;
import com.usn.Clickergame.R;


public class ClickerFragment extends Fragment {
    private Data model;

    // TODO refactor with data binding
    private TextView counterDisplay ;
    private TextView responseDisplay;
    private TextView clickingStrengthDisplay;
    private TextView comboLengthDisplay;
    private TextView comboMultiplierDisplay;
    private GameState game;

    // TODO should not be a fab
    FloatingActionButton fab;

    public ClickerFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        model = ViewModelProviders.of(this, new SavedStateVMFactory(this)).get(Data.class);
        //game =  model.getGame().getValue();

       // model.saveGame(game);


       /* model.getGame().observe(this, new Observer<GameState>() {
            @Override
            public void onChanged(GameState gameState) {
                counterDisplay.setText(gameState.getCounter());
            }
        });*/



        /*LiveData<GameState> gamePointsLiveDataListener = new LiveData<GameState>() {
            @Override
            public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super Integer> observer) {
                super.observe(owner, observer);
            }
        };
        gamePointsLiveDataListener.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                counterDisplay.setText(game.getCounter());
            }

          *//*  @Override
                    public void onChanged(GameState game) {

                    }*//*
                }

        );


          /*  @Override
            public void onChanged(int counter) {

               //counterDisplay.setText(game.getCounter());
                Log.d("hi", "I was created");
            }
                */

    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ){
        // david
        //model = ViewModelProviders.of(this).get(Data.class);
        // david



        //game =

        return inflater.inflate(R.layout.activity_clicker, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // TODO refactor with data binding
        fab = view.findViewById(R.id.fab);
        counterDisplay = view.findViewById(R.id.counterDisplay);
        responseDisplay = view.findViewById(R.id.responseTextMain);
        clickingStrengthDisplay = view.findViewById(R.id.upgrade1NumberMain);
        comboLengthDisplay = view.findViewById(R.id.upgrade2NumberMain);
        comboMultiplierDisplay = view.findViewById(R.id.upgrade3NumberMain);

        //updateUpgrades();



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Log.d("hi" ,"hi " + model.getGame() );

                updateCounter();

            }
        });
    }


    public void updateCounter() {
       /* int summ = game.getClickMultiplier(); // summens base er hvor mangen poeng du får i et trykk
        game.adjustComboChountDown(-1);// ved og trykke bygger du deg kombo
        buttonResponse(); //respons blir vist til bruker
        if (game.getComboChountDown() <= 0){ // om nedtellingen til komboen blir 0 så får man kombo bonusen som er en ganging av poengene tjent
            summ = summ * game.getComboStrength();
            game.setComboChountDown(game.getComboLevel()); // så startes kombo-nedtellingen igjen
        }
        game.adjustCounter(summ);*/


        //game.setCounter(1);
        //game.setCounter(2);
        //model.saveGame(game);

       //model.mPoints.setValue(game.getCounter());
        //counterDisplay.setText("Points:" + game.getCounter());
        //updateUpgrades();

    }


/*
    public void updateUpgrades(){
        clickingStrengthDisplay.setText("" + game.getClickMultiplier());
        comboLengthDisplay.setText("" + game.getComboLevel());
        comboMultiplierDisplay.setText("" + game.getComboStrength());
    }*/

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

/*    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/

    }


