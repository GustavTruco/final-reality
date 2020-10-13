package com.github.cc3002.finalreality.model.weapon;

/**
 * A class that holds all the information of a Sword.
 *
 * @author Gustavo Varas Santander
 */
public class Sword extends Weapon{

    /**
     * Creates a Sword with a name, a base damage and weight.
     *
     * @param name
     *       The name of the Sword.
     * @param damage
     *       The damage of the Sword.
     * @param weight
     *       The weight of the Sword.
     */
    public Sword(final String name, final int damage, final int weight) {
        super(name,damage,weight,"Sword");
    }
}
