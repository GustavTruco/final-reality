package com.github.cc3002.finalreality.controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TurnInitHandler  implements PropertyChangeListener {

    private final Controller controller;

    public TurnInitHandler(Controller c) {
        controller=c;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt){
        if (evt.getPropertyName() =="InLine" && controller.getActiveCharacter()==null){
            try {
                controller.setActiveCharacter();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
