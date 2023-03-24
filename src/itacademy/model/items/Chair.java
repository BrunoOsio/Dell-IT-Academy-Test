package itacademy.model.items;

public class Chair extends Item {
  private static final ItemNames NAME = ItemNames.CHAIR;
  private static final double WEIGHT_KG = 5.0;

  public Chair() {
    super(0);

    super.setName(NAME);
    super.setWeight(WEIGHT_KG);
  }

  public Chair(int quantity) {
    super(quantity);

    super.setName(NAME);
    super.setWeight(WEIGHT_KG);
  }
}
