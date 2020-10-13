package com.github.cc3002.finalreality.model.weapon;

/**
 * A class that holds all the information of a Axe.
 *
 * @author Gustavo Varas Santander
 */
public class Axe extends Weapon{

    /**
     * Creates a Axe with a name, a base damage and weight.
     *
     * @param name
     *       The name of the Axe.
     * @param damage
     *       The damage of the Axe.
     * @param weight
     *       The weight of the Axe.
     */
    public Axe(final String name, final int damage, final int weight) {
        super(name,damage,weight,"Axe");
    }
}

