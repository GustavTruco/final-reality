package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Thief;

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

    /**
     * Equips Swords to Knight class players.
     * Sets the attack of the character to the Sword damage
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
     * Equips Swords to Thief class players.
     * Sets the attack of the character to the Sword damage
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
