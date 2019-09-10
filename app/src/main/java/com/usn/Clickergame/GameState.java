package com.usn.Clickergame;

public class GameState {

    // kombo-variabler
    final static int COMBO_BASE = 10; //komboen starter høgt og teller nedover, derfor er der ingen bruk for en maximum bare en minimum
    final static int COMBO_MINIMUM = 3; // hvor lavt komboen får lov til og nå
    final static int COMBO_STRENGTH_BASE = 2; // tallet man ganger med når en kombo forekommer

    // clicking variabeler
    final static int CLICK_STRENTH_BASE = 1; // hvor mangen poeng som blir tjent per click
    final static int CLICK_STRENTH_MAXIMUM = 10; // maximumen til den over
    final static int COUNTER_MINIMUM = 0;

    // kostnads-variabler
    final static int CLICK_STRENTH_COST_BASE = 10;
    final static int COMBO_STRENGTH_COST_BASE = 80;
    final static int COMBO_SPEED_COST_BASE = 200;

    final static double CLICK_STRENTH_GROWTH_RATE = 1.2;
    final static double COMBO_STRENGTH_GROWTH_RATE = 0.5;
    final static double COMBO_SPEED_GROWTH_RATE = 0.3;

    // verdier som skal brukes på tvers av appen
    private int counter = COUNTER_MINIMUM;
    private int clickMultiplier = CLICK_STRENTH_BASE;

    private int comboChountDown = COMBO_BASE;
    private int comboLevel = CLICK_STRENTH_MAXIMUM;
    private int comboStrength = COMBO_STRENGTH_BASE;

    public void resetGameState(){
        counter = COUNTER_MINIMUM;
        clickMultiplier = CLICK_STRENTH_BASE;

        comboChountDown = COMBO_BASE;
        comboLevel = CLICK_STRENTH_MAXIMUM;
        comboStrength = COMBO_STRENGTH_BASE;
    }

    public int getCounter() {
        return counter;
    }

    public int getClickMultiplier() {
        return clickMultiplier;
    }

    public int getComboChountDown() {
        return comboChountDown;
    }

    public int getComboLevel() {
        return comboLevel;
    }

    public int getComboStrength() {
        return comboStrength;
    }

    public void setComboStrength(int comboStrength) {
        this.comboStrength = comboStrength;
    }

    public boolean setCounter(int counter) {

        if (counter >= 1000000000){ // hindrer overtredning av int sin grense
            return false;
        }
        this.counter = counter;
        return true;
    }

    public boolean adjustCounter(int adjustment){
        return setCounter(counter + adjustment);
    }

    public void adjustComboStrenght(int adjustment){
        setComboStrength((comboStrength + adjustment));
    }

    public boolean setClickMultiplier(int clickMultiplier) {

        if (clickMultiplier >= CLICK_STRENTH_MAXIMUM){
            return false;
        }
        this.clickMultiplier = clickMultiplier;
        return true;
    }

    public boolean adjustClickMultiplier(int adjustment){
        return setClickMultiplier(clickMultiplier + adjustment);
    }

    public void setComboChountDown(int comboChountDown) {
        this.comboChountDown = comboChountDown;
    }

    public void adjustComboChountDown(int adjustment){
        setComboChountDown(comboChountDown + adjustment);
    }

    public boolean setComboLevel(int comboLevel) {
        if ((comboLevel >= COMBO_BASE) || (comboLevel <= COMBO_MINIMUM)){
            return false;
        }
        this.comboLevel = comboLevel;
        return true;
    }

    public boolean adjustComboLevel(int adjustment){
        return setComboLevel(comboLevel + adjustment);
    }

    public int getClickStrenghtCost(){
        return (int)(CLICK_STRENTH_COST_BASE * (CLICK_STRENTH_GROWTH_RATE * clickMultiplier));
    }

    public int getComboStrenghtCost(){
        return (int)(COMBO_STRENGTH_COST_BASE * (COMBO_STRENGTH_GROWTH_RATE * comboStrength));
    }

    public int getComboSpeedCost(){
        double revertedValue = COMBO_BASE - comboChountDown +1; // comboen teller nedover isteden for oppover så trekk det nåværende nivå fra det egentlige +1 og du har dens nåværende "level"
        return (int)(COMBO_SPEED_COST_BASE * (COMBO_SPEED_GROWTH_RATE * revertedValue));
    }


}
