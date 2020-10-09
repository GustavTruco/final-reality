package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Set of tests for the {@code GameCharacter} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 * @see PlayerCharacter
 */
class PlayerCharacterTest extends AbstractCharacterTest {

  protected List<PlayerCharacter> testCharacters;
  private static final String BLACK_MAGE_NAME = "Vivi";
  private static final String KNIGHT_NAME = "Adelbert";
  private static final String WHITE_MAGE_NAME = "Eiko";
  private static final String ENGINEER_NAME = "Cid";
  private static final String THIEF_NAME = "Zidane";
  private static int MAX_HP=100;
  private static int HP=10;
  private static int AT=5;
  private static int DEF=2;
  private Map<String, String> characterNames;

  /**
   * Setup method.
   * Creates a new character named Vivi with 10 speed and links it to a turn queue.
   */
  @BeforeEach
  void setUp() {
    super.basicSetUp();

    characterNames = new HashMap<String,String>();
    characterNames.put("BlackMage", BLACK_MAGE_NAME);
    characterNames.put("Knight", KNIGHT_NAME);
    characterNames.put("WhiteMage", WHITE_MAGE_NAME);
    characterNames.put("Engineer", ENGINEER_NAME);
    characterNames.put("Thief", THIEF_NAME);

    for (var characterClass :
        characterNames.keySet()) {
      testCharacters.add(
          new PlayerCharacter(characterNames.get(characterClass), turns, characterClass));
    }

    for (var characterClass : characterNames.keySet()){
      testCharacters.add(
              new PlayerCharacter(characterNames.get(characterClass), turns, characterClass,HP,AT,DEF));
    }
  }
}



  /**
   * Checks that the character waits the appropriate amount of time for it's turn.
   */

/**
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


  private void tryToEquip(ICharacter character) {
    character.equip(testWeapon);
  }

  /**
   * Checks that the class' constructor and equals method works properly.
 */
/**
@Test
void constructorTest() {
  var enemy = new Enemy("Enemy", 10, turns);
  int i =0;
  while(i<5){
    for (var character : testCharacters) {
      var characterClass = character.getCharacterClass();
      var characterName = characterNames.get(characterClass);
      var newClass="Thief";
      if (characterClass.equals("Thief")){ newClass="WhiteMage";}
      checkConstruction(new PlayerCharacter(characterName, turns, characterClass),
              character,
              new PlayerCharacter("Test", turns, characterClass), new PlayerCharacter(characterName,turns,newClass));
      assertNotEquals(character, enemy);
    }
  }
}
  @Test
  void equipWeaponTest() {
    for (var character :
        testCharacters) {
      assertNull(character.getEquippedWeapon());
      character.equip(testWeapon);
      assertEquals(testWeapon, character.getEquippedWeapon());
    }
  }
}
*/