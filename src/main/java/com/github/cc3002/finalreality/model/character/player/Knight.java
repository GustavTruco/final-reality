package com.github.cc3002.finalreality.model.character.player;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;

public class Knight extends PlayerCharacter{

    private final String[] permittedWeapons ={"Sword","Axe","Knife"};

    public Knight(@NotNull String name,@NotNull BlockingQueue<ICharacter> turnsQueue, int healthpoints,int attack,int defense) {
        super(name,turnsQueue, "Knight", healthpoints, attack, defense);
    }
    public Knight(@NotNull String name,@NotNull BlockingQueue<ICharacter> turnsQueue){
        super(name,turnsQueue,"Knight");
    }

    public void equip(Weapon weapon) {
        if (Arrays.asList(permittedWeapons).contains(weapon.getType())) {
            this.equippedWeapon = weapon;
            this.setAttack(equippedWeapon.getDamage());
        }
    }
}
