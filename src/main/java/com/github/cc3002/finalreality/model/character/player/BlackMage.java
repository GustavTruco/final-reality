package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;
import java.util.*;

/**
 * A class that holds all the information of BlackMages of the game.
 * @author Gustavo Varas Santander
 */
public class BlackMage extends AbstractMages{
    private final Map<String, Integer> blackMagic = Map.of("Thunder",15, "Fire", 15);

    /**
     * Creates a new BlackMage.
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
    public BlackMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, int healthpoints,
                     int attack, int defense, int mana,int magicAttack) {
        super(name, turnsQueue,"BlackMage", healthpoints, attack, defense,mana,magicAttack);
    }

    /**
     * Creates a new BlackMage.
     *
     * @param name
     *     the Mage's name.
     * @param turnsQueue
     *     the queue with the characters waiting for their turn.
     */
    public BlackMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue){
        super(name,turnsQueue,"BlackMage");
    }

    /**
     * Equips the weapon if the type of weapon is in the list of permitted Weapons.
     * If the weapon is equipped the attack attribute and magic attack attribute of the character change
     * @param weapon
     *       The weapon to be equipped.
     */
    public void equip(Weapon weapon) {
        if (this.getHealthpoints()>0) {
            if (weapon.equipToBlackMage(this)!=null) {
                this.equippedWeapon = weapon.equipToBlackMage(this);
            }
        }
    }

    /**
     * Attacks with magic to an enemy, if the spell given is in the black magic list.
     * @param Spell
     *       The spell to be casted.
     * @param enemy
     *       The enemy that will be attacked.
     */
    public void magicAttack(String Spell, Enemy enemy){
        if (blackMagic.containsKey(Spell)){
            enemy.setHealthpoints(enemy.getHealthpoints()-this.magicAttack);
            this.setMana(this.getMana()-blackMagic.get(Spell));
        }
    }
}
