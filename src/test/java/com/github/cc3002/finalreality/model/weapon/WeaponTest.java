package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;

class WeaponTest {
  protected BlockingQueue<ICharacter> turns;

  private static final String AXE_NAME = "Test Axe";
  private static final String STAFF_NAME = "Test Staff";
  private static final String SWORD_NAME = "Test Sword";
  private static final String BOW_NAME = "Test Bow";
  private static final String KNIFE_NAME = "Test Knife";
  private static final int DAMAGE = 15;
  private static final int SPEED = 10;
  private static final int MAGIC_DAMAGE=10;

  private Weapon testAxe;
  private Weapon testStaff;
  private Weapon testSword;
  private Weapon testBow;
  private Weapon testKnife;

  @BeforeEach
  void setUp() {
    testAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
    testStaff = new Staff(STAFF_NAME, DAMAGE, SPEED,MAGIC_DAMAGE);
    testSword = new Sword(SWORD_NAME, DAMAGE, SPEED);
    testBow = new Bow(BOW_NAME, DAMAGE, SPEED);
    testKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED);
  }

  @Test
  void constructorTest() {
    var expectedAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
    var unexpectedAxe1= new Axe("test",DAMAGE,SPEED);
    var unexpectedAxe2= new Axe(AXE_NAME,DAMAGE+1,SPEED);
    var unexpectedAxe3= new Axe(AXE_NAME,DAMAGE,SPEED+1);
    assertEquals(testAxe,testAxe);
    assertEquals(expectedAxe, testAxe);
    assertEquals(expectedAxe.hashCode(), testAxe.hashCode());
    assertNotEquals(unexpectedAxe1,testAxe);
    assertNotEquals(unexpectedAxe1.hashCode(),testAxe.hashCode());
    assertNotEquals(unexpectedAxe2,testAxe);
    assertNotEquals(unexpectedAxe2.hashCode(),testAxe.hashCode());
    assertNotEquals(unexpectedAxe3,testAxe);
    assertNotEquals(unexpectedAxe3.hashCode(),testAxe.hashCode());

    var expectedStaff = new Staff(STAFF_NAME, DAMAGE, SPEED, MAGIC_DAMAGE);
    var unexpectedStaff1= new Staff(STAFF_NAME,DAMAGE,SPEED,MAGIC_DAMAGE+1);
    assertEquals(expectedStaff, testStaff);
    assertEquals(expectedStaff.hashCode(), testStaff.hashCode());
    assertNotEquals(unexpectedStaff1,testStaff);
    assertNotEquals(unexpectedStaff1.hashCode(),testStaff.hashCode());

    var expectedSword = new Sword(SWORD_NAME, DAMAGE, SPEED);
    assertEquals(expectedSword, testSword);
    assertEquals(expectedSword.hashCode(), testSword.hashCode());

    var expectedBow = new Bow(BOW_NAME, DAMAGE, SPEED);
    assertEquals(expectedBow, testBow);
    assertEquals(expectedBow.hashCode(), testBow.hashCode());

    var expectedKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED);
    assertEquals(expectedKnife, testKnife);
    assertEquals(expectedKnife.hashCode(), testKnife.hashCode());

    assertNotEquals(new Knight("test_knight",turns),testAxe);
    assertNotEquals(testAxe,new Knight("test_knight",turns));

    var trickyAxe= new Axe(SWORD_NAME,DAMAGE,SPEED);
    assertNotEquals(trickyAxe,testSword);
  }
}