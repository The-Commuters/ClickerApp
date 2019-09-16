package com.usn.Clickergame.ui.clicker;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;




public class SharedViewModel extends ViewModel {
    private MutableLiveData<Integer> points = new MutableLiveData<>(0);
    private MutableLiveData<Integer> combo = new MutableLiveData<>(0);

    public LiveData<Integer> getPoints() {
        return points;
    }

    public void addPoints(int addend) {
        points.setValue(points.getValue() + addend);
    }

    public LiveData<Integer> getCombo() {
        return combo;
    }

    public void incrementCombo() {
        combo.setValue(combo.getValue() + 1);
    }
    public void resetCombo(){
        combo.setValue(0);
    }
}
