package com.github.cc3002.finalreality.controller;

public class InventoryState extends State {

    @Override
    void playTurn(){
        this.changeState(new InTurnState());
    }

    @Override
    public boolean isInInventory() {
        return true;
    }
}
