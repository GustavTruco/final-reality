package com.github.cc3002.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of a weapon.
 *
 * @author Ignacio Slater Muñoz.
 * @author Gustavo Varas Santander
 */
public class Weapon {

  private final String name;
  private final int damage;
  private final int weight;
  private final String type;

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
    this.name = name;
    this.damage = damage;
    this.weight = weight;
    this.type = type;
  }

  /**
   * Returns the Name of the Weapon.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the Damage of the Weapon.
   */
  public int getDamage() {
    return damage;
  }

  /**
   * Returns the Weight of the Weapon.
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Returns the Type of the Weapon.
   */
  public String getType() {
    return type;
  }

  /**
   * Returns 0 as the default value of Magic Damage.
   */
  public int getMagicDamage(){return 0;}


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
        getType().equals(weapon.getType()) && getMagicDamage()==weapon.getMagicDamage();
  }

  /**
   * Sets a new hashCode method based on the Weapon attributes.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDamage(), getWeight(), getType(),getMagicDamage());
  }
}
