package itacademy.model.trucks;

public class SmallTruck extends Truck {
  private static final double PRICE_BRL_PER_KILOMETER = 4.87;
  private static final double MAX_KG_LOAD_WEIGHT = 1000.0;

  public SmallTruck() {
    super();

    super.setPricePerKilometer(PRICE_BRL_PER_KILOMETER);
    super.setMaxLoadWeight(MAX_KG_LOAD_WEIGHT);
  }
}
