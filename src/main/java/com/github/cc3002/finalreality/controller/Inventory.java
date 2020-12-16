package com.github.cc3002.finalreality.controller;

public class Inventory extends State {

    @Override
    void playTurn(){
        this.changeState(new InTurn());
    }

    @Override
    public boolean isInInventory() {
        return true;
    }
}
