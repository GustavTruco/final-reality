package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;


/**
 * A class that holds all the information of a single character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Gustavo Varas Santander
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter implements IPlayerCharacter{
  protected Weapon equippedWeapon = null;


  /**
   * Creates a new character.
   *
   * @param name
   *     the character's name
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param characterClass
   *     the class of this character
   * @param healthpoints
   *     the health points of this character
   * @param attack
   *     the attack of this character
   * @param defense
   *     the defense of this character
   */

  public AbstractPlayerCharacter(@NotNull String name,
                                 @NotNull BlockingQueue<ICharacter> turnsQueue,
                                 final String characterClass, int healthpoints, int attack, int defense) {
    super(turnsQueue, name, characterClass, healthpoints, attack, defense);
  }

  /**
   * Creates a new character.
   *
   * @param name
   *     the character's name
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param characterClass
   *     the class of this character
   */
  public AbstractPlayerCharacter(@NotNull String name,
                                 @NotNull BlockingQueue<ICharacter> turnsQueue,
                                 final String characterClass){
    super(turnsQueue,name,characterClass);
  }

  /**
   * Returns the equipped weapon of the character
   */

  public Weapon getEquippedWeapon() {
    return equippedWeapon;
  }

  /**
   * The character waits it turn based on the weight of the weapon equipped.
   */

  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor.schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
  }

  /**
   * Sets a new hashCode method based on a Player attributes.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getCharacterClass(),getName(), getHealthpoints(), getAttack(), getDefense());
  }

  /**
   *Returns false as objets that inherit this class are not enemies
   */
  @Override
  public boolean isEnemy() {
    return false;
  }

  /**
   * Sets a new equals method based on a Player attributes.
   * @param o
   *     The object with will be compared.
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractPlayerCharacter)) {
      return false;
    }
    final AbstractPlayerCharacter that = (AbstractPlayerCharacter) o;
    return getCharacterClass().equals(that.getCharacterClass())
        && getName().equals(that.getName()) &&
            getHealthpoints() == that.getHealthpoints()&&
            getAttack() == that.getAttack()&&
            getDefense() == that.getDefense();
  }
}
