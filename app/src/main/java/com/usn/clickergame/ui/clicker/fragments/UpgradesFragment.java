package com.usn.clickergame.ui.clicker.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.usn.clickergame.Data;
import com.usn.clickergame.GameState;
import com.usn.clickergame.databinding.ContentUpgradesBinding;

public class UpgradesFragment extends Fragment {

    // david
    /*private SharedViewModel modela;
    // david

    // TODO refactor with data binding
    TextView clickStrenghtDisplay;
    TextView comboStrenghtDisplay;
    TextView comboSpeedDisplay;
    TextView pointsDisplay;

    Button clickStrenghtButton;
    Button comboStrenghtButton;
    Button comboSpeedButton;*/

    //counterDisplayUpgrades bruke onRestart()
    Data model;

    GameState game;

    ContentUpgradesBinding bindingUpgrades;

    public static UpgradesFragment newInstance(){
        return new UpgradesFragment();
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

        bindingUpgrades.setGameState(game);

    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {


        bindingUpgrades = ContentUpgradesBinding.inflate(inflater, container, false);

        View root = bindingUpgrades.getRoot();




        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       /* clickStrenghtDisplay = view.findViewById(R.id.clickUpgradeDisplay);
        comboStrenghtDisplay = view.findViewById(R.id.comboModUpgradeDesplay);
        comboSpeedDisplay = view.findViewById(R.id.comboSpeedUpgradeDesplay);
        pointsDisplay = view.findViewById(R.id.counterDisplayUpgrades);

        clickStrenghtButton = view.findViewById(R.id.clickUpgradeButton);
        comboStrenghtButton = view.findViewById(R.id.comboModUpgradeButton);
        comboSpeedButton = view.findViewById(R.id.comboSpeedUpgradeButton);



        */
        bindingUpgrades.clickUpgradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (game.getCounter() < game.getClickStrenghtCost()){
                    //
                }
                else{
                    game.adjustCounter(-(game.getClickStrenghtCost()));
                    game.adjustClickMultiplier(1);
                }
                //getUpgrades();
            }
        });

        bindingUpgrades.comboModUpgradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (game.getCounter() < game.getComboStrenghtCost()){
                    //
                }
                else{
                    game.adjustCounter(-(game.getComboStrenghtCost()));
                    game.adjustComboStrenght(1);
                }
                //getUpgrades();
            }
        });

        bindingUpgrades.comboSpeedUpgradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (game.getCounter() < game.getComboSpeedCost()){
                    //
                }
                else{
                    game.adjustCounter(-(game.getComboSpeedCost()));
                    game.adjustComboLevel(-1);
                }

                //getUpgrades();
            }
        });

        //getUpgrades();
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


        bindingUpgrades.clickUpgradeButton.setText("" + game.getClickStrenghtCost());
        bindingUpgrades.comboModUpgradeButton.setText("" + game.getComboStrenghtCost());
        bindingUpgrades.comboSpeedUpgradeButton.setText("" + game.getComboSpeedCost());
    }

}



