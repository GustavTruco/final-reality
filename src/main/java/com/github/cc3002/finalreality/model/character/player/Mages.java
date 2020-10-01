package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;

public class Mages extends PlayerCharacter{

    protected int mana;
    protected int magicAttack=0;

    public Mages(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
                    String characterClass, int healthpoints,int attack,int defense,int mana) {
        super(name, turnsQueue, characterClass, healthpoints, attack, defense);
        this.mana=mana;
    }
    public Mages(@NotNull String name,@NotNull BlockingQueue<ICharacter> turnsQueue, final String characterClass){
        super(name,turnsQueue,characterClass);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setMagicAttack(int magicAttack){this.magicAttack=magicAttack;}
}
