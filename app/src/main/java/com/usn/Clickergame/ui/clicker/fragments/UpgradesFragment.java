package com.usn.Clickergame.ui.clicker.fragments;

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

import com.usn.Clickergame.Data;
import com.usn.Clickergame.GameState;
import com.usn.Clickergame.R;
import com.usn.Clickergame.ui.clicker.SharedViewModel;

public class UpgradesFragment extends Fragment {

    // david
    private SharedViewModel modela;
    // david

    // TODO refactor with data binding
    TextView clickStrenghtDisplay;
    TextView comboStrenghtDisplay;
    TextView comboSpeedDisplay;
    TextView pointsDisplay;

    Button clickStrenghtButton;
    Button comboStrenghtButton;
    Button comboSpeedButton;

//counterDisplayUpgrades bruke onRestart()

    private Data model;

    GameState game;

    public UpgradesFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        model = ViewModelProviders.of(getActivity()).get(Data.class);
        game = model.mGame.getValue();
        return inflater.inflate(R.layout.activity_upgrades, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        clickStrenghtDisplay = view.findViewById(R.id.clickUpgradeDisplay);
        comboStrenghtDisplay = view.findViewById(R.id.comboModUpgradeDesplay);
        comboSpeedDisplay = view.findViewById(R.id.comboSpeedUpgradeDesplay);
        pointsDisplay = view.findViewById(R.id.counterDisplayUpgrades);

        clickStrenghtButton = view.findViewById(R.id.clickUpgradeButton);
        comboStrenghtButton = view.findViewById(R.id.comboModUpgradeButton);
        comboSpeedButton = view.findViewById(R.id.comboSpeedUpgradeButton);

        clickStrenghtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (game.getCounter() < game.getClickStrenghtCost()){
                    //
                }
                else{
                    game.adjustCounter(-(game.getClickStrenghtCost()));
                    game.adjustClickMultiplier(1);
                }
                getUpgrades();
            }
        });

        comboStrenghtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (game.getCounter() < game.getComboStrenghtCost()){
                    //
                }
                else{
                    game.adjustCounter(-(game.getComboStrenghtCost()));
                    game.adjustComboStrenght(1);
                }
                getUpgrades();
            }
        });

        comboSpeedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (game.getCounter() < game.getComboSpeedCost()){
                    //
                }
                else{
                    game.adjustCounter(-(game.getComboSpeedCost()));
                    game.adjustComboLevel(-1);
                }

                getUpgrades();
            }
        });

        getUpgrades();
    }

    /*
    * to do list:
    * ikke la knapper bli trykket på når du ikke har råd til oppgraderinger eller grå dem ut
    * vis mengen poeng tilbake i oppgradingsmenyen og trekk fra den live
    * oppdater viste oppgraderinger når spilleren returnerer til ClickerFragment
    * sørge for at flipping virker
    * om vi ikke får lagra data mellom flips får det bare være
    * */

    public void getUpgrades(){
        clickStrenghtDisplay.setText("" + game.getClickMultiplier());
        comboStrenghtDisplay.setText("" + game.getComboStrength());
        comboSpeedDisplay.setText("" + game.getComboLevel());
        pointsDisplay.setText("Points: " + game.getCounter());

        clickStrenghtButton.setText("" + game.getClickStrenghtCost());
        comboStrenghtButton.setText("" + game.getComboStrenghtCost());
        comboSpeedButton.setText("" + game.getComboSpeedCost());
    }
}
