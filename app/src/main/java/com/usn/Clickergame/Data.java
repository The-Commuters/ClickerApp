package com.usn.Clickergame;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class Data extends ViewModel {
     private MutableLiveData<GameState> mGame = new MutableLiveData<>();
     public LiveData<Integer> mPoints ;

    private static final String NAME_KEY = "game";
    private SavedStateHandle mState;

    public Data(SavedStateHandle savedStateHandle){
         mState = savedStateHandle;
     }


/*

    public LiveData<String> getGame() {

         return mState.getLiveData(NAME_KEY, mGame);

    }

    public void saveGame(GameState gameState){
        mState.set(NAME_KEY, gameState);
    }
    *
 */
}
