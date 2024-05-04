package armour;

public class Platemail extends Armour {
  private int armourAmount = 250;
  private int dexterityCost = 200;
  private String armourType = "Platemail";

  public Platemail() {
    super();
    super.setArmourAmount(armourAmount);
    super.setDexterityCost(dexterityCost);
    super.setArmourType(armourType);
  } // constructor

  public int reduceDamage(int damageAmount) {
    return damageAmount - this.armourAmount / 2;
  }

} // class
