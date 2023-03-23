package itacademy.model.travel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import itacademy.common.utils.ListUtils;
import itacademy.model.items.Chair;
import itacademy.model.items.Freezer;
import itacademy.model.items.Item;
import itacademy.model.items.ItemNames;
import itacademy.model.items.Lighting;
import itacademy.model.items.Refrigerator;
import itacademy.model.items.SmartPhone;
import itacademy.model.items.WashingMachine;
import itacademy.model.trucks.BigTruck;
import itacademy.model.trucks.MediumTruck;
import itacademy.model.trucks.SmallTruck;
import itacademy.model.trucks.Truck;

public class SingleTravel {

  private static final boolean THERE_IS_ITEMS_TO_CARRY = true;
  private static final boolean THERE_IS_NO_ITEMS_TO_CARRY = false;

  private static final double INITIAL_WEIGHT = 0.0;

  private Setpoint setpoint;
  private List<Truck> trucks;
  private List<Item> initialItems;
  private List<Item> outputItems;
  private List<Item> finalItems;

  private double weight;
  private double price;

  public SingleTravel(Setpoint setpoint, List<Item> initialItems, List<Item> outputItems) {
    this.setpoint = setpoint;

    this.initialItems = initialItems;
    this.outputItems = outputItems;
    this.finalItems = this.calculateFinalItems();


    this.setWeight(this.calculateWeight());

    this.trucks = new ArrayList<>();
    this.trucks.addAll(this.calculateTrucks());

    this.setPrice(this.calculatePrice());
    System.out.println("source "+ this.setpoint.getSourceCity().getDeclaringClass());
  }

  public List<Truck> getTrucks() {
    return this.trucks;
  }

  public List<Item> getItems() {
    return this.initialItems;
  }

  public double getWeight() {
    return this.weight;
  }

  private double calculateWeight() {

    double totalWeight = initialItems.stream()
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

  public List<Item> calculateFinalItems() {
    List<Item> finalItems = new ArrayList<>();
    System.out.println("entrou");

    for (Item output : this.outputItems) {
      for (Item input : this.initialItems) {
        if (output.getName().equals(input.getName())) {
          switch (input.getName()) {
            case REFRIGERATOR:
              finalItems.add(new Refrigerator(input.getQuantity() - output.getQuantity()));
              break;
            case CHAIR:
              finalItems.add(new Chair(input.getQuantity() - output.getQuantity()));
              break;
            case FREEZER:
              finalItems.add(new Freezer(input.getQuantity() - output.getQuantity()));
              break;
            case LIGHTING:
              finalItems.add(new Lighting(input.getQuantity() - output.getQuantity()));
              break;
            case SMARTPHONE:
              finalItems.add(new SmartPhone(input.getQuantity() - output.getQuantity()));
              break;
            case WASHING_MACHINE:
              finalItems.add(new WashingMachine(input.getQuantity() - output.getQuantity()));
              break;
          }
        }
      }
    }

    System.out.println("initial items: " + initialItems);
    System.out.println("final items: " + finalItems);
    
    return finalItems;
  }

  //TODO: Improve calculate trucks
  public List<Truck> calculateTrucks() {
    List<Truck> trucks = new ArrayList<>();

    double leftWeight = this.weight;
    boolean isLeftItems = THERE_IS_ITEMS_TO_CARRY; 

    while (isLeftItems) {
      if (leftWeight <= SmallTruck.MAX_KG_LOAD_WEIGHT) {
        trucks.add(new SmallTruck());
        leftWeight -= SmallTruck.MAX_KG_LOAD_WEIGHT;

      } else if (leftWeight <= 2000) {
        this.trucks.addAll(Arrays.asList(
          new SmallTruck(),
          new SmallTruck()
        ));

        leftWeight -= SmallTruck.MAX_KG_LOAD_WEIGHT * 2;

      } else if (leftWeight <= MediumTruck.MAX_KG_LOAD_WEIGHT) {
        trucks.add(new MediumTruck());
        leftWeight -= MediumTruck.MAX_KG_LOAD_WEIGHT;

      } else if (leftWeight <= 6000) {
        this.trucks.addAll(Arrays.asList(
          new MediumTruck(),
          new SmallTruck()
        ));

        leftWeight -= MediumTruck.MAX_KG_LOAD_WEIGHT;
        leftWeight -= SmallTruck.MAX_KG_LOAD_WEIGHT;

      } else if (leftWeight <= 8000) {
        this.trucks.addAll(Arrays.asList(
          new MediumTruck(),
          new MediumTruck()
        ));

        leftWeight -= MediumTruck.MAX_KG_LOAD_WEIGHT * 2;

      } else {
        trucks.add(new BigTruck());
        leftWeight -= BigTruck.MAX_KG_LOAD_WEIGHT;
      }

      if (leftWeight <= 0) {
        isLeftItems = THERE_IS_NO_ITEMS_TO_CARRY;
      }
    }

    return trucks;
  }
}
