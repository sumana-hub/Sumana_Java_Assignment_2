package armour;

public class Leather extends Armour {
  private int armourAmount = 50;
  private int dexterityCost = 50;
  private String armourType = "Leather";

  public Leather() {
    super();
    super.setArmourAmount(armourAmount);
    super.setDexterityCost(dexterityCost);
    super.setArmourType(armourType);
  } // constructor

  public int reduceDamage(int damageAmount) {
    return damageAmount - this.armourAmount / 10;
  }

} // class
