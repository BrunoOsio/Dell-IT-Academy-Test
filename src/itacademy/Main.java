package itacademy;

import itacademy.data.CitiesCSVReader;
import itacademy.model.SingleTravel;
import itacademy.model.cities.Cities;
import itacademy.model.cities.Setpoint;
import itacademy.model.items.Item;
import itacademy.model.items.Refrigerator;
import itacademy.model.items.SmartPhone;
import itacademy.model.trucks.SmallTruck;
import itacademy.model.trucks.Truck;

import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    
    List<Item> listOfItemsOne = Arrays.asList(
      new SmartPhone(2),
      new Refrigerator(5)
    );

    Setpoint setpointOne = new Setpoint(Cities.ARACAJU, Cities.BELEM);

    SingleTravel singleTravelOne = new SingleTravel(setpointOne, listOfItemsOne);
    
    System.out.println("Preco da primeira viagem " + singleTravelOne.getPrice());
    System.out.println("Peso da primeira viagem " + singleTravelOne.getWeight());
  }
}
