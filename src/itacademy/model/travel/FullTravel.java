package itacademy.model.travel;

import java.util.List;
import java.util.stream.Collectors;

public class FullTravel {
  private List<SingleTravel> travels;

  public FullTravel(List<SingleTravel> travels) {
    this.travels = travels;
  }

  public double getDistance() {
    double distance = travels.stream()
      .map(travel -> travel.getDistance())
      .mapToDouble(Double::doubleValue)
      .sum();

    return distance;
  }

  public List<SingleTravel> getTravels() {
    return this.travels;
  }

  public double getPrice() {
    double price = travels.stream()
      .map(travel -> travel.getPrice())
      .mapToDouble(Double::doubleValue)
      .sum();

    return price;
  }

  @Override
  public String toString() {
    return "FullTravel [travels=" + travels + "]";
  }

}
