package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.Thief;
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
            new Thief(ENEMY_NAME, turns));
  }
  @Test
  void constructor2Test() {
    checkConstruction(new Enemy(ENEMY_NAME, 10, turns,10,4,5),
            testCharacters.get(1),
            new Enemy(ENEMY_NAME, 11, turns,10,4,5),
            new Thief(ENEMY_NAME, turns));
    checkConstruction(new Enemy(ENEMY_NAME, 10, turns,10,4,5),
            testCharacters.get(1),
            new Enemy(ENEMY_NAME, 10, turns,10,5,5),
            new Thief(ENEMY_NAME, turns));
    checkConstruction(new Enemy(ENEMY_NAME, 10, turns,10,4,5),
            testCharacters.get(1),
            new Enemy(ENEMY_NAME, 10, turns,10,4,6),
            new Thief(ENEMY_NAME, turns));
    checkConstruction(new Enemy(ENEMY_NAME, 10, turns,10,4,5),
            testCharacters.get(1),
            new Enemy(ENEMY_NAME, 10, turns,11,4,5),
            new Thief(ENEMY_NAME, turns));

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
  void AttackTest(){
    var player=new Knight("Resgat",turns,50,10,1);
    var enemy1=testCharacters.get(0);
    var enemy2=testCharacters.get(1);
    var enemy3=new Enemy(ENEMY_NAME,10,turns, 10,1,5);

    enemy1.attack(player);
    assertEquals(50,player.getHealthpoints());
    enemy2.attack(player);
    assertEquals(47,player.getHealthpoints());
    enemy3.attack(player);
    assertEquals(47,player.getHealthpoints());
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