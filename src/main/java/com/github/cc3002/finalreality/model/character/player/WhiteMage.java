package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class WhiteMage extends Mages {
    private final String[] permittedWeapons ={"Staff"};
    private final Map<String, Integer> whiteMagic = Map.of("Cure",15, "Poisson", 40,"Paralysis",25);

    public WhiteMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, int healthpoints, int attack, int defense, int mana) {
        super(name, turnsQueue,"WhiteMage", healthpoints, attack, defense,mana);
        this.mana=mana;
    }
    public WhiteMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue){
        super(name,turnsQueue,"WhiteMage");
    }

    public void equip(Weapon weapon) {
        if (Arrays.asList(permittedWeapons).contains(weapon.getType())) {
            this.equippedWeapon = weapon;
            this.setAttack(equippedWeapon.getDamage());

            if (weapon.getType().equals("Staff")){
                this.setMagicAttack(weapon.getMagicDamage());
            }
        }
    }

}
