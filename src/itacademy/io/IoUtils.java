package itacademy.io;

import java.util.InputMismatchException;
import java.util.Scanner;

import itacademy.model.cities.Cities;

public class IoUtils {

  /**
   *
   */
  private static final String POSITIVE_DECISION = "S";

  private static final int BACK_TO_ZERO_INDEX_PATTERN = 1;

  private static final Scanner input = new Scanner(System.in);

  public static void line() {
   System.out.println("=======================================================================");
  }

  public static void text(String message) {
    System.out.println(message);
  }

  public static void textFormatted(String message, String string) {
    System.out.printf(message, string);
    space();
  }

  private static void inputIdentifier() {
    System.out.print(">>> ");
  }

  public static String inputText(String message) {
    space();
    text(message);
    inputIdentifier();

    return input.nextLine();
  }

  public static int inputNumber(String message) {
    int number = 0;
    boolean validInput = false;

    while (!validInput) {
      String keyboard = inputText(message);

      try {
        boolean isNumber = keyboard.matches("^[0-9]+$");

        if (!isNumber) {
          text("Digite um número válido");
          continue;
        }

        validInput = true;
        number = Integer.parseInt(keyboard);

      } catch (NumberFormatException e) {
        e.printStackTrace();
      }
    }

    return number;
  }

  public static int inputCityNumber(String message) {
    int number = 0;

    final int firstCity = 1;
    final int lastCity = 24;

    boolean validInput = false;

    while (!validInput) {
      String keyboard = inputText(message);

      try {

        boolean isNumber = keyboard.matches("^[0-9]+$");

        if (!isNumber) {
          text("Digite um número válido");
          continue;
        }

        int checkCityNumber = Integer.parseInt(keyboard);
        boolean isCityNumber = checkCityNumber >= firstCity && checkCityNumber <= lastCity;

        if(!isCityNumber) {
          text("Digite uma cidade válida");
          continue;
        }
      
        validInput = true;
        number = Integer.parseInt(keyboard) - BACK_TO_ZERO_INDEX_PATTERN;

      } catch (NumberFormatException e) {
        e.printStackTrace();
      }
    }

    return number;
  }

  public static boolean inputDecision(String message) {
    boolean decision = false;
    boolean validInput = false;

    while (!validInput) {
      String keyboard = inputText(message);

      try {
        boolean isDecision = keyboard.matches("^[SsNn]+$");

        if (!isDecision) {
          text("Digite uma decisão válida");
          continue;
        }

        validInput = true;
        decision = keyboard.equalsIgnoreCase(POSITIVE_DECISION);

      } catch (InputMismatchException e) {
        e.printStackTrace();
      }
    }

    return decision;
  }

  public static void space() {
    text("");
  }

  public static void waitForEnterPress() {
    text("Pressione a tecla ENTER para continuar");
    input.nextLine();
  }

  public static void clearTerminal() {
    text("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r");
  }

  public static void showCities() {
    IoUtils.space();
    IoUtils.text("1  - ARACAJU               13 - MANAUS");
    IoUtils.text("2  - BELEM                 14 - NATAL");
    IoUtils.text("3  - BELO HORIZONTE        15 - PORTO ALEGRE");
    IoUtils.text("4  - BRASILIA              16 - PORTO VELHO");
    IoUtils.text("5  - CAMPO GRANDE          17 - RECIFE");
    IoUtils.text("6  - CUIABA                18 - RIO BRANCO");
    IoUtils.text("7  - CURITIBA              19 - RIO DE JANEIRO");
    IoUtils.text("8  - FLORIANOPOLIS         20 - SALVADOR");
    IoUtils.text("9  - FORTALEZA             21 - SAO LUIS");
    IoUtils.text("10 - GOIANIA               22 - SAO PAULO");
    IoUtils.text("11 - JOAO PESSOA           23 - TERESINA");
    IoUtils.text("12 - MACEIO                24 - VITORIA");
  }

  public static Cities inputCity() {
    space();

    int selectedCity = inputCityNumber("");

    Cities city = Cities.getByIndex(selectedCity).get();

    textFormatted("selecionado: %s", Cities.getStringName(city));

    return city;
  }
}
