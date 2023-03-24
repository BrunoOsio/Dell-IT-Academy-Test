package itacademy.model.items;

public class Refrigerator extends Item {
  private static final ItemNames NAME = ItemNames.REFRIGERATOR;
  private static final double WEIGHT_KG = 60.0;

  public Refrigerator() {
    super(0);

    super.setName(NAME);
    super.setWeight(WEIGHT_KG);
  }

  public Refrigerator(int quantity) {
    super(quantity);

    super.setName(NAME);
    super.setWeight(WEIGHT_KG);
  }
}
