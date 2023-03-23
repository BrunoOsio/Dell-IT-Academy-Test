package itacademy.model.items;

public class Refrigerator extends Item {
  private static final String NAME = "GELADEIRA";
  private static final double WEIGHT_KG = 60.0;

  public Refrigerator(int quantity) {
    super(quantity);

    super.setName(NAME);
    super.setWeight(WEIGHT_KG);
  }
}