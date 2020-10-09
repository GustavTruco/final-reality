package com.github.cc3002.finalreality.model.character;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public abstract class AbstractCharacter implements ICharacter {

  protected final BlockingQueue<ICharacter> turnsQueue;
  protected final String name;
  protected final String characterClass;
  protected int maxHealth=0;
  protected int healthPoints=0;
  protected int attack=0;
  protected int defense=0;
  protected ScheduledExecutorService scheduledExecutor;

  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
      @NotNull String name, String characterClass, int healthpoints, int attack,int defense) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.characterClass = characterClass;
    this.healthPoints=healthpoints;
    this.maxHealth=healthpoints;
    this.attack=attack;
    this.defense=defense;
  }

  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                              @NotNull String name, String characterClass){
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.characterClass = characterClass;
  }

  public void setAttack(int attack){
    this.attack=attack;
  }

  public void setHealthpoints(int health){
    if (this.maxHealth==0){
      this.maxHealth=health;
    }
    this.healthPoints=health;
  }

  public void setMaxHealth(int max_hp){ this.maxHealth=max_hp;}

  public void setDefense(int defense){
    this.defense=defense;
  }

  /**
   * Adds this character to the turns queue.
   */
  protected void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  @Override
  public int getMaxHealth() {
    return maxHealth;
  }

  @Override
  public int getHealthpoints() {
    return healthPoints;
  }

  @Override
  public int getAttack() {
    return attack;
  }

  @Override
  public int getDefense() {
    return defense;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getCharacterClass() {
    return characterClass;
  }
}
