package itacademy.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import itacademy.common.utils.ListUtils;
import itacademy.model.cities.Setpoint;
import itacademy.model.items.Item;
import itacademy.model.trucks.MediumTruck;
import itacademy.model.trucks.SmallTruck;
import itacademy.model.trucks.Truck;

public class SingleTravel {
  private static final double INITIAL_WEIGHT = 0.0;

  private Setpoint setpoint;
  private List<Truck> trucks;
  private List<Item> items;

  private double weight;
  private double price;

  public SingleTravel(Setpoint setpoint, List<Item> items) {
    this.setpoint = setpoint;
    this.trucks = new ArrayList<>();
    this.items = items;

    trucks.addAll(Arrays.asList(
      new SmallTruck(),
      new MediumTruck()
    ));

    this.setWeight(this.calculateWeight());
    this.setPrice(this.calculatePrice());
  }

  public double getWeight() {
    return this.weight;
  }

  private double calculateWeight() {

    double totalWeight = items.stream()
      .map(item -> item.getTotalWeight())
      .reduce(INITIAL_WEIGHT, Double::sum);
    
    return totalWeight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public double getPrice() {
    return this.price;
  }

  private double calculatePrice() {
    return ListUtils.sum(this.getPricesList());
  }

  private List<Double> getPricesList() {
    List<Double> trucksPricePerKilometerList = trucks.stream()
      .map(truck -> truck.getPricePerKilometer())
      .collect(Collectors.toList());

    List<Double> pricesList = trucksPricePerKilometerList.stream()
      .map(truckPrice -> (truckPrice * this.setpoint.getDistance()))
      .collect(Collectors.toList());
    
    return pricesList;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
