package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.BlackMage;

import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ThiefTest extends AbstractCharacterTest{
    protected List<Thief> testCharacters;
    protected BlockingQueue<ICharacter> turns;
    private static final String THIEF_NAME = "Kevin";
    protected List<Weapon> testWeapons;

    @BeforeEach
    void setUp(){
        basicSetUp();
        turns= new LinkedBlockingQueue<>();
        testCharacters= new ArrayList<>();
        testCharacters.add(new Thief(THIEF_NAME, turns));
        testCharacters.add(new Thief(THIEF_NAME,turns, 10,4,5));
        testWeapons = new ArrayList<>();
        testWeapons.add(new Bow("testBow",30,10));
        testWeapons.add(new Knife("testKnife",20,10));
        testWeapons.add(new Sword("testSword",10,10));
        testWeapons.add(new Staff("testStaff",15,10,5));
    }

    /**
     * Checks that the character waits the appropriate amount of time for it's turn.
     */
    @Test
    void waitTurnTest() {
        Assertions.assertTrue(turns.isEmpty());
        tryToEquip(testCharacters.get(0));
        testCharacters.get(0).waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(900);
            Assertions.assertEquals(0, turns.size());
            Thread.sleep(200);
            Assertions.assertEquals(1, turns.size());
            Assertions.assertEquals(testCharacters.get(0), turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void tryToEquip(Thief character) {
        character.equip(testWeapons.get(0));
    }

    /**
     * Checks that the class' constructor and equals method works properly.
     */

    @Test
    void constructorTest() {
        var enemy = new Enemy("Enemy", 10, turns);
        checkConstruction(new Thief(THIEF_NAME, turns),
                testCharacters.get(0),
                new Thief("Test", turns), new BlackMage(THIEF_NAME,turns));
    }

    @Test
    void equipWeaponTest() {
        var char1=testCharacters.get(0);
        var weap1 = testWeapons.get(0);
        var weap2 = testWeapons.get(1);
        var weap3 = testWeapons.get(2);
        var weap4 = testWeapons.get(3);
        char1.equip(weap1);
        assertEquals(30,char1.getAttack());
        assertEquals(weap1,char1.getEquippedWeapon());
        char1.equip(weap2);
        assertEquals(20,char1.getAttack());
        assertEquals(weap2,char1.getEquippedWeapon());
        char1.equip(weap3);
        assertEquals(10,char1.getAttack());
        assertEquals(weap3,char1.getEquippedWeapon());
        char1.equip(weap4);
        assertNotEquals(15,char1.getAttack());
        assertNotEquals(weap4,char1.getEquippedWeapon());
    }

    @Test
    void AttackTest(){
        var char1=testCharacters.get(0);
        var char2=testCharacters.get(1);
        var enemy= new Enemy("Goblin",10,turns,70,10,10);
        char1.equip(testWeapons.get(0));
        char2.equip(testWeapons.get(0));
        assertEquals(30,char1.getAttack());
        assertEquals(30,char2.getAttack());
        char1.attack(enemy);
        assertEquals(40,enemy.getHealthpoints());
        char2.attack(enemy);
        assertEquals(10,enemy.getHealthpoints());
    }

    @Test
    void SettersTest(){
        var char1= testCharacters.get(0);
        assertEquals(0,char1.getAttack());
        assertEquals(0,char1.getDefense());
        assertEquals(0,char1.getHealthpoints());
        assertEquals(0,char1.getMaxHealth());
        char1.setAttack(10);
        assertEquals(10,char1.getAttack());
        char1.setDefense(10);
        assertEquals(10,char1.getDefense());
        char1.setHealthpoints(10);
        assertEquals(10,char1.getHealthpoints());
        assertEquals(10,char1.getMaxHealth());
        char1.setMaxHealth(20);
        assertEquals(20,char1.getMaxHealth());
    }
}


