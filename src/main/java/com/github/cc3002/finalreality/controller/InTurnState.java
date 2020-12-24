package com.github.cc3002.finalreality.controller;

public class InTurnState extends State {

    @Override
    void selectTarget(){
        this.changeState(new SelectTargetState());
    }

    @Override
    void goToInventory(){
        this.changeState(new InventoryState());
    }


    @Override
    public boolean isInTurn() {
        return true;
    }
}
