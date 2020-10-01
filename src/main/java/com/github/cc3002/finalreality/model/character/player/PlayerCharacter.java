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
 * @author <Your name>
 */
public class PlayerCharacter extends AbstractCharacter {

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
  protected Weapon equippedWeapon = null;

  public PlayerCharacter(@NotNull String name,
      @NotNull BlockingQueue<ICharacter> turnsQueue,
      final String characterClass, int healthpoints,int attack,int defense) {
    super(turnsQueue, name, characterClass, healthpoints, attack, defense);
  }
  public PlayerCharacter(@NotNull String name,
                         @NotNull BlockingQueue<ICharacter> turnsQueue,
                         final String characterClass){
    super(turnsQueue,name,characterClass);
  }

  public Weapon getEquippedWeapon() {
    return equippedWeapon;
  }

  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor.schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
  }

  public void attack(Enemy enemy) {
    enemy.setHealthpoints(enemy.getHealthpoints()-this.getAttack());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCharacterClass());
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PlayerCharacter)) {
      return false;
    }
    final PlayerCharacter that = (PlayerCharacter) o;
    return getCharacterClass().equals(that.getCharacterClass())
        && getName().equals(that.getName());
  }
}
