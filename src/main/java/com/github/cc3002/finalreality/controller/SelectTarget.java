package com.github.cc3002.finalreality.controller;

public class SelectTarget extends State {

    @Override
    void playTurn(){
        this.changeState(new InTurn());
    }
    @Override
    void attacking(){
        this.changeState(new WaitingCharacter());
    }

    @Override
    public boolean isSelectingTarget() {
        return true;
    }
}
