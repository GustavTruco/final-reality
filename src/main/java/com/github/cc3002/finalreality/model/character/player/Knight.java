package com.github.cc3002.finalreality.model.character.player;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of Knights of the game.
 * @author Gustavo Varas Santander
 */
public class Knight extends PlayerCharacter{

    private final String[] permittedWeapons ={"Sword","Axe","Knife"};

    /**
     * Creates a new Knight.
     *
     * @param name
     *     the Knight's name.
     * @param turnsQueue
     *     the queue with the characters waiting for their turn.
     * @param healthpoints
     *     the health points of this Knight.
     * @param attack
     *     the attack of this Knight.
     * @param defense
     *     the defense of this Knight.
     */
    public Knight(@NotNull String name,@NotNull BlockingQueue<ICharacter> turnsQueue, int healthpoints,int attack,int defense) {
        super(name,turnsQueue, "Knight", healthpoints, attack, defense);
    }

    /**
     * Creates a new Knight.
     *
     * @param name
     *     the Knight's name.
     * @param turnsQueue
     *     the queue with the characters waiting for their turn.
     */
    public Knight(@NotNull String name,@NotNull BlockingQueue<ICharacter> turnsQueue){
        super(name,turnsQueue,"Knight");
    }


    /**
     * Equips the weapon if the type of weapon is in the list of permitted Weapons.
     * If the weapon is equipped the attack attribute and magic attack attribute of the character change
     * @param weapon
     *       The weapon to be equipped.
     */
    public void equip(Weapon weapon) {
        if (Arrays.asList(permittedWeapons).contains(weapon.getType())) {
            this.equippedWeapon = weapon;
            this.setAttack(equippedWeapon.getDamage());
        }
    }
}
