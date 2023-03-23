package itacademy.model.items;

public class SmartPhone extends Item {
  private static final String NAME = "CELULAR";
  private static final double WEIGHT_KG = 0.5;

  public SmartPhone(int quantity) {
    super(quantity);

    super.setName(NAME);
    super.setWeight(WEIGHT_KG);
  }
}
