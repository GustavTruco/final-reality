package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.model.character.Enemy;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EnemyDeathHandler implements PropertyChangeListener {
    private final Controller controller;


    public EnemyDeathHandler(Controller c) {
        controller=c;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt){
        if ((int) evt.getNewValue()==0){
            controller.enemyDied();
        }

    }
}
