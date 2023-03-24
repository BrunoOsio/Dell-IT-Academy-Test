package itacademy.model.items;

public class WashingMachine extends Item {
  private static final ItemNames NAME = ItemNames.WASHING_MACHINE;
  private static final double WEIGHT_KG = 120;

  public WashingMachine() {
    super(0);

    super.setName(NAME);
    super.setWeight(WEIGHT_KG);
  }

  public WashingMachine(int quantity) {
    super(quantity);

    super.setName(NAME);
    super.setWeight(WEIGHT_KG);
  }
}
