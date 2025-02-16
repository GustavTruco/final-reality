package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;

/**
 * This represents a Player character from the game.
 * A Player character can only be controlled by the player.
 *
 * @author Gustavo Varas Santander
 */
public interface IPlayerCharacter extends ICharacter {

    /**
     * Returns the equipped weapon of the character
     */
    Weapon getEquippedWeapon();

    /**
     * Equips a Weapon to the Character
     */
    void equip(Weapon weapon);

}
