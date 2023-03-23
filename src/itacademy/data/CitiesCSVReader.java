package itacademy.data;

import static java.util.Objects.isNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CitiesCSVReader {

  private static final String LOCAL_PROJECT_DIRECTORY = System.getProperty("user.dir");
  private static final String PATH_TO_CSV = LOCAL_PROJECT_DIRECTORY.concat("\\src\\itacademy\\data");
  private static final String CSV_NAME = "dnit_distancias.csv";
  private static final String FULLPATH = String.format("\\%s\\%s", PATH_TO_CSV, CSV_NAME);
  private static final String CSV_SEPARATOR = ",";

  public static Integer getCitiesDistanceKilometers(Cities firstCity, Cities secondCity) {
    String currentRowData;
    int currentRowIndex = 0;
    Integer result = null;

    try {
      BufferedReader buffer = new BufferedReader(new FileReader(FULLPATH));
      skipHeaderLine(buffer);

      while ((currentRowData = buffer.readLine()) != null) {
        boolean isSourceCityRow = currentRowIndex == firstCity.get();

        if (isSourceCityRow) {
          String[] sourceCityData = currentRowData.split(CSV_SEPARATOR);

          result = Integer.parseInt(sourceCityData[secondCity.get()]);
          break;
        }
        
        currentRowIndex++;
      }

      buffer.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

    return result;
  }

  public static void skipHeaderLine(BufferedReader buffer) {
    try {
      buffer.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
