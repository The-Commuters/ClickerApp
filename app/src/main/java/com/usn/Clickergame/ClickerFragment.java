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

        fab = view.findViewById(R.id.fab);
        counterDisplay = view.findViewById(R.id.counterDisplay);


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
        if (comboChountDown <= 0){ // om nedtellingen til komboen blir 0 så får man kombo bonusen som er en dobling av poengene tjent
            summ = summ * 2;
            comboChountDown = comboLevel; // så startes kombo-nedtellingen igjen
        }
        counter = summ;
        counterDisplay.setText("Points: " + counter);

    }


    // Overrides the onCreateView and inflates the fragment to the size of the screen
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.activity_clicker, container, false);
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    }


