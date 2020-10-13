package com.github.cc3002.finalreality.model.weapon;

/**
 * A class that holds all the information of a Staff.
 *
 * @author Gustavo Varas Santander
 */
public class Staff extends Weapon{

    public int magicDamage;

    /**
     * Creates a Staff with a name, a base damage, weight and magic damage.
     *
     * @param name
     *       The name of the Staff.
     * @param damage
     *       The damage of the Staff.
     * @param weight
     *       The weight of the Staff.
     * @param magicDamage
     *       The magic damage of the Staff.
     */
    public Staff(final String name, final int damage, final int weight,int magicDamage) {
        super(name,damage,weight,"Staff");
        this.magicDamage=magicDamage;
    }

    /**
     * Returns the Magic Damage of the Staff.
     */
    @Override
    public int getMagicDamage() {
        return magicDamage;
    }
}
