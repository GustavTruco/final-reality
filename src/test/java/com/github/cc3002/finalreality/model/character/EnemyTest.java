package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnemyTest extends AbstractCharacterTest {

  private static final String ENEMY_NAME = "Goblin";
  protected List<Enemy> testCharacters;

  @BeforeEach
  void setUp() {
    basicSetUp();
    testCharacters= new ArrayList<>();
    testCharacters.add(new Enemy(ENEMY_NAME, 10, turns));
    testCharacters.add(new Enemy(ENEMY_NAME,10,turns, 10,4,5));
  }

  @Test
  void constructor1Test() {
    checkConstruction(new Enemy(ENEMY_NAME, 10, turns),
        testCharacters.get(0),
        new Enemy(ENEMY_NAME, 11, turns),
        new PlayerCharacter(ENEMY_NAME, turns, "Thief"));
  }
  @Test
  void constructor2Test() {
    checkConstruction(new Enemy(ENEMY_NAME, 10, turns,10,4,5),
            testCharacters.get(1),
            new Enemy(ENEMY_NAME, 11, turns,10,4,5),
            new PlayerCharacter(ENEMY_NAME, turns, "Thief"));
    checkConstruction(new Enemy(ENEMY_NAME, 10, turns,10,4,5),
            testCharacters.get(1),
            new Enemy(ENEMY_NAME, 10, turns,10,5,5),
            new PlayerCharacter(ENEMY_NAME, turns, "Thief"));
    checkConstruction(new Enemy(ENEMY_NAME, 10, turns,10,4,5),
            testCharacters.get(1),
            new Enemy(ENEMY_NAME, 10, turns,10,4,6),
            new PlayerCharacter(ENEMY_NAME, turns, "Thief"));

  }

  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
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