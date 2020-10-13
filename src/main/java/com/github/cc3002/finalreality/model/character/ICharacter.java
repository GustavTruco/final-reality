package com.github.cc3002.finalreality.model.character;
import com.github.cc3002.finalreality.model.weapon.Weapon;
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
}


