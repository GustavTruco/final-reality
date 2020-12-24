package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.WhiteMage;
import com.github.cc3002.finalreality.model.weapon.Staff;
import com.github.cc3002.finalreality.model.weapon.Sword;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

public class WhiteMageTest extends AbstractCharacterTest{

    protected List<WhiteMage> testCharacters;
    protected BlockingQueue<ICharacter> turns;
    private static final String WMAGE_NAME = "Ling";
    protected List<Weapon> testWeapons;

    @BeforeEach
    void setUp(){
        basicSetUp();
        turns= new LinkedBlockingQueue<>();
        testCharacters= new ArrayList<>();
        testCharacters.add(new WhiteMage(WMAGE_NAME, turns));
        testCharacters.add(new WhiteMage(WMAGE_NAME,turns, 10,4,5,10,10));
        testWeapons = new ArrayList<>();
        testWeapons.add(new Staff("testStaff",15,10,5));
        testWeapons.add(new Sword("testSword",10,10));
    }

    /**
     * Checks that the character waits the appropriate amount of time for it's turn.
     */
    @Test
    void waitTurnTest() {
        Assertions.assertTrue(turns.isEmpty());
        tryToEquip(testCharacters.get(1));
        testCharacters.get(1).waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(900);
            Assertions.assertEquals(0, turns.size());
            Thread.sleep(200);
            Assertions.assertEquals(1, turns.size());
            Assertions.assertEquals(testCharacters.get(1), turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void tryToEquip(WhiteMage character) {
        character.equip(testWeapons.get(0));
    }

    /**
     * Checks that the class' constructor and equals method works properly.
     */

    @Test
    void constructorTest() {
        checkConstruction(new WhiteMage(WMAGE_NAME, turns),
                testCharacters.get(0),
                new WhiteMage("Test", turns), new Knight(WMAGE_NAME,turns));
        checkConstruction(new WhiteMage(WMAGE_NAME, turns,10,4,5,10,10),
                testCharacters.get(1),
                new WhiteMage(WMAGE_NAME, turns,11,4,5,10,10),
                new Knight(WMAGE_NAME,turns,10,10,10));
        checkConstruction(new WhiteMage(WMAGE_NAME, turns,10,4,5,10,10),
                testCharacters.get(1),
                new WhiteMage(WMAGE_NAME, turns,10,5,5,10,10),
                new Knight(WMAGE_NAME,turns,10,10,10));
        checkConstruction(new WhiteMage(WMAGE_NAME, turns,10,4,5,10,10),
                testCharacters.get(1),
                new WhiteMage(WMAGE_NAME, turns,10,4,6,10,10),
                new Knight(WMAGE_NAME,turns,10,10,10));
        checkConstruction(new WhiteMage(WMAGE_NAME, turns,10,4,5,10,10),
                testCharacters.get(1),
                new WhiteMage(WMAGE_NAME, turns,10,4,5,11,10),
                new Knight(WMAGE_NAME,turns,10,10,10));
        checkConstruction(new WhiteMage(WMAGE_NAME, turns,10,4,5,10,10),
                testCharacters.get(1),
                new WhiteMage(WMAGE_NAME, turns,10,4,5,10,11),
                new BlackMage(WMAGE_NAME,turns,10,4,5,10,10));
    }


    @Test
    void equipWeaponTest() {
        var char1=testCharacters.get(0);
        var char2=testCharacters.get(1);
        var weap1 = testWeapons.get(0);
        var weap2 = testWeapons.get(1);
        char1.equip(weap1);
        char2.equip(weap1);
        assertEquals(0,char1.getAttack());
        assertEquals(15,char2.getAttack());
        assertNull(char1.getEquippedWeapon());
        assertEquals(weap1,char2.getEquippedWeapon());

        char1.equip(weap2);
        char2.equip(weap2);
        assertEquals(0,char1.getAttack());
        assertNotEquals(10,char2.getAttack());
        assertNull(char1.getEquippedWeapon());
        assertNotEquals(weap2,char2.getEquippedWeapon());
    }

    @Test
    void AttackTest(){
        var char2=testCharacters.get(1);
        var enemy= new Enemy("Goblin",10,turns,50,10,10);
        char2.equip(testWeapons.get(0));
        assertEquals(15,char2.getAttack());
        char2.attack(enemy);
        assertEquals(45,enemy.getHealthpoints());
    }

    @Test
    void SettersTest(){
        var char1= testCharacters.get(0);
        assertEquals(false,char1.isEnemy());
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
        char1.setHealthpoints(-10);
        assertEquals(0,char1.getHealthpoints());
        assertEquals(10,char1.getMaxHealth());
        char1.setMaxHealth(20);
        assertEquals(20,char1.getMaxHealth());
    }
}
