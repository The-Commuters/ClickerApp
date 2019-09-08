package com.usn.Clickergame;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.fragment.app.Fragment;


public class ClickerFragment extends Fragment {

    // Creates a ClickerFragment Constructor
    public ClickerFragment() {

    }


    // Overrides the onCreateView and inflates the fragment to the size of the screen
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_clicker, container, false);
    }



    }


