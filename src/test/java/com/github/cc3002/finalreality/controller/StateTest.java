package com.github.cc3002.finalreality.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StateTest {
    private Controller controller;

    @BeforeEach
    public void setUp(){
        controller=new Controller();
    }
    @Test
    public void TestTransitions(){
        Assertions.assertTrue(controller.isConfig());
        Assertions.assertFalse(controller.isWaiting());
        Assertions.assertFalse(controller.isInTurn());
        Assertions.assertFalse(controller.isSelectingTarget());
        Assertions.assertFalse(controller.isInInventory());
        Assertions.assertFalse(controller.isEnd());
        controller.startGame();
        Assertions.assertFalse(controller.isConfig());
        Assertions.assertTrue(controller.isWaiting());
        Assertions.assertFalse(controller.isInTurn());
        Assertions.assertFalse(controller.isSelectingTarget());
        Assertions.assertFalse(controller.isInInventory());
        Assertions.assertFalse(controller.isEnd());
        controller.playTurn();
        Assertions.assertFalse(controller.isConfig());
        Assertions.assertFalse(controller.isWaiting());
        Assertions.assertTrue(controller.isInTurn());
        Assertions.assertFalse(controller.isSelectingTarget());
        Assertions.assertFalse(controller.isInInventory());
        Assertions.assertFalse(controller.isEnd());
        controller.goToInventory();
        Assertions.assertFalse(controller.isConfig());
        Assertions.assertFalse(controller.isWaiting());
        Assertions.assertFalse(controller.isInTurn());
        Assertions.assertFalse(controller.isSelectingTarget());
        Assertions.assertTrue(controller.isInInventory());
        Assertions.assertFalse(controller.isEnd());
        controller.playTurn();
        Assertions.assertFalse(controller.isConfig());
        Assertions.assertFalse(controller.isWaiting());
        Assertions.assertTrue(controller.isInTurn());
        Assertions.assertFalse(controller.isSelectingTarget());
        Assertions.assertFalse(controller.isInInventory());
        Assertions.assertFalse(controller.isEnd());
        controller.selectTarget();
        Assertions.assertFalse(controller.isConfig());
        Assertions.assertFalse(controller.isWaiting());
        Assertions.assertFalse(controller.isInTurn());
        Assertions.assertTrue(controller.isSelectingTarget());
        Assertions.assertFalse(controller.isInInventory());
        Assertions.assertFalse(controller.isEnd());
        controller.playTurn();
        Assertions.assertFalse(controller.isConfig());
        Assertions.assertFalse(controller.isWaiting());
        Assertions.assertTrue(controller.isInTurn());
        Assertions.assertFalse(controller.isSelectingTarget());
        Assertions.assertFalse(controller.isInInventory());
        Assertions.assertFalse(controller.isEnd());
        controller.selectTarget();
        Assertions.assertFalse(controller.isConfig());
        Assertions.assertFalse(controller.isWaiting());
        Assertions.assertFalse(controller.isInTurn());
        Assertions.assertTrue(controller.isSelectingTarget());
        Assertions.assertFalse(controller.isInInventory());
        Assertions.assertFalse(controller.isEnd());
        controller.attacking();
        Assertions.assertFalse(controller.isConfig());
        Assertions.assertTrue(controller.isWaiting());
        Assertions.assertFalse(controller.isInTurn());
        Assertions.assertFalse(controller.isSelectingTarget());
        Assertions.assertFalse(controller.isInInventory());
        Assertions.assertFalse(controller.isEnd());
        controller.ended();
        Assertions.assertFalse(controller.isConfig());
        Assertions.assertFalse(controller.isWaiting());
        Assertions.assertFalse(controller.isInTurn());
        Assertions.assertFalse(controller.isSelectingTarget());
        Assertions.assertFalse(controller.isInInventory());
        Assertions.assertTrue(controller.isEnd());
        controller.replay();
        Assertions.assertTrue(controller.isConfig());
        Assertions.assertFalse(controller.isWaiting());
        Assertions.assertFalse(controller.isInTurn());
        Assertions.assertFalse(controller.isSelectingTarget());
        Assertions.assertFalse(controller.isInInventory());
        Assertions.assertFalse(controller.isEnd());
    };
}
