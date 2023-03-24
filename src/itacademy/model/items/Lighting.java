package itacademy.model.items;

public class Lighting extends Item {
  private static final ItemNames NAME = ItemNames.LIGHTING;
  private static final double WEIGHT_KG = 0.8;

  public Lighting() {
    super(0);

    super.setName(NAME);
    super.setWeight(WEIGHT_KG);
  }

  public Lighting(int quantity) {
    super(quantity);

    super.setName(NAME);
    super.setWeight(WEIGHT_KG);
  }
}
