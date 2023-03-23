package itacademy.model.trucks;

public class BigTruck extends Truck {
  private static final double PRICE_BRL_PER_KILOMETER = 27.44;
  public static final double MAX_KG_LOAD_WEIGHT = 10000.0;

  public BigTruck() {
    super();

    super.setPricePerKilometer(PRICE_BRL_PER_KILOMETER);
    super.setMaxLoadWeight(MAX_KG_LOAD_WEIGHT);
  }
}
