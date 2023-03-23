package itacademy.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CitiesCSVReader {

    private static final String LOCAL_PROJECT_DIRECTORY = System.getProperty("user.dir");
    private static final String PATH_TO_CSV = LOCAL_PROJECT_DIRECTORY.concat("\\src\\itacademy\\data");
    private static final String CSV_NAME = "dnit_distancias.csv";
    private static final String FULLPATH = String.format("\\%s\\%s", PATH_TO_CSV, CSV_NAME);
    private static final String CSV_SEPARATOR = ",";

    public static void getCitiesDistance(Cities firstCity, Cities secondCity) {
        String line;

        try (BufferedReader buffer = new BufferedReader(new FileReader(FULLPATH))) {

            String[] city = buffer.readLine().split(CSV_SEPARATOR);

            int currentLine = 0;

            while ((line = buffer.readLine()) != null) {
                if (currentLine != firstCity.get()) {
                    System.out.println("Não chegou na current line, " + currentLine);

                    currentLine++;
                } else {
                    String[] data = line.split(CSV_SEPARATOR);

                    System.out.println(city[firstCity.get()] + " para " + city[secondCity.get()] + " é " + data[secondCity.get()]);
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
