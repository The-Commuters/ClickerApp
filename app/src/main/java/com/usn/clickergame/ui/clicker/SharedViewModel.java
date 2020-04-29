package com.usn.clickergame.ui.clicker;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;




public class SharedViewModel extends ViewModel {
    private MutableLiveData<Integer> points;
    private MutableLiveData<Integer> combo;

    public LiveData<Integer> getPoints() {
        if (points == null) {
            points = new MutableLiveData<>(0);
        }
        return points;
    }
    public LiveData<Integer> getCombo() {
        if (combo == null) {
            combo = new MutableLiveData<>(0);
        }
        return combo;
    }
}
