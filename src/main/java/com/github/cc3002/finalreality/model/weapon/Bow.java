package com.github.cc3002.finalreality.model.weapon;

/**
 * A class that holds all the information of a Bow.
 *
 * @author Gustavo Varas Santander
 */
public class Bow extends Weapon{
    /**
     * Creates a Bow with a name, a base damage and weight.
     *
     * @param name
     *       The name of the Bow.
     * @param damage
     *       The damage of the Bow.
     * @param weight
     *       The weight of the Bow.
     */
    public Bow(final String name, final int damage, final int weight) {
        super(name,damage,weight,"Bow");
    }
}
