package itacademy;

import itacademy.model.cities.Cities;
import itacademy.model.items.Item;
import itacademy.model.items.Refrigerator;
import itacademy.model.items.SmartPhone;
import itacademy.model.travel.Setpoint;
import itacademy.model.travel.SingleTravel;

import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    
    List<Item> listOfItemsOne = Arrays.asList(
      new SmartPhone(2),
      new Refrigerator(260)
    );

    List<Item> listOfOutputItemsOne = Arrays.asList(
      new SmartPhone(2),
      new Refrigerator(130)
    );

    Setpoint setpointOne = new Setpoint(Cities.ARACAJU, Cities.BELEM);

    SingleTravel singleTravelOne = new SingleTravel(setpointOne, listOfItemsOne, listOfOutputItemsOne);
  }
}
