package com.usn.Clickergame;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

public class UpgradesFragment extends Fragment {

    TextView clickStrenghtDisplay;
    TextView comboStrenghtDisplay;
    TextView comboSpeedDisplay;

    Button clickStrenghtButton;
    Button comboStrenghtButton;
    Button comboSpeedButton;



    private Data model;

    GameState game;

    public UpgradesFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        model = ViewModelProviders.of(getActivity()).get(Data.class);
        game = model.mGame.getValue();

        return inflater.inflate(R.layout.activity_upgrades, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        clickStrenghtDisplay = view.findViewById(R.id.clickUpgradeDisplay);
        comboStrenghtDisplay = view.findViewById(R.id.comboModUpgradeDesplay);
        comboSpeedDisplay = view.findViewById(R.id.comboSpeedUpgradeDesplay);

        clickStrenghtButton = view.findViewById(R.id.clickUpgradeButton);
        comboStrenghtButton = view.findViewById(R.id.comboModUpgradeButton);
        comboSpeedButton = view.findViewById(R.id.comboSpeedUpgradeButton);

        // i bruk for testing

        //cheat();

        getUpgrades();
    }


    public void cheat(){
        game.setCounter(500);
        game.setComboStrength(4);
        game.setComboLevel(5);
        game.setClickMultiplier(7);
    }

    public void getUpgrades(){
        clickStrenghtDisplay.setText("" + game.getClickMultiplier());
        comboStrenghtDisplay.setText("" + game.getComboStrength());
        comboSpeedDisplay.setText("" + game.getComboLevel());

        clickStrenghtButton.setText("" + game.getClickStrenghtCost());
        comboStrenghtButton.setText("" + game.getComboStrenghtCost());
        comboSpeedButton.setText("" + game.getComboStrenghtCost());
    }


}
