package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.character.player.Knight;

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

    /**
     * Equips Axes to Knight class players.
     * Sets the attack of the character to the Axe damage
     * @param player
     *        The player's Character that will be eventually equipped.
     * @return this
     *        Returns this weapon.
     */
    @Override
    public Weapon equipToKnight(Knight player) {
        player.setAttack(this.getDamage());
        return this;
    }

    /**
     * Equips Axes to Engineer class players.
     * Sets the attack of the character to the Axe damage
     * @param player
     *        The player's Character that will be eventually equipped.
     * @return this
     *        Returns this weapon.
     */
    @Override
    public Weapon equipToEngineer(Engineer player) {
        player.setAttack(this.getDamage());
        return this;
    }
}

