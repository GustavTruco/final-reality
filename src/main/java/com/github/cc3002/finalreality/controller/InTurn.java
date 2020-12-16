package com.github.cc3002.finalreality.controller;

public class InTurn extends State {

    @Override
    void selectTarget(){
        this.changeState(new SelectTarget());
    }
    @Override
    void goToInventory(){
        this.changeState(new Inventory());
    }

    @Override
    public boolean isInTurn() {
        return true;
    }
}
