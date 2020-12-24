package com.github.cc3002.finalreality.controller;

public class SelectTargetState extends State {

    @Override
    void playTurn(){
        this.changeState(new InTurnState());
    }
    @Override
    void attacking(){
        this.changeState(new WaitingCharacterState());
    }

    @Override
    public boolean isSelectingTarget() {
        return true;
    }
}
