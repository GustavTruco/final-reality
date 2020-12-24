package com.github.cc3002.finalreality.controller;

public class ConfigState extends State{
    @Override
    void startGame(){this.changeState(new WaitingCharacterState());}


    @Override
    public boolean isConfig(){return true;}
}
