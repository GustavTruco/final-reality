package com.github.cc3002.finalreality.model.character;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author <Your name>
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


  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    var enemy = (Enemy) this;
    scheduledExecutor.schedule(this::addToQueue, enemy.getWeight() / 10, TimeUnit.SECONDS);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Enemy)) {
      return false;
    }
    final Enemy enemy = (Enemy) o;
    return getWeight() == enemy.getWeight();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getWeight());
  }
}
