package com.usn.clickergame;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;


public class GameState extends BaseObservable {


    // kombo-konstanter
    final static int COMBO_BASE = 10; //komboen starter høgt og teller nedover, derfor er der ingen bruk for en maximum bare en minimum
    final static int COMBO_MINIMUM = 3; // hvor lavt komboen får lov til og nå
    final static int COMBO_STRENGTH_BASE = 2; // tallet man ganger med når en kombo forekommer

    // clicking konstanter
    final static int CLICK_STRENTH_BASE = 1; // hvor mangen poeng som blir tjent per click
    final static int CLICK_STRENTH_MAXIMUM = 20; // maximumen til den over
    final static int COUNTER_MINIMUM = 0;

    // kostnads-variabler
    final static int CLICK_STRENTH_COST_BASE = 10;
    final static int COMBO_STRENGTH_COST_BASE = 80;
    final static int COMBO_SPEED_COST_BASE = 200;

    // konstanter til og regne ut kosnaden til oppgraderinger
    final static double CLICK_STRENTH_GROWTH_RATE = 1.2;
    final static double COMBO_STRENGTH_GROWTH_RATE = 0.5;
    final static double COMBO_SPEED_GROWTH_RATE = 0.3;

    // verdier som skal brukes på tvers av appen

    int counter = COUNTER_MINIMUM;
    private int clickMultiplier = CLICK_STRENTH_BASE;

    private int comboChountDown = COMBO_BASE;
    private int comboLength = COMBO_BASE;
    private int comboStrength = COMBO_STRENGTH_BASE;

    public GameState(int counter) {

        this.counter = counter;
    }

    public void resetGameState(){
        counter = COUNTER_MINIMUM;
        clickMultiplier = CLICK_STRENTH_BASE;

        comboChountDown = COMBO_BASE;
        comboLength = CLICK_STRENTH_MAXIMUM;
        comboStrength = COMBO_STRENGTH_BASE;
    }

    @Bindable
    public int getCounter() {
        return counter;
    }

    @Bindable
    public int getClickMultiplier() {
        return clickMultiplier;
    }

    @Bindable
    public int getComboChountDown() {
        return comboChountDown;
    }

    @Bindable
    public int getComboLength() {
        return comboLength;
    }

    @Bindable
    public int getComboStrength() {
        return comboStrength;
    }


    public void setComboStrength(int comboStrength) {

        this.comboStrength = comboStrength;
        notifyPropertyChanged(BR.comboStrength);
    }


    public boolean setCounter(int counter) {

        if (counter >= 1000000000){ // hindrer overtredning av int sin grense
            return false;


        }
        this.counter = counter;
        notifyPropertyChanged(BR.counter);

        return true;
    }

    public boolean adjustCounter(int adjustment){
        return setCounter(counter + adjustment);
    }

    public void adjustComboStrenght(int adjustment){
        setComboStrength((comboStrength + adjustment));
    }

    public boolean setClickMultiplier(int clickMultiplier) {

        if (clickMultiplier > CLICK_STRENTH_MAXIMUM){
            return false;
        }
        this.clickMultiplier = clickMultiplier;
        notifyPropertyChanged(BR.clickMultiplier);

        return true;
    }

    public boolean adjustClickMultiplier(int adjustment){
        return setClickMultiplier(clickMultiplier + adjustment);
    }

    public void setComboChountDown(int comboChountDown) {
        notifyPropertyChanged(BR.comboChountDown);

        this.comboChountDown = comboChountDown;
    }

    public void adjustComboChountDown(int adjustment){
        setComboChountDown(comboChountDown + adjustment);
    }

    public boolean setComboLevel(int comboLevel) {
        if ((comboLevel >= COMBO_BASE) || (comboLevel <= COMBO_MINIMUM)){
            return false;
        }
        this.comboLength = comboLevel;
        notifyPropertyChanged(BR.comboLength);

        return true;
    }

    public boolean adjustComboLevel(int adjustment){
        return setComboLevel(comboLength + adjustment);
    }




    @Bindable
    public int getClickStrenghtCost(){
        notifyPropertyChanged(BR.clickStrenghtCost);

        return (int)(CLICK_STRENTH_COST_BASE * (CLICK_STRENTH_GROWTH_RATE * clickMultiplier));
    }


    @Bindable
    public int getComboStrenghtCost(){
        notifyPropertyChanged(BR.comboStrenghtCost);
        return (int)(COMBO_STRENGTH_COST_BASE * (COMBO_STRENGTH_GROWTH_RATE * comboStrength));
    }

    @Bindable
    public int getComboSpeedCost(){
        notifyPropertyChanged(BR.comboSpeedCost);
        double revertedValue = COMBO_BASE - comboLength +1; // comboen teller nedover isteden for oppover så trekk det nåværende nivå fra det egentlige +1 og du har dens nåværende "level"

        return (int)(COMBO_SPEED_COST_BASE * (COMBO_SPEED_GROWTH_RATE * revertedValue));
    }


}
