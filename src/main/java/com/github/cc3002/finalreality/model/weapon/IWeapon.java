package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.*;

/**
 * This represents a Weapon from the game.
 *
 * @author Gustavo Varas Santander
 */
public interface IWeapon {
    /**
     * Returns the Name of the Weapon.
     */
    String getName();

    /**
     * Returns the Damage of the Weapon.
     */
    int getDamage();

    /**
     * Returns the Weight of the Weapon.
     */
    int getWeight();

    /**
     * Returns the Type of the Weapon.
     */
    String getType();

    /**
     * Returns 0 as the default value of Magic Damage.
     */
    int getMagicDamage();


    /**
     *  Default values for equipToBlackMage.
     * returns null for the weapon
     * @param player
     *        The player's Character that will be eventually equipped.
     * @return null
     *        Returns null as the default.
     */
    IWeapon equipToBlackMage(BlackMage player);

    /**
     *  Default values for equipToEngineer.
     * returns null for the weapon
     * @param player
     *       The player's Character that will be eventually equipped.
     * @return null
     *        Returns null as the default.
     */
    IWeapon equipToEngineer(Engineer player);

    /**
     * Default values for equipToKnight.
     *returns null for the weapon
     * @param player
     *        The player's Character that will be eventually equipped.
     * @return null
     *        Returns null as the default.
     */
    IWeapon equipToKnight(Knight player);

    /**
     * Default values for equipToThief.
     *returns null for the weapon
     * @param player
     *        The player's Character that will be eventually equipped.
     * @return null
     *        Returns null as the default.
     */
    IWeapon equipToThief(Thief player);

    /**
     * return the weapon if is able to equipToWhiteMage.
     *returns null for the weapon
     */
    IWeapon equipToWhiteMage(WhiteMage player);
}
