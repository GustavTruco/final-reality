package com.github.cc3002.finalreality.model.character;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacter;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author Gustavo Varas
 */
public class Enemy extends AbstractCharacter {

  private final int weight;

  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   */
  public Enemy(@NotNull final String name, final int weight,
      @NotNull final BlockingQueue<ICharacter> turnsQueue) {
    super(turnsQueue, name, "Enemy");
    this.weight = weight;
  }
  /**
   * Creates a new enemy with a name, a weight, the queue with the characters ready to
   * play, it's healthpoints, it's attack and it's defense.
   */
  public Enemy(@NotNull final String name, final int weight,
               @NotNull final BlockingQueue<ICharacter> turnsQueue,
               int healthpoints,int attack, int defense) {
    super(turnsQueue,name,"Enemy",healthpoints,attack,defense);
    this.weight=weight;
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }


  /**
   * The enemy waits it's turn based on it's weight.
   */

  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    var enemy = (Enemy) this;
    scheduledExecutor.schedule(this::addToQueue, enemy.getWeight() / 10, TimeUnit.SECONDS);
  }

  /**
   * The enemy attacks a player reducing it's HP by the character attack minus the player defense.
   * This methods only works if the enemy is alive.
   * @param player
   *     The player that will be attacked.
   */
  public void attack(AbstractPlayerCharacter player) {
    if (this.getHealthpoints()>0) {
      if (this.getAttack() - player.getDefense()>0){
        player.setHealthpoints(player.getHealthpoints() - this.getAttack() + player.getDefense());}
    }
  }



  /**
   * Sets a new equals method based on an enemy attributes.
   * @param o
   *      the object to be compare with
   */

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Enemy)) {
      return false;
    }
    final Enemy enemy = (Enemy) o;
    return getWeight() == enemy.getWeight() &&
            getAttack()== enemy.getAttack() &&
            getDefense() == enemy.getDefense() &&
            getHealthpoints() == enemy.getHealthpoints();
  }

  /**
   * Sets a new hashCode method based on an enemy attributes.
   */

  @Override
  public int hashCode() {
    return Objects.hash(getWeight());
  }
}
