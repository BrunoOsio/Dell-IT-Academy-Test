package itacademy.model.items;

public class Freezer extends Item {
  private static final ItemNames NAME = ItemNames.FREEZER;
  private static final double WEIGHT_KG = 100.0;

  public Freezer() {
    super(0);

    super.setName(NAME);
    super.setWeight(WEIGHT_KG);
  }

  public Freezer(int quantity) {
    super(quantity);

    super.setName(NAME);
    super.setWeight(WEIGHT_KG);
  }
}
