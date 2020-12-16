package com.github.cc3002.finalreality.controller;

public class WaitingCharacter extends State{

    /**
     * Pass to the character turn
     */
    @Override
    void playTurn(){
        this.changeState(new InTurn());
    }


    @Override
    public boolean isWaiting() {
        return true;
    }
}
