package com.github.cc3002.finalreality.model;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
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
    }

}
