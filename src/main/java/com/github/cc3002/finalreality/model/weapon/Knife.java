package com.github.cc3002.finalreality.model.weapon;

/**
 * A class that holds all the information of a Knife.
 *
 * @author Gustavo Varas Santander
 */
public class Knife extends Weapon{

    /**
     * Creates a Knife with a name, a base damage and weight.
     *
     * @param name
     *       The name of the Knife.
     * @param damage
     *       The damage of the Knife.
     * @param weight
     *       The weight of the Knife.
     */
    public Knife(final String name, final int damage, final int weight) {
        super(name,damage,weight,"Knife");
    }
}
