package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;



/**
 * A class that holds all the information of Mages of the game.
 * @author Gustavo Varas Santander
 */

public abstract class AbstractMages extends AbstractPlayerCharacter {

    protected int mana;
    protected int magicAttack=0;

    /**
     * Creates a new Mage.
     *
     * @param name
     *     the Mage's name
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     * @param characterClass
     *     the class of this Mage
     * @param healthpoints
     *     the health points of this Mage
     * @param attack
     *     the attack of this Mage
     * @param defense
     *     the defense of this Mage
     */
    public AbstractMages(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
                    String characterClass, int healthpoints,int attack,int defense,int mana,int magicAttack) {
        super(name, turnsQueue, characterClass, healthpoints, attack, defense);
        this.mana=mana;
        this.magicAttack=magicAttack;
    }
    /**
     * Creates a new Mage.
     *
     * @param name
     *     the Mage's name
     * @param turnsQueue
     *     the queue with the Mage waiting for their turn
     * @param characterClass
     *     the class of this Mage
     */
    public AbstractMages(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, final String characterClass){
        super(name,turnsQueue,characterClass);
    }

    /**
     * Returns the mana of the Mage.
     */
    public int getMana() {
        return mana;
    }

    /**
     * Sets the Mage mana to the given int.
     * @param mana
     *       The number the mana attribute will be set.
     */
    public void setMana(int mana) {
        this.mana = mana;
    }

    /**
     * Sets the Mage magic attack to the given int.
     * @param magicAttack
     *       The number the magic attack attribute will be set.
     */
    public void setMagicAttack(int magicAttack){this.magicAttack=magicAttack;}

    /**
     * Returns the Mage magic attack.
     */
    public int getMagicAttack(){return this.magicAttack;}

    /**
     * Sets a new equals method based on a Mage attributes.
     * @param o
     *      The object to be compared with.
     */

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractMages)) {
            return false;
        }
        final AbstractMages that = (AbstractMages) o;
        return getCharacterClass().equals(that.getCharacterClass())
                && getName().equals(that.getName()) &&
                getHealthpoints() == that.getHealthpoints() &&
                getAttack() == that.getAttack() &&
                getDefense() == that.getDefense() &&
                getMana()==that.getMana() &&
                getMagicAttack() == that.getMagicAttack();
    }

    /**
     * Sets a new hashCode method based on a Mage attributes.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getCharacterClass(),getName(), getHealthpoints(), getAttack(), getDefense(),getMana(),getMagicAttack());
    }
}
