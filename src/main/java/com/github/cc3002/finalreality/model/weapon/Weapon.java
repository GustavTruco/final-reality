package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.*;

import java.util.Objects;

/**
 * A class that holds all the information of a weapon.
 *
 * @author Ignacio Slater Muñoz.
 * @author Gustavo Varas Santander
 */
public class Weapon extends AbstractWeapon{


  /**
   * Creates a weapon with a name, a base damage, weight and it's type.
   *
   * @param name
   *       The name of the Weapon.
   * @param damage
   *       The damage of the Weapon.
   * @param weight
   *       The weight of the Weapon.
   * @param type
   *       The type of the Weapon.
   */
  public Weapon(final String name, final int damage, final int weight,
      final String type) {
    super(name,damage,weight,type);
  }

  /**
   *  Default values for equipToBlackMage.
   * returns null for the weapon
   * @param player
   *        The player's Character that will be eventually equipped.
   * @return null
   *        Returns null as the default.
   */
  public Weapon equipToBlackMage(BlackMage player){
    return null;
  }

  /**
   *  Default values for equipToEngineer.
   * returns null for the weapon
   * @param player
   *       The player's Character that will be eventually equipped.
   * @return null
   *        Returns null as the default.
   */
  public Weapon equipToEngineer(Engineer player){
    return null;
  }

  /**
   * Default values for equipToKnight.
   *returns null for the weapon
   * @param player
   *        The player's Character that will be eventually equipped.
   * @return null
   *        Returns null as the default.
   */
  public Weapon equipToKnight(Knight player){
    return null;
  }

  /**
   * Default values for equipToThief.
   *returns null for the weapon
   * @param player
   *        The player's Character that will be eventually equipped.
   * @return null
   *        Returns null as the default.
   */
  public Weapon equipToThief(Thief player){
    return null;
  }

  /**
   * Default values for equipToWhiteMage.
   *returns null for the weapon
   * @param player
   *        The player's Character that will be eventually equipped.
   * @return null
   *        Returns null as the default.
   */
  public Weapon equipToWhiteMage(WhiteMage player){
    return null;
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
    if (!(o instanceof Weapon)) {
      return false;
    }
    final Weapon weapon = (Weapon) o;
    return getDamage() == weapon.getDamage() &&
        getWeight() == weapon.getWeight() &&
        getName().equals(weapon.getName()) &&
        getType().equals(weapon.getType()) &&
            getMagicDamage()==weapon.getMagicDamage();
  }

  /**
   * Sets a new hashCode method based on the Weapon attributes.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDamage(), getWeight(), getType(),getMagicDamage());
  }
}
