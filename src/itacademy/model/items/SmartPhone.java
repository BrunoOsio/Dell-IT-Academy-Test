package itacademy.model.items;

public class SmartPhone extends Item {
  private static final ItemNames NAME = ItemNames.SMARTPHONE;
  private static final double WEIGHT_KG = 0.5;

  public SmartPhone() {
    super(0);

    super.setName(NAME);
    super.setWeight(WEIGHT_KG);
  }

  public SmartPhone(int quantity) {
    super(quantity);

    super.setName(NAME);
    super.setWeight(WEIGHT_KG);
  }
}
