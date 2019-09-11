package com.usn.Clickergame.ui.clicker;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class SharedViewModel extends ViewModel {
    private MutableLiveData<Integer> points;
    private MutableLiveData<Integer> combo;

    public MutableLiveData<Integer> getPoints() {
        if (points == null) {
            points = new MutableLiveData<>();
        }
        return points;
    }

    public MutableLiveData<Integer> getCombo() {
        if (combo == null) {
            combo = new MutableLiveData<>();
        }
        return combo;
    }
}
