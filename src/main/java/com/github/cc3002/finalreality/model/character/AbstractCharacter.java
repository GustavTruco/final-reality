package com.github.cc3002.finalreality.model.character;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacter;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Gustavo Varas Santander
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
  private final PropertyChangeSupport p= new PropertyChangeSupport(this);

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

  /**
   * Sets the attack of the Character to the int given.
   * @param attack
   *      The number the attack attribute will be set.
   */
  @Override
  public void setAttack(int attack){
    this.attack=attack;
  }


  /**
   * Sets the Health Points of the Character to the int given if the Character has no Max Health, it's
   * set it's to the given int. If the int is negative the HP are set to zero.
   * @param health
   *      The number the health attribute will be set.
   */
  @Override
  public void setHealthpoints(int health){
    int oldValue=getHealthpoints();
    if (health>0){
      if (this.maxHealth==0){
        this.maxHealth=health;
      }
      this.healthPoints=health;}
    else { this.healthPoints=0;}
    p.firePropertyChange("HealthPoints",oldValue,getHealthpoints());
  }

  /**
   * Sets the Max Health of the Character to the int given.
   * @param max_hp
   *     The number the max health will be set.
   */
  @Override
  public void setMaxHealth(int max_hp){ this.maxHealth=max_hp;}

  /**
   * Sets the Defense of the Character to the int given.
   * @param defense
   *     The number the defense attribute will be set.
   */
  @Override
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

  /**
   * Returns the Max Health of the Character.
   */
  @Override
  public int getMaxHealth() {
    return maxHealth;
  }


  /**
   * Returns the Health Points of the Character.
   */
  @Override
  public int getHealthpoints() {
    return healthPoints;
  }

  /**
   * Returns the Attack of the Character.
   */
  @Override
  public int getAttack() {
    return attack;
  }

  /**
   * Returns the Defense of the Character.
   */
  @Override
  public int getDefense() {
    return defense;
  }

  /**
   * Returns the Name of the Character.
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Returns the Class of the Character.
   */
  @Override
  public String getCharacterClass() {
    return characterClass;
  }

  /**
   * The character attacks another character reducing it's HP by the character attack minus the player defense.
   * This methods only works if the enemy is alive.
   * @param character
   *     The character that will be attacked.
   */
  @Override
  public void attack(ICharacter character) {
    if (this.getHealthpoints()>0) {
      if (this.getAttack() - character.getDefense()>0){
        character.setHealthpoints(character.getHealthpoints() - this.getAttack() +character.getDefense());}
    }
  }

  /**
   * Add a new Listener to the PropertyChangeSupport
   * @param listener
   */
  public void addListener(PropertyChangeListener listener){
    p.addPropertyChangeListener(listener);
  }
}
