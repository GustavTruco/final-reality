package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Thief;

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



    /**
     * Equips Knives to Knight class players.
     * Sets the attack of the character to the Knife damage
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
     * Equips Knives to Black Mage class players.
     * Sets the attack of the character to the Knife damage
     * @param player
     *        The player's Character that will be eventually equipped.
     * @return this
     *        Returns this weapon.
     */
    @Override
    public Weapon equipToBlackMage(BlackMage player) {
        player.setAttack(this.getDamage());
        return this;
    }

    /**
     * Equips Knives to Thief class players.
     * Sets the attack of the character to the Knife damage
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
