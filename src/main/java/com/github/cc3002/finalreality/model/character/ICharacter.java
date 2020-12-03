package com.github.cc3002.finalreality.model.character;
/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
 * @author Gustavo Varas Santander
 */
public interface ICharacter {

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();
  /**
   * Returns this character's name.
   */
  String getName();

  /**
   * Returns this character's class.
   */
  String getCharacterClass();

  /**
   *
   * Returns this character's Health Points
   */

  int getHealthpoints();

  /**
   *
   * Returns this character's Attack Value
   */

  int getAttack();

  /**
   *
   * Returns this character's Defense Value
   */

  int getDefense();

  /**
   *
   * Returns this character's Max Health Value
   */

  int getMaxHealth();

  /**
   * Sets the attack of the Character to the int given.
   * @param attack
   *      The number the attack attribute will be set.
   */
  void setAttack(int attack);


  /**
   * Sets the Health Points of the Character to the int given if the Character has no Max Health, it's
   * set it's to the given int. If the int is negative the HP are set to zero.
   * @param health
   *      The number the health attribute will be set.
   */

  void setHealthpoints(int health);

  /**
   * Sets the Max Health of the Character to the int given.
   * @param max_hp
   *     The number the max health will be set.
   */

  void setMaxHealth(int max_hp);

  /**
   * Sets the Defense of the Character to the int given.
   * @param defense
   *     The number the defense attribute will be set.
   */

  void setDefense(int defense);

  /**
   * Attacks another Character reducing its HP by this character attack minus the defender defense
   */

  void attack(ICharacter character);
}


