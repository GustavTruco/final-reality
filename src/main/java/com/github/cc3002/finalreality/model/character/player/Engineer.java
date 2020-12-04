package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of Engineers of the game.
 * @author Gustavo Varas Santander
 */
public class Engineer extends AbstractPlayerCharacter {
    /**
     * Creates a new Engineer.
     *
     * @param name
     *     the Engineer's name.
     * @param turnsQueue
     *     the queue with the characters waiting for their turn.
     * @param healthpoints
     *     the health points of this Engineer.
     * @param attack
     *     the attack of this Engineer.
     * @param defense
     *     the defense of this Engineer.
     */
    public Engineer(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, int healthpoints, int attack, int defense) {
        super(name,turnsQueue, "Engineer", healthpoints, attack, defense);
    }

    /**
     * Creates a new Engineer.
     *
     * @param name
     *     the Engineer's name.
     * @param turnsQueue
     *     the queue with the characters waiting for their turn.
     */
    public Engineer(@NotNull String name,@NotNull BlockingQueue<ICharacter> turnsQueue){
        super(name,turnsQueue,"Engineer");
    }

    /**
     * Equips the weapon if the type of weapon is in the list of permitted Weapons.
     * If the weapon is equipped the attack attribute and magic attack attribute of the character change
     * @param weapon
     *       The weapon to be equipped.
     */
    public void equip(Weapon weapon) {
        if (this.getHealthpoints()>0) {
            if (weapon.equipToEngineer(this)!=null) {
                this.equippedWeapon = weapon.equipToEngineer(this);
            }
        }
    }
}
