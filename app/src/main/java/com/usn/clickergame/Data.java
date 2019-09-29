package com.usn.clickergame;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Data extends ViewModel {
    public MutableLiveData<GameState> mGame = new MutableLiveData<>();

    public LiveData<Integer> mPoints ;

   /* private static final String NAME_KEY = "game";
    private SavedStateHandle mState;*/

  /*  public Data(SavedStateHandle savedStateHandle){
         mState = savedStateHandle;
     }

*/

 /* public Data(GameState gameState){
     this.mGame.setValue(gameState);


  }*/

    public LiveData<GameState> getGame() {

        return mGame;

    }

   /* public void saveGame(GameState gameState){
        mState.set(NAME_KEY, gameState);
    }*/
    }
}
