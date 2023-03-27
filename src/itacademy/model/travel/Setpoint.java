package itacademy.model.travel;

import itacademy.data.CitiesCSVReader;
import itacademy.model.cities.Cities;

/* Classe que armazena a cidade origem e a cidade destino de uma viagem */
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

  @Override
  public String toString() {
    return "Setpoint [sourceCity=" + sourceCity + ", destinationCity=" + destinationCity + ", distance=" + distance
        + "]";
  }

  
}
