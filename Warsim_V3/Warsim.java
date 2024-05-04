import warrior.*;
import weapon.*;
import armour.*;
import weather.*;
import utility.*;

import java.util.Scanner;
import java.util.Random;

public class Warsim {

  // Objects
  public static Scanner input = new Scanner(System.in);
  public static Random randNum = new Random();
  public static Ink ink = new Ink();
  public static Weather weather;

  // Player Objects
  public static Warrior player; // player
  public static Weapon pWeapon; // player weapon
  public static Armour pArmour; // player armour

  // Enemy Objects
  public static Warrior enemy; // enemy
  public static Weapon eWeapon; // enemy weapon
  public static Armour eArmour; // enemy armour

  // Variables
  public static boolean gameOver = false;
  public static boolean playerTurn = true;
  public static int choice = 0;
  public static int attackType = 0;
  public static int damage = 0;
  public static String who = "Player";
  public static String winner = "";

  public static void main(String[] args) {
    ink.welcomeMessage();

    // set a random weather for the battle
    int weatherType = randNum.nextInt(4) + 1;
    createWeather(weatherType);

    // ====================>>
    // Player Setup
    // Warrior
    ink.printWarriorMenu();
    int choice = input.nextInt(); // 1, 2 or 3
    createWarrior(who, choice);

    // Weapon
    ink.printWeaponMenu();
    choice = input.nextInt(); // 1, 2 or 3
    createWeapon(who, choice);

    // Armour
    ink.printArmourMenu();
    choice = input.nextInt(); // 1, 2 or 3
    createArmour(who, choice);

    who = "Enemy"; // swap the who with the what

    // ====================>>
    // Enemy Setup
    // Warrior
    choice = randNum.nextInt(3) + 1;
    createWarrior(who, choice);

    // Weapon
    choice = randNum.nextInt(3) + 1;
    createWeapon(who, choice);

    // Armour
    choice = randNum.nextInt(3) + 1;
    createArmour(who, choice);

    ink.printStats(player, enemy, 0, 0);

    // main game loop
    while (!gameOver) { // while the game is NOT over
      if (playerTurn) {
        ink.printAttackMenu();
        attackType = input.nextInt();
        damage = pWeapon.strike(weather.getSeverity(), attackType, player.getStrength(), player.getDexterity());
        damage = eArmour.reduceDamage(damage);
        enemy.takeDamage(damage);
        if (!enemy.isAlive()) {
          winner = "Player";
          gameOver = !gameOver;
        }
      } else { // enemy turn code
        System.out.println("Enemy Turn!");
        attackType = randNum.nextInt(3) + 1;
        damage = eWeapon.strike(weather.getSeverity(), attackType, enemy.getStrength(), enemy.getDexterity());
        damage = pArmour.reduceDamage(damage);
        player.takeDamage(damage);
        if (!player.isAlive()) {
          winner = "Enemy";
          gameOver = !gameOver;
        }
      }
      ink.printStats(player, enemy, playerTurn ? damage : 0, playerTurn ? 0 : damage); // Print stats after each turn
      playerTurn = !playerTurn; // toggle turns
      System.out.println(playerTurn ? "Player's Turn" : "Enemy's Turn");
    } // while()

    ink.printGameOver(winner);
  } // main()

  // Helper Methods
  public static void createWarrior(String who, int choice) {
    if (who.equals("Player")) {
      switch (choice) {
        case 1: // Human
          player = new Human("Human");
          break;
        case 2: // Elf
          player = new Elf("Elf");
          break;
        case 3: // Orc
          player = new Orc("Orc");
          break;
        default:
          System.out.println("oops!");
          break;
      } // switch
    } else {
      switch (choice) {
        case 1: // Human
          enemy = new Human("Human");
          break;
        case 2: // Elf
          enemy = new Elf("Elf");
          break;
        case 3: // Orc
          enemy = new Orc("Orc");
          break;
        default:
          System.out.println("oops!");
          break;
      } // switch
    }
  } // createWarrior()

  public static void createWeapon(String who, int choice) {
    switch (choice) {
      case 1: // Dagger
        if (who.equals("Player")) {
          pWeapon = new Dagger();
        } else {
          eWeapon = new Dagger();
        }
        break;
      case 2: // Sword
        if (who.equals("Player")) {
          pWeapon = new Sword();
        } else {
          eWeapon = new Sword();
        }
        break;
      case 3: // Axe
        if (who.equals("Player")) {
          pWeapon = new Axe();
        } else {
          eWeapon = new Axe();
        }
        break;
      default:
        System.out.println("oops!");
        break;
    } // switch
  } // createWeapon()

  public static void createArmour(String who, int choice) {
    switch (choice) {
      case 1: // Leather
        if (who.equals("Player")) {
          pArmour = new Leather();
        } else {
          eArmour = new Leather();
        }
        break;
      case 2: // Chainmail
        if (who.equals("Player")) {
          pArmour = new Chainmail();
        } else {
          eArmour = new Chainmail();
        }
        break;
      case 3: // Platemail
        if (who.equals("Player")) {
          pArmour = new Platemail();
        } else {
          eArmour = new Platemail();
        }
        break;
      default:
        System.out.println("oops!");
        break;
    } // switch
  } // createArmour()

  public static void createWeather(int weatherType) {
    switch (weatherType) {
      case 1: // sun
        weather = new Sun();
        break;
      case 2: // rain
        weather = new Rain();
        break;
      case 3: // wind
        weather = new Wind();
        break;
      case 4: // storm
        weather = new Storm();
        break;
      default:
        System.out.println("Run!! Godzilla!!!");
        break;
    } // switch
  } // createWeather()
} // class