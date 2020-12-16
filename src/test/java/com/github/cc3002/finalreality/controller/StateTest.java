package com.github.cc3002.finalreality.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StateTest {
    private Controller controller;

    @BeforeEach
    public void setUp(){
        controller=new Controller(5,5);
    }
    @Test
    public void TestTransitions(){
        Assertions.assertTrue(controller.isWaiting());
        Assertions.assertFalse(controller.isInTurn());
        Assertions.assertFalse(controller.isSelectingTarget());
        Assertions.assertFalse(controller.isInInventory());
        controller.playTurn();
        Assertions.assertFalse(controller.isWaiting());
        Assertions.assertTrue(controller.isInTurn());
        Assertions.assertFalse(controller.isSelectingTarget());
        Assertions.assertFalse(controller.isInInventory());
        controller.goToInventory();
        Assertions.assertFalse(controller.isWaiting());
        Assertions.assertFalse(controller.isInTurn());
        Assertions.assertFalse(controller.isSelectingTarget());
        Assertions.assertTrue(controller.isInInventory());
        controller.playTurn();
        Assertions.assertFalse(controller.isWaiting());
        Assertions.assertTrue(controller.isInTurn());
        Assertions.assertFalse(controller.isSelectingTarget());
        Assertions.assertFalse(controller.isInInventory());
        controller.selectTarget();
        Assertions.assertFalse(controller.isWaiting());
        Assertions.assertFalse(controller.isInTurn());
        Assertions.assertTrue(controller.isSelectingTarget());
        Assertions.assertFalse(controller.isInInventory());
        controller.playTurn();
        Assertions.assertFalse(controller.isWaiting());
        Assertions.assertTrue(controller.isInTurn());
        Assertions.assertFalse(controller.isSelectingTarget());
        Assertions.assertFalse(controller.isInInventory());
        controller.selectTarget();
        Assertions.assertFalse(controller.isWaiting());
        Assertions.assertFalse(controller.isInTurn());
        Assertions.assertTrue(controller.isSelectingTarget());
        Assertions.assertFalse(controller.isInInventory());
        controller.attacking();
        Assertions.assertTrue(controller.isWaiting());
        Assertions.assertFalse(controller.isInTurn());
        Assertions.assertFalse(controller.isSelectingTarget());
        Assertions.assertFalse(controller.isInInventory());
    };
}
