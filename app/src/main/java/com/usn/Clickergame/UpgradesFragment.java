package com.usn.Clickergame;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class UpgradesFragment extends Fragment {

    TextView clickStrenghtDisplay;
    TextView comboStrenghtDisplay;
    TextView comboSpeedDisplay;

    Button clickStrenghtButton;
    Button comboStrenghtButton;
    Button comboSpeedButton;

    GameState game2; // temp løsning til vi får sent data

    public UpgradesFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
        game2 = new GameState();
        cheat();

        getUpgrades();
    }


    public void cheat(){
        game2.setComboStrength(4);
        game2.setComboLevel(5);
        game2.setClickMultiplier(7);
    }

    public void getUpgrades(){
        clickStrenghtDisplay.setText("" + game2.getClickMultiplier());
        comboStrenghtDisplay.setText("" + game2.getComboStrength());
        comboSpeedDisplay.setText("" + game2.getComboLevel());

        clickStrenghtButton.setText("" + game2.getClickStrenghtCost());
        comboStrenghtButton.setText("" + game2.getComboStrenghtCost());
        comboSpeedButton.setText("" + game2.getComboStrenghtCost());
    }


}
