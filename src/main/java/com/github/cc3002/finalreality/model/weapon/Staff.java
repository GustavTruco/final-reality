package com.github.cc3002.finalreality.model.weapon;

public class Staff extends Weapon{

    public int magicDamage;

    public Staff(final String name, final int damage, final int weight,int magicdamage) {
        super(name,damage,weight,"Staff");
        this.magicDamage=magicdamage;
    }


    @Override
    public int getMagicDamage() {
        return magicDamage;
    }
}
