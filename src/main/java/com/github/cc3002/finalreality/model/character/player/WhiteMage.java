package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of WhiteMages of the game.
 * @author Gustavo Varas Santander
 */
public class WhiteMage extends Mages {
    private final Map<String, Integer> whiteMagic = Map.of("Cure",15, "Poisson", 40,"Paralysis",25);

    /**
     * Creates a new WhiteMage.
     *
     * @param name
     *     the Mage's name.
     * @param turnsQueue
     *     the queue with the characters waiting for their turn.
     * @param healthpoints
     *     the health points of this Mage.
     * @param attack
     *     the attack of this Mage.
     * @param defense
     *     the defense of this Mage.
     */
    public WhiteMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, int healthpoints,
                     int attack, int defense, int mana, int magicAttack) {
        super(name, turnsQueue,"WhiteMage", healthpoints, attack, defense,mana,magicAttack);
    }
    /**
     * Creates a new WhiteMage.
     *
     * @param name
     *     the Mage's name.
     * @param turnsQueue
     *     the queue with the characters waiting for their turn.
     */
    public WhiteMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue){
        super(name,turnsQueue,"WhiteMage");
    }

    /**
     * Equips the weapon if the type of weapon is in the list of permitted Weapons.
     * If the weapon is equipped the attack attribute and magic attack attribute of the character change
     * @param weapon
     *       The weapon to be equipped.
     */
    public void equip(Weapon weapon) {
        if (this.getHealthpoints()>0) {
            if (weapon.equipToWhiteMage(this)!=null) {
                this.equippedWeapon = weapon.equipToWhiteMage(this);
            }
        }
    }

}
