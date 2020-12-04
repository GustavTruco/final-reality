package com.github.cc3002.finalreality.model.weapon;

/**
 * An abstract class that holds the common behaviour of all the weapons in the game.
 *
 * @author Gustavo Varas Santander
 */
public abstract class AbstractWeapon implements IWeapon{
    private final String name;
    private final int damage;
    private final int weight;
    private final String type;


    public AbstractWeapon(final String name, final int damage, final int weight,
                  final String type) {
        this.name = name;
        this.damage = damage;
        this.weight = weight;
        this.type = type;
    }


    /**
     * Returns the Name of the Weapon.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the Damage of the Weapon.
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Returns the Weight of the Weapon.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Returns the Type of the Weapon.
     */
    public String getType() {
        return type;
    }

    /**
     * Returns 0 as the default value of Magic Damage.
     */
    public int getMagicDamage(){return 0;}

}
