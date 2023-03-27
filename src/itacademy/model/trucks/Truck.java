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

  public static Truck getByIndex(int index) {
    Truck truck = null;

    switch(index) {
      case 1:
        truck = new SmallTruck();
        break;
      case 2: 
        truck = new MediumTruck();
        break;
      case 3:
        truck = new BigTruck();
        break;
    }

    return truck;
  }

  @Override
  public String toString() {
    return "Truck [maxLoadWeight=" + maxLoadWeight + "]\n";
  }
}
