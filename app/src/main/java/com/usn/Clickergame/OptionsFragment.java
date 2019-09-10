package com.usn.Clickergame;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

public class OptionsFragment extends Fragment {

    GameState game;

    private Data model;

    public OptionsFragment() {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //final Bundle bundle = new Bundle();
        //bundle.putBoolean("test_boolean", true);

       // final NavController navController = Navigation.findNavController(getActivity(), R.id.fragment2);


        final Button button = view.findViewById(R.id.optionsResetButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Button", "Hi from button");
                game.resetGameState();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        model = ViewModelProviders.of(getActivity()).get(Data.class);
        game = model.mGame.getValue();

        return inflater.inflate(R.layout.activity_options, container, false);

    }

}

