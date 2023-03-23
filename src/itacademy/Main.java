package itacademy;

import itacademy.data.CitiesCSVReader;
import itacademy.data.Cities;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        CitiesCSVReader.getCitiesDistance(Cities.BELO_HORIZONTE, Cities.CAMPO_GRANDE);
    }
}
