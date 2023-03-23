package itacademy;

import itacademy.data.CitiesCSVReader;
import itacademy.data.Cities;

public class Main {

  public static void main(String[] args) {
    System.out.println(CitiesCSVReader.getCitiesDistanceMeters(Cities.ARACAJU, Cities.FLORIANOPOLIS));
  }
}
