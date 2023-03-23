package itacademy.model.items;

public class WashingMachine extends Item {
  private static final String NAME = "MÁQUINA DE LAVAR ROUPA";
  private static final double WEIGHT_KG = 120;

  public WashingMachine(int quantity) {
    super(quantity);

    super.setName(NAME);
    super.setWeight(WEIGHT_KG);
  }
}
