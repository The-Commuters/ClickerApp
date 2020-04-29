package com.usn.clickergame.ui.options;

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

import com.usn.clickergame.Data;
import com.usn.clickergame.GameState;
import com.usn.clickergame.R;
import com.usn.clickergame.databinding.ContentOptionsBinding;

public class OptionsFragment extends Fragment {

    GameState game;

    private Data model;

    ContentOptionsBinding bindingOptions;

    public OptionsFragment() {

    }

    public static OptionsFragment newInstance(){
        return new OptionsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        model.mGame.setValue(game);
        Log.d("Frag" , "I was killed");

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        model = ViewModelProviders.of(getActivity()).get(Data.class);
        game = model.mGame.getValue();

        bindingOptions.setGameState(game);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //final Bundle bundle = new Bundle();
        //bundle.putBoolean("test_boolean", true);

       // final NavController navController = Navigation.findNavController(getActivity(), R.id.fragment2);


        final Button button = view.findViewById(R.id.optionsResetButton);

        bindingOptions.optionsResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Button", "Hi from button");
                game.resetGameState();

                bindingOptions.setGameState(game);
                model.mGame.postValue(game);

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //model = ViewModelProviders.of(getActivity()).get(Data.class);
        //game = model.getGame().getValue();

        //ActivityClickerBinding bindingClicker = ActivityClickerBinding.inflate(inflater, container, false);
        bindingOptions = ContentOptionsBinding.inflate(inflater, container, false);

        View root = bindingOptions.getRoot();


        return root;

    }

}

