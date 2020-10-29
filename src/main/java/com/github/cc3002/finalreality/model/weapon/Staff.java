package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.WhiteMage;

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

    /**
     * Equips Staffs to Black Mage class players.
     * Sets the attack of the character to the Staff damage,
     * sets the magic attack of the character to the Staff magical damage.
     * @param player
     *        The player's Character that will be eventually equipped.
     * @return this
     *        Returns this weapon.
     */
    @Override
    public Weapon equipToBlackMage(BlackMage player) {
        player.setAttack(this.getDamage());
        player.setMagicAttack(this.getMagicDamage());
        return this;
    }

    /**
     * Equips Staffs to White Mage class players.
     * Sets the attack of the character to the Staff damage,
     * sets the magic attack of the character to the Staff magical damage.
     * @param player
     *        The player's Character that will be eventually equipped.
     * @return this
     *        Returns this weapon.
     */
    @Override
    public Weapon equipToWhiteMage(WhiteMage player) {
        player.setAttack(this.getDamage());
        player.setMagicAttack(this.getMagicDamage());
        return this;
    }
}

