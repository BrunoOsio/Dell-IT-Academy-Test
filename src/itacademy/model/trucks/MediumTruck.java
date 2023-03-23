package itacademy.model.trucks;

public class MediumTruck extends Truck {
  private static final double PRICE_BRL_PER_KILOMETER = 11.92;
  private static final double MAX_KG_LOAD_WEIGHT = 4000.0;

  public MediumTruck() {
    super();

    super.setPricePerKilometer(PRICE_BRL_PER_KILOMETER);
    super.setMaxLoadWeight(MAX_KG_LOAD_WEIGHT);
  }
}
