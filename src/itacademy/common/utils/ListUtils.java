package itacademy.common.utils;

import java.util.List;

public class ListUtils {

  public static double sum(List<Double> listOfDoubles) {
    return listOfDoubles.stream().mapToDouble(Double::doubleValue).sum();
  }
  
}
