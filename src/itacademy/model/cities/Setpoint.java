package itacademy.model.cities;

import itacademy.data.CitiesCSVReader;

public class Setpoint {
  private Cities sourceCity;
  private Cities destinationCity;
  private double distance;

  public Setpoint(Cities sourceCity, Cities destinationCity) {
    this.sourceCity = sourceCity;
    this.destinationCity = destinationCity;

    this.distance = CitiesCSVReader.getCitiesDistanceKilometers(sourceCity, destinationCity);
  }

  public Cities getSourceCity() {
    return sourceCity;
  }

  public void setSourceCity(Cities sourceCity) {
    this.sourceCity = sourceCity;
  }

  public Cities getDestinationCity() {
    return destinationCity;
  }

  public void setDestinationCity(Cities destinationCity) {
    this.destinationCity = destinationCity;
  }

  public double getDistance() {
    return this.distance;
  }
}
