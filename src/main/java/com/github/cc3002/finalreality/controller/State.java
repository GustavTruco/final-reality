package com.github.cc3002.finalreality.controller;

public class State {
    protected Controller controller;

    public void setController(Controller aController){
        this.controller=aController;
    }
    protected void changeState(State aState){
        controller.setState(aState);
    }

    void error(){
        throw new AssertionError("Wrong State");
    }

    void playTurn(){
        error();
    }

    void selectTarget(){
        error();
    }

    void goToInventory(){
        error();
    }

    void attacking(){
        error();
    }


    public boolean isWaiting(){return false;}
    public boolean isInTurn(){return false;}
    public boolean isSelectingTarget(){return false;}
    public boolean isInInventory(){return false;}
}
