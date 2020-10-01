package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;
import java.util.*;

public class BlackMage extends Mages{

    private final String[] permittedWeapons ={"Knife","Staff"};
    private final Map<String, Integer> blackMagic = Map.of("Thunder",15, "Fire", 15);

    public BlackMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, int healthpoints, int attack, int defense, int mana) {
        super(name, turnsQueue,"BlackMage", healthpoints, attack, defense,mana);
        this.mana=mana;
    }
    public BlackMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue){
        super(name,turnsQueue,"BlackMage");
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

    public void magicAttack(String Spell, Enemy enemy){
        if (blackMagic.containsKey(Spell)){
            enemy.setHealthpoints(enemy.getHealthpoints()-this.magicAttack);
            this.setMana(this.getMana()-blackMagic.get(Spell));
        }
    }
}
