package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Controller {
    private HashMap<String, IPlayerCharacter> playerParty;
    private HashMap<String, Enemy> enemies;
    private HashMap<String, Weapon> inventory;
    private BlockingQueue<ICharacter> turns;
    private int maxPartyNumber;
    private int maxEnemiesNumber;
    private int livingPlayers;
    private int livingEnemies;
    private final EnemyDeathHandler handler1= new EnemyDeathHandler(this);
    private final PlayerDeathHandler handler2= new PlayerDeathHandler(this);
    private ICharacter activeCharacter;

    /**
     * Creates a new Controller with a max number of Player Characters, and max number of Enemies
     * @param maxParty
     *       Max number of Player Characters
     * @param maxEnemies
     *       Max number of Enemies
     */
    public Controller(int maxParty,int maxEnemies){
        this.maxPartyNumber=maxParty;
        this.maxEnemiesNumber=maxEnemies;
        this.livingEnemies=0;
        this.livingPlayers=0;
        this.playerParty= new HashMap<>();
        this.enemies= new HashMap<>();
        this.inventory= new HashMap<>();
        this.turns= new LinkedBlockingQueue<>();

    }

    /**
     * Checks if either the player or the game won
     */
    public String checkWin(){
        if (livingEnemies==0 && livingPlayers!=0){
            return "Player Wins";
        }
        if (livingEnemies!=0 && livingPlayers==0){
            return "Monsters Wins";
        }
        return "Neither";
    }

    /**
     * Returns the number of livingPlayers
     */
    public int getLivingPlayers(){
        return livingPlayers;
    }

    /**
     * Returns the number of livingEnemies
     */
    public int getLivingEnemies(){
        return livingEnemies;
    }

    /**
     * Creates a new BlackMage Character and adds it to the Party HashMap, it needs all the
     * parameters to create a BlackMage object.
     * @param name
     *       The name of the Character
     * @param healthpoints
     *       The health point of the Character
     * @param attack
     *       The attack value of the Character
     * @param defense
     *       The defense value of the Character
     * @param mana
     *       The mana value of the Character
     * @param magicAttack
     *       The magic attack value of the Character
     */
    public void createBlackMage(@NotNull String name, int healthpoints,
                         int attack, int defense, int mana, int magicAttack){
        if (playerParty.size()<maxPartyNumber){
            BlackMage blackMage=new BlackMage(name, turns,healthpoints, attack,
                    defense,mana,magicAttack);
            blackMage.addListener(handler2);
            playerParty.put(name,blackMage);
            livingPlayers+=1;

        }
    }

    /**
     * Creates a new WhiteMage Character and adds it to the Party HashMap, it needs all the
     * parameters to create a WhiteMage object.
     * @param name
     *       The name of the Character
     * @param healthpoints
     *       The health point of the Character
     * @param attack
     *       The attack value of the Character
     * @param defense
     *       The defense value of the Character
     * @param mana
     *       The mana value of the Character
     * @param magicAttack
     *       The magic attack value of the Character
     */
    public void createWhiteMage(@NotNull String name, int healthpoints,
                         int attack, int defense, int mana, int magicAttack){
        if (playerParty.size()<maxPartyNumber){
            WhiteMage whiteMage=new WhiteMage(name, turns,healthpoints, attack,
                    defense,mana,magicAttack);
            whiteMage.addListener(handler2);
            playerParty.put(name,whiteMage);
            livingPlayers+=1;
        }
    }

    /**
     * Creates a new Engineer Character and adds it to the Party HashMap, it needs all the
     * parameters to create a Engineer object.
     * @param name
     *       The name of the Character
     * @param healthpoints
     *       The health point of the Character
     * @param attack
     *       The attack value of the Character
     * @param defense
     *       The defense value of the Character
     */
    public void createEngineer(@NotNull String name, int healthpoints, int attack, int defense){
        if (playerParty.size()<maxPartyNumber){
            Engineer engineer =new Engineer(name, turns,healthpoints, attack,
                    defense);
            engineer.addListener(handler2);
            playerParty.put(name,engineer);
            livingPlayers+=1;
        }
    }

    /**
     * Creates a new Thief Character and adds it to the Party HashMap, it needs all the
     * parameters to create a Thief object.
     * @param name
     *       The name of the Character
     * @param healthpoints
     *       The health point of the Character
     * @param attack
     *       The attack value of the Character
     * @param defense
     *       The defense value of the Character
     */
    public void createThief(@NotNull String name, int healthpoints, int attack, int defense){
        if (playerParty.size()<maxPartyNumber){
            Thief thief =new Thief(name, turns,healthpoints, attack,
                    defense);
            thief.addListener(handler2);
            playerParty.put(name,thief);
            livingPlayers+=1;
        }
    }

    /**
     * Creates a new Knight Character and adds it to the Party HashMap, it needs all the
     * parameters to create a Knight object.
     * @param name
     *       The name of the Character
     * @param healthpoints
     *       The health point of the Character
     * @param attack
     *       The attack value of the Character
     * @param defense
     *       The defense value of the Character
     */
    public void createKnight(@NotNull String name, int healthpoints, int attack, int defense){
        if (playerParty.size()<maxPartyNumber){
            Knight knight =new Knight(name, turns,healthpoints, attack,
                    defense);
            knight.addListener(handler2);
            playerParty.put(name,knight);
            livingPlayers+=1;
        }
    }

    /**
     * Creates a new Enemy and adds it to the Enemies HashMap, it needs all the
     * parameters to create a Enemy object.
     * @param name
     *       The name of the Enemy
     * @param weight
     *       The weight of the Enemy
     * @param healthpoints
     *       The health point of the Enemy
     * @param attack
     *       The attack value of the Enemy
     * @param defense
     *       The defense value of the Enemy
     */
    public void createEnemy(@NotNull final String name, final int weight, int healthpoints,int attack, int defense) {
        if (enemies.size()<maxEnemiesNumber) {
            Enemy enemy = new Enemy(name, weight, turns, healthpoints, attack, defense);
            enemy.addListener(handler1);
            enemies.put(name, enemy);
            livingEnemies += 1;
        }
    }

    /**
     * Creates a new Axe and adds it to the Inventory ready to be used, it needs all the
     * parameters to create a new Axe object
     * @param name
     *       The name of the Weapon
     * @param damage
     *       The damage value of the Weapon
     * @param weight
     *       The weight value of the Weapon
     */
    public void createAxe(final String name, final int damage, final int weight){
        Axe axe= new Axe(name,damage,weight);
        addToInventory(axe);
    }

    /**
     * Creates a new Bow and adds it to the Inventory ready to be used, it needs all the
     * parameters to create a new Bow object
     * @param name
     *       The name of the Weapon
     * @param damage
     *       The damage value of the Weapon
     * @param weight
     *       The weight value of the Weapon
     */
    public void createBow(final String name, final int damage, final int weight){
        Bow bow= new Bow(name,damage,weight);
        addToInventory(bow);
    }

    /**
     * Creates a new Knife and adds it to the Inventory ready to be used, it needs all the
     * parameters to create a new Knife object
     * @param name
     *       The name of the Weapon
     * @param damage
     *       The damage value of the Weapon
     * @param weight
     *       The weight value of the Weapon
     */
    public void createKnife(final String name, final int damage, final int weight){
        Knife knife= new Knife(name,damage,weight);
        addToInventory(knife);
    }

    /**
     * Creates a new Sword and adds it to the Inventory ready to be used, it needs all the
     * parameters to create a new Sword object
     * @param name
     *       The name of the Weapon
     * @param damage
     *       The damage value of the Weapon
     * @param weight
     *       The weight value of the Weapon
     */
    public void createSword(final String name, final int damage, final int weight){
        Sword sword= new Sword(name,damage,weight);
        addToInventory(sword);
    }

    /**
     * Creates a new Staff and adds it to the Inventory ready to be used, it needs all the
     * parameters to create a new Staff object
     * @param name
     *       The name of the Weapon
     * @param damage
     *       The damage value of the Weapon
     * @param weight
     *       The weight value of the Weapon
     */
    public void createStaff(final String name, final int damage, final int weight,int magicDamage){
        Staff staff= new  Staff(name,damage,weight,magicDamage);
        addToInventory(staff);
    }

    /**
     * Returns the Name of a Character
     * @param character
     *       The Character from we will get the data
     */
    public String getName(ICharacter character){
        return character.getName();
    }

    /**
     * Returns the Health Points of a Character
     * @param character
     *       The Character from we will get the data
     */
    public int getHealthPoints(ICharacter character){
        return character.getHealthpoints();
    }

    /**
     * Returns the Attack of a Character
     * @param character
     *       The Character from we will get the data
     */
    public int getAttack(ICharacter character){
        return character.getAttack();
    }

    /**
     * Returns the Defense of a Character
     * @param character
     *       The Character from we will get the data
     */
    public int getDefense(ICharacter character){
        return character.getDefense();
    }

    /**
     * Returns the Weight of an Enemy
     * @param enemy
     *       The Enemy from we will get the data
     */
    public int getEnemyWeight(Enemy enemy){
        return enemy.getWeight();
    }

    /**
     * Returns the Weapon equipped to a Player Character
     * @param playerCharacter
     *       The Character from we will get the data
     */
    public Weapon getCharacterWeapon(IPlayerCharacter playerCharacter){
        return playerCharacter.getEquippedWeapon();
    }

    /**
     * Returns the Mana value of a Mage
     * @param mage
     *       The Character from we will get the data
     */
    public int getMana(AbstractMages mage){
        return mage.getMana();
    }

    /**
     * Returns the Magick Attack value of a Mage
     * @param mage
     *       The Character from we will get the data
     */
    public int getMagickAttack(AbstractMages mage){
        return mage.getMagicAttack();
    }

    /**
     * Returns the inventory of the Controller
     */
    public HashMap<String, Weapon> getInventory(){
        return inventory;
    }

    /**
     * Returns the Party of Player Characters of the Controller
     */
    public HashMap<String, IPlayerCharacter> getParty(){
        return playerParty;
    }

    /**
     * Returns the Enemies available on the Controller
     */
    public HashMap<String, Enemy> getEnemies(){
        return enemies;
    }

    /**
     * Returns the turns list
     */
    public BlockingQueue<ICharacter> getTurns() {
        return turns;
    }

    /**
     * Adds a Weapon to the Inventory
     * @param weapon
     *       The Weapon to be added
     */
    public void addToInventory(Weapon weapon){
        inventory.put(weapon.getName(), weapon);
    }

    /**
     * Removes a Weapon from the Inventory
     * @param weapon
     *       The Weapon to be removed
     */
    public void removeFromInventory(Weapon weapon){
        inventory.remove(weapon.getName());
    }

    /**
     * Equips a Weapon from the Inventory to a Player's Character, if the
     * Character had an equipped Weapon it will be added to the Inventory
     * @param weapon
     *       The Weapon to equipped
     * @param character
     *       The Character that will get the Weapon
     */
    public void equipWeaponToPlayer(Weapon weapon, IPlayerCharacter character){
        Weapon oldWeapon= getCharacterWeapon(character);
        character.equip(weapon);
        if (oldWeapon!=null){
            if (!getCharacterWeapon(character).equals(oldWeapon)){
                addToInventory(oldWeapon);
            }
        }
        if (!getCharacterWeapon(character).equals(oldWeapon)) {
            removeFromInventory(weapon);
        }
    }

    /**
     * Reduces the number of living Enemies
     */
    public void enemyDied(){
        livingEnemies = livingEnemies - 1;

    }

    /**
     * Reduces the number of living Players
     */
    public void playerDied(){
        livingPlayers=livingPlayers-1;
    }

    /**
     * Starts the battle adding all Characters to the turns Queue
     */
    public void startBattle(){
        for (IPlayerCharacter character : playerParty.values()) {
            character.waitTurn();
        }
        for (Enemy enemy : enemies.values()) {
            enemy.waitTurn();
        }
    }

    /**
     * Pull the first object of the Turns Queue and set its as our active Character, this means it its turn
     */

    public void setActiveCharacter(){
        activeCharacter=turns.poll();
    }

    /**
     * Returns the active Character
     */

    public ICharacter getActiveCharacter(){
        return activeCharacter;
    }

    /**
     * Implements the attack between Characters, the first will attack the second,
     * and starts the timer of the attacker Character to be added to the Turns Queue
     * @param attacker
     *       The Character that is attacking
     * @param defender
     *       The Character that will be attacked
     */
    public void attack(ICharacter attacker, ICharacter defender){
        attacker.attack(defender);
        attacker.waitTurn();
    }

}
