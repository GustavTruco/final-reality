package com.github.cc3002.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of a weapon.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public class Weapon {

  private final String name;
  private final int damage;
  private final int weight;
  private final String type;

  /**
   * Creates a weapon with a name, a base damage, speed and it's type.
   *
   * @see Weapon subclases with the types
   */
  public Weapon(final String name, final int damage, final int weight,
      final String type) {
    this.name = name;
    this.damage = damage;
    this.weight = weight;
    this.type = type;
  }

  private String getName() {
    return name;
  }

  public int getDamage() {
    return damage;
  }

  public int getWeight() {
    return weight;
  }

  public String getType() {
    return type;
  }

  public int getMagicDamage(){return 0;}


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
        getType().equals(weapon.getType());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDamage(), getWeight(), getType());
  }
}
