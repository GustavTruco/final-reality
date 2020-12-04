package com.github.cc3002.finalreality.model;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.concurrent.BlockingQueue;

public class ControllerTest {
    protected Controller controller;
    protected BlockingQueue<ICharacter> turns;
    @BeforeEach
    void setUp(){
        controller= new Controller(5,3);
        turns=controller.getTurns();
    }

    @Test
    void TestPlayerCharacterCreation(){
        Assertions.assertEquals(0,controller.getParty().size());

        Knight ExpectedKnight= new Knight("TestKnight",turns,50,0,0);
        controller.createKnight("TestKnight",50,0,0);
        Assertions.assertEquals(ExpectedKnight,controller.getParty().get("TestKnight"));
        Assertions.assertEquals(1,controller.getParty().size());

        Thief ExpectedThief= new Thief("TestThief",turns,50,0,0);
        controller.createThief("TestThief",50,0,0);
        Assertions.assertEquals(ExpectedThief,controller.getParty().get("TestThief"));
        Assertions.assertEquals(2,controller.getParty().size());

        Engineer ExpectedEngineer= new Engineer("TestEngineer",turns,50,0,0);
        controller.createEngineer("TestEngineer",50,0,0);
        Assertions.assertEquals(ExpectedEngineer,controller.getParty().get("TestEngineer"));
        Assertions.assertEquals(3,controller.getParty().size());

        BlackMage ExpectedBlackMage= new BlackMage("TestBlackMage",turns,50,0,0,0,0);
        controller.createBlackMage("TestBlackMage",50,0,0,0,0);
        Assertions.assertEquals(ExpectedBlackMage,controller.getParty().get("TestBlackMage"));
        Assertions.assertEquals(4,controller.getParty().size());

        WhiteMage ExpectedWhiteMage = new WhiteMage("TestWhiteMage", turns, 50, 0, 0,0,0);
        controller.createWhiteMage("TestWhiteMage",50,0,0,0,0);
        Assertions.assertEquals(ExpectedWhiteMage,controller.getParty().get("TestWhiteMage"));
        Assertions.assertEquals(5,controller.getParty().size());

        /*As PlayerParty has reached its maximum if we call the methods again should not add new Characters*/
        controller.createKnight("TestKnight2",50,0,0);
        Assertions.assertEquals(5,controller.getParty().size());
        controller.createThief("TestThief2",50,0,0);
        Assertions.assertEquals(5,controller.getParty().size());
        controller.createEngineer("TestEngineer2",50,0,0);
        Assertions.assertEquals(5,controller.getParty().size());
        controller.createBlackMage("TestBlackMage2",50,0,0,0,0);
        Assertions.assertEquals(5,controller.getParty().size());
        controller.createWhiteMage("TestWhiteMage2",50,0,0,0,0);
        Assertions.assertEquals(5,controller.getParty().size());
    }

    @Test
    void TestEnemyCreator(){
        Assertions.assertEquals(0,controller.getEnemies().size());

        Enemy ExpectedEnemy1= new Enemy("TestGoblin1",10,turns,10,0,0);
        controller.createEnemy("TestGoblin1",10,10,0,0);
        Assertions.assertEquals(1,controller.getEnemies().size());
        Assertions.assertEquals(ExpectedEnemy1,controller.getEnemies().get("TestGoblin1"));

        Enemy ExpectedEnemy2= new Enemy("TestGoblin2",10,turns,40,0,0);
        controller.createEnemy("TestGoblin2",10,40,0,0);
        Assertions.assertEquals(2,controller.getEnemies().size());
        Assertions.assertEquals(ExpectedEnemy2,controller.getEnemies().get("TestGoblin2"));

        Enemy ExpectedEnemy3= new Enemy("TestGoblin3",10,turns,20,0,0);
        controller.createEnemy("TestGoblin3",10,20,0,0);
        Assertions.assertEquals(3,controller.getEnemies().size());
        Assertions.assertEquals(ExpectedEnemy3,controller.getEnemies().get("TestGoblin3"));

        /*As we reached the limit of enemies if we try to create more, they should not be added to the list*/
        controller.createEnemy("TestGoblin3",10,20,0,0);
        Assertions.assertEquals(3,controller.getEnemies().size());
    }

    @Test
    void TestWeaponCreation(){
        Assertions.assertEquals(0,controller.getInventory().size());

        Axe ExpectedAxe= new Axe("TestAxe",10,10);
        controller.createAxe("TestAxe",10,10);
        Assertions.assertEquals(1,controller.getInventory().size());
        Assertions.assertEquals(ExpectedAxe,controller.getInventory().get("TestAxe"));

        Bow ExpectedBow= new Bow("TestBow",10,10);
        controller.createBow("TestBow",10,10);
        Assertions.assertEquals(2,controller.getInventory().size());
        Assertions.assertEquals(ExpectedBow,controller.getInventory().get("TestBow"));

        Sword ExpectedSword= new Sword("TestSword",10,10);
        controller.createSword("TestSword",10,10);
        Assertions.assertEquals(3,controller.getInventory().size());
        Assertions.assertEquals(ExpectedSword,controller.getInventory().get("TestSword"));

        Knife ExpectedKnife= new Knife("TestKnife",10,10);
        controller.createKnife("TestKnife",10,10);
        Assertions.assertEquals(4,controller.getInventory().size());
        Assertions.assertEquals(ExpectedKnife,controller.getInventory().get("TestKnife"));

        Staff ExpectedStaff= new Staff("TestStaff",10,10,10);
        controller.createStaff("TestStaff",10,10,10);
        Assertions.assertEquals(5,controller.getInventory().size());
        Assertions.assertEquals(ExpectedStaff,controller.getInventory().get("TestStaff"));

    }

    @Test
    void TestAttack() {
        controller.createEnemy("TestEnemy", 10, 100, 10, 5);
        controller.createKnight("TestKnight",100,5,2);
        Assertions.assertEquals(100,controller.getHealthPoints(controller.getParty().get("TestKnight")));
        controller.attack(controller.getEnemies().get("TestEnemy"),controller.getParty().get("TestKnight"));
        Assertions.assertEquals(92,controller.getHealthPoints(controller.getParty().get("TestKnight")));

    }

    @Test
    void TestEquip(){
        controller.createKnight("TestKnight",100,0,10);
        Assertions.assertNull(controller.getCharacterWeapon(controller.getParty().get("TestKnight")));

        controller.createSword("TestSword1",100,10);
        controller.createSword("TestSword2",50,10);
        controller.createStaff("TestStaff",10,10,10);
        Assertions.assertEquals(3,controller.getInventory().size());

        Sword ExpectedSword1= new Sword("TestSword1",100,10);
        Sword ExpectedSword2= new Sword("TestSword2",50,10);
        Staff ExpectedStaff= new Staff("TestStaff",10,10,10);

        controller.equipWeaponToPlayer(controller.getInventory().get("TestSword1"),
                controller.getParty().get("TestKnight"));
        Assertions.assertEquals(ExpectedSword1,controller.getCharacterWeapon(controller.getParty().get("TestKnight")));
        Assertions.assertFalse(controller.getInventory().containsKey("TestSword1"));

        controller.equipWeaponToPlayer(controller.getInventory().get("TestSword2"),
                controller.getParty().get("TestKnight"));
        Assertions.assertEquals(ExpectedSword2,controller.getCharacterWeapon(controller.getParty().get("TestKnight")));
        Assertions.assertFalse(controller.getInventory().containsKey("TestSword2"));
        Assertions.assertTrue(controller.getInventory().containsKey("TestSword1"));

        controller.equipWeaponToPlayer(controller.getInventory().get("TestStaff"),
                controller.getParty().get("TestKnight"));
        Assertions.assertNotEquals(ExpectedStaff,controller.getCharacterWeapon(controller.getParty().get("TestKnight")));
        Assertions.assertEquals(ExpectedSword2,controller.getCharacterWeapon(controller.getParty().get("TestKnight")));
        Assertions.assertFalse(controller.getInventory().containsKey("TestSword2"));
        Assertions.assertTrue(controller.getInventory().containsKey("TestStaff"));
    }
    @Test
    void TestGetters(){
        controller.createKnight("TestKnight",50,0,0);
        controller.createEnemy("TestEnemy",10,10,10,10);

        Assertions.assertEquals("TestKnight",controller.getName(controller.getParty().get("TestKnight")));
        Assertions.assertEquals("TestEnemy",controller.getName(controller.getEnemies().get("TestEnemy")));

        Assertions.assertEquals(0,controller.getAttack(controller.getParty().get("TestKnight")));
        Assertions.assertEquals(10,controller.getAttack(controller.getEnemies().get("TestEnemy")));

        Assertions.assertEquals(0,controller.getDefense(controller.getParty().get("TestKnight")));
        Assertions.assertEquals(10,controller.getDefense(controller.getEnemies().get("TestEnemy")));

        Assertions.assertEquals(10,controller.getEnemyWeight(controller.getEnemies().get("TestEnemy")));
    }


    @Test
    void TurnsTest() throws InterruptedException {
        controller = new Controller(1, 1);
        Assertions.assertEquals("Neither", controller.checkWin());
        controller.createKnight("TestKnight", 50, 0, 0);
        Knight ExpectedKnight = new Knight("TestKnight", turns, 40, 100, 0);
        Assertions.assertEquals(1, controller.getLivingPlayers());

        controller.createEnemy("TestEnemy", 10, 10, 10, 10);
        Enemy ExpectedEnemy = new Enemy("TestEnemy", 10, turns, 10, 10, 10);
        Assertions.assertEquals(1, controller.getLivingEnemies());

        controller.createSword("TestSword", 100, 20);
        controller.equipWeaponToPlayer(controller.getInventory().get("TestSword"),
                controller.getParty().get("TestKnight"));

        controller.startBattle();
        Thread.sleep(2100);
        controller.setActiveCharacter();
        Assertions.assertEquals(ExpectedEnemy, controller.getActiveCharacter());
        controller.attack(controller.getActiveCharacter(), controller.getParty().get("TestKnight"));
        Assertions.assertEquals("Neither", controller.checkWin());
        controller.setActiveCharacter();
        Assertions.assertEquals(ExpectedKnight, controller.getActiveCharacter());
        controller.attack(controller.getActiveCharacter(), controller.getEnemies().get("TestEnemy"));
        Assertions.assertEquals(0, controller.getHealthPoints(controller.getEnemies().get("TestEnemy")));
        Assertions.assertEquals("Player Wins", controller.checkWin());

        controller=new Controller(1,1);
        controller.createKnight("TestKnight",10,0,0);

        controller.createEnemy("TestEnemy",20,10,10,10);

        controller.createSword("TestSword",1,10);

        controller.equipWeaponToPlayer(controller.getInventory().get("TestSword"),
                controller.getParty().get("TestKnight"));

        controller.startBattle();
        Thread.sleep(2100);
        controller.setActiveCharacter();
        controller.attack(controller.getActiveCharacter(), controller.getEnemies().get("TestEnemy"));
        controller.setActiveCharacter();
        controller.attack(controller.getActiveCharacter(), controller.getParty().get("TestKnight"));
        Assertions.assertEquals("Monsters Wins",controller.checkWin());
    }
}
