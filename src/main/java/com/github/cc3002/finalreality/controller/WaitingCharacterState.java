package com.github.cc3002.finalreality.controller;

public class WaitingCharacterState extends State{

    /**
     * Pass to the character turn
     */
    @Override
    void playTurn(){
        this.changeState(new InTurnState());
    }

    @Override
    void ended(){
        this.changeState(new EndState());
    }

    @Override
    public boolean isWaiting() {
        return true;
    }
}
