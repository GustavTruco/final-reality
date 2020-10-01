package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;

public class Engineer extends PlayerCharacter{
    private final String[] permittedWeapons ={"Axe","Bow"};

    public Engineer(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, int healthpoints, int attack, int defense) {
        super(name,turnsQueue, "Engineer", healthpoints, attack, defense);
    }
    public Engineer(@NotNull String name,@NotNull BlockingQueue<ICharacter> turnsQueue){
        super(name,turnsQueue,"Engineer");
    }

    public void equip(Weapon weapon) {
        if (Arrays.asList(permittedWeapons).contains(weapon.getType())) {
            this.equippedWeapon = weapon;
            this.setAttack(equippedWeapon.getDamage());
        }
    }
}
