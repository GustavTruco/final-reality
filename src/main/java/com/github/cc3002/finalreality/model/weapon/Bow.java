package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.character.player.Thief;

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

    /**
     * Equips Bows to Engineer class players.
     * Sets the attack of the character to the Bow damage
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

    /**
     * Equips Bows to Thief class players.
     * Sets the attack of the character to the Bow damage
     * @param player
     *        The player's Character that will be eventually equipped.
     * @return this
     *        Returns this weapon.
     */
    @Override
    public Weapon equipToThief(Thief player) {
        player.setAttack(this.getDamage());
        return this;
    }
}
