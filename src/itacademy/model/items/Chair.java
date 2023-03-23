package itacademy.model.items;

public class Chair extends Item {
  private static final String NAME = "CADEIRA";
  private static final double WEIGHT_KG = 5.0;

  public Chair(int quantity) {
    super(quantity);

    super.setName(NAME);
    super.setWeight(WEIGHT_KG);
  }
}
