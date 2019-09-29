package com.usn.clickergame.ui.clicker.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.usn.clickergame.Data;
import com.usn.clickergame.GameState;
import com.usn.clickergame.databinding.ContentClickerBinding;


public class ClickerFragment extends Fragment {
    GameState game ;

    Data model;

    ContentClickerBinding bindingClicker;


    // TODO refactor with data binding
  /*  private TextView counterDisplay ;
    private TextView responseDisplay;
    private TextView clickingStrengthDisplay;
    private TextView comboLengthDisplay;
    private TextView comboMultiplierDisplay;*/
    //private GameState game = new GameState(1);

    // TODO should not be a fab
    // FloatingActionButton fab;


    public ClickerFragment() {

    }

    public static ClickerFragment newInstance(){
        return new ClickerFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        model.mGame.postValue(game);
        Log.d("Frag", "I was killed");

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);


        model = ViewModelProviders.of(getActivity()).get(Data.class);
        game = model.mGame.getValue();



        bindingClicker.setGameState(game);


    }


    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ){


        //ActivityClickerBinding bindingClicker = ActivityClickerBinding.inflate(inflater, container, false);
        bindingClicker = ContentClickerBinding.inflate(inflater, container, false);

        View root = bindingClicker.getRoot();
        bindingClicker.getLifecycleOwner();


        bindingClicker.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                updateCounter();
                Log.d("hi" ,"hi " + game.getCounter() );



            }
        });


        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // TODO refactor with data binding
       /* fab = view.findViewById(R.id.fab);
        counterDisplay = view.findViewById(R.id.counterDisplay);
        responseDisplay = view.findViewById(R.id.responseTextMain);
        clickingStrengthDisplay = view.findViewById(R.id.upgrade1NumberMain);
        comboLengthDisplay = view.findViewById(R.id.upgrade2NumberMain);
        comboMultiplierDisplay = view.findViewById(R.id.upgrade3NumberMain);*/


        //updateUpgrades();


       /* fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Log.d("test" , "" + );
                Log.d("hi" ,"hi " + game.getCounter() );

                updateCounter();

            }
        });*/
    }


    public void updateCounter() {

        int summ = game.getClickMultiplier(); // summens base er hvor mangen poeng du får i et trykk
        game.adjustComboChountDown(-1);// ved og trykke bygger du deg kombo
        //buttonResponse(); //respons blir vist til bruker
        if (game.getComboChountDown() <= 0){ // om nedtellingen til komboen blir 0 så får man kombo bonusen som er en ganging av poengene tjent
            summ = summ * game.getComboStrength();
            game.setComboChountDown(game.getComboLength()); // så startes kombo-nedtellingen igjen
        }
        game.adjustCounter(summ);

        buttonResponse();


        //counterDisplay.setText("Points:" + game.getCounter() );
        //updateUpgrades();

    }


/*
    public void updateUpgrades(){
        clickingStrengthDisplay.setText("" + game.getClickMultiplier());
        comboLengthDisplay.setText("" + game.getComboLength());
        comboMultiplierDisplay.setText("" + game.getComboStrength());
    }*/

    private void buttonResponse(){


        if (game.getComboChountDown() == 0){
            bindingClicker.responseTextMain.setText("you earned " + (game.getComboStrength() * game.getClickMultiplier()) + " extra points!");
        }
        else if(game.getComboChountDown() == 1){
            bindingClicker.responseTextMain.setText("combo in " + game.getComboChountDown() + " click!");
        }
        else{
            bindingClicker.responseTextMain.setText("combo in " + game.getComboChountDown() + " clicks!");
        }

    }

/*    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/

}


