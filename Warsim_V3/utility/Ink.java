package utility;

import warrior.Warrior;

public class Ink {

  public Ink() {
    // do nothing
  } // contructor

  // Welcome Message
  public void welcomeMessage() {
    System.out.println("""
          __        __             _             ____   ___ ____  _  _
          \\ \\      / /_ _ _ __ ___(_)_ __ ___   |___ \\ / _ \\___ \\| || |
           \\ \\ /\\ / / _` | '__/ __| | '_ ` _ \\    __) | | | |__) | || |_
            \\ V  V / (_| | |  \\__ \\ | | | | | |  / __/| |_| / __/|__   _|
             \\_/\\_/ \\__,_|_|  |___/_|_| |_| |_| |_____|\\___/_____|  |_|
        """);
  }

  public void printWarriorMenu() {
    System.out.println("""
        Choose your
        __        __              _
        \\ \\      / /_ _ _ __ _ __(_) ___  _ __
         \\ \\ /\\ / / _` | '__| '__| |/ _ \\| '__|
          \\ V  V / (_| | |  | |  | | (_) | |
           \\_/\\_/ \\__,_|_|  |_|  |_|\\___/|_|

        1. Human
        2. Elf
        3. Orc

        Enter your choice: 
        """);
  }

  public void printWeaponMenu() {
    System.out.println("""
        Choose your
        __        __
          \\ \\      / /__  __ _ _ __   ___  _ __
           \\ \\ /\\ / / _ \\/ _` | '_ \\ / _ \\| '_ \\
            \\ V  V /  __/ (_| | |_) | (_) | | | |
             \\_/\\_/ \\___|\\__,_| .__/ \\___/|_| |_|
                              |_|

        1. Dagger
        2. Sword
        3. Axe

        Enter your choice: 
        """);
  }

  public void printArmourMenu() {
    System.out.println("""
      Choose your
           _
           / \\   _ __ _ __ ___   ___  _   _ _ __
          / _ \\ | '__| '_ ` _ \\ / _ \\| | | | '__|
         / ___ \\| |  | | | | | | (_) | |_| | |
        /_/   \\_\\_|  |_| |_| |_|\\___/ \\__,_|_|

        1. Leather
        2. Chainmail
        3. Platemail

        Enter your choice: 
        """);
  }

  public void printAttackMenu() {
    System.out.println("""
      Choose your
           _   _   _             _      _____
           / \\ | |_| |_ __ _  ___| | __ |_   _|   _ _ __   ___
          / _ \\| __| __/ _` |/ __| |/ /   | || | | | '_ \\ / _ \\
         / ___ \\ |_| || (_| | (__|   <    | || |_| | |_) |  __/
        /_/   \\_\\__|\\__\\__,_|\\___|_|\\_\\   |_| \\__, | .__/ \\___|
                                              |___/|_|

        1. Quick Attack
        2. Normal Attack
        3. Heavy Attack

        Enter your choice: 
        """);
  }

  // Print Stats
  public void printStats(Warrior pWarrior, Warrior eWarrior, int pDamage, int eDamage) {
    System.out.println("+----------------------------------------+");
    System.out.printf("| %-20s (%s)          |\n", "Player:", pWarrior.getWarriorType());
    System.out.printf("| %-20s %-10d |\n", "Health:", pWarrior.getHealth());
    System.out.printf("| %-20s %-10d |\n", "Strength:", pWarrior.getStrength());
    System.out.printf("| %-20s %-10d |\n", "Dexterity:", pWarrior.getDexterity());
    System.out.printf("| %-20s %-10s |\n", "Damage:", pDamage > 0 ? String.valueOf(pDamage) : "-");
    System.out.println("|                                        |");
    System.out.printf("| %-20s (%s)          |\n", "Enemy:", eWarrior.getWarriorType());
    System.out.printf("| %-20s %-10d |\n", "Health:", eWarrior.getHealth());
    System.out.printf("| %-20s %-10d |\n", "Strength:", eWarrior.getStrength());
    System.out.printf("| %-20s %-10d |\n", "Dexterity:", eWarrior.getDexterity());
    System.out.printf("| %-20s %-10s |\n", "Damage:", eDamage > 0 ? String.valueOf(eDamage) : "-");
    System.out.println("+----------------------------------------+");
  }// printStats()

  // GameOver Message
  public void printGameOver(String winner) {
    System.out.printf("""
              __ __
           .-',,^,,'.
          / \\(0)(0)/ \\
          )/( ,_"_,)\\(
          `  >-`~(   '
        _N\\ |(`\\ |___
        \\' |/ \\ \\/_-,)
         '.(  \\`\\_<
            \\ _\\|
             | |_\\_
             \\_,_>-'
         winner: %s
             """, winner);
  } // printGameOver()

} // class