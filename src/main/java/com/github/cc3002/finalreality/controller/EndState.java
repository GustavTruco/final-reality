package com.github.cc3002.finalreality.controller;

public class EndState extends State{
    @Override
    void replay(){this.changeState(new ConfigState());}

    @Override
    public boolean isEnd(){return true;}
}