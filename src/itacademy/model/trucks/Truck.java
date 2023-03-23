package itacademy.model.trucks;

public abstract class Truck {
  private double maxLoadWeight;
  private double pricePerKilometer;

  public Truck() {}

  public double getMaxLoadWeight() {
    return maxLoadWeight;
  }
  public void setMaxLoadWeight(double maxLoadWeight) {
    this.maxLoadWeight = maxLoadWeight;
  }
  public double getPricePerKilometer() {
    return pricePerKilometer;
  }
  public void setPricePerKilometer(double pricePerKilometer) {
    this.pricePerKilometer = pricePerKilometer;
  }
}
