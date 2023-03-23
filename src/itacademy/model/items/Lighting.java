package itacademy.model.items;

public class Lighting extends Item {
  private static final String NAME = "CADEIRA";
  private static final double WEIGHT_KG = 0.8;

  public Lighting(int quantity) {
    super(quantity);

    super.setName(NAME);
    super.setWeight(WEIGHT_KG);
  }
}
