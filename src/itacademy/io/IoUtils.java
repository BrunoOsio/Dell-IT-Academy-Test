package itacademy.io;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import itacademy.model.cities.Cities;
import itacademy.model.items.Item;
import itacademy.model.items.ItemNames;

public class IoUtils {

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

  public static int inputQuantity(String message) {
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

        boolean isPositive = Integer.parseInt(keyboard) > 0;


        if (!isPositive) {
          text("Digite um número maior que 0");
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

  public static int inputItemNumber(String message) {
    int number = 0;

    final int firstItem = 1;
    final int lastItem = 6;

    boolean validInput = false;

    while (!validInput) {
      String keyboard = inputText(message);

      try {

        boolean isNumber = keyboard.matches("^[0-9]+$");

        if (!isNumber) {
          text("Digite um número válido");
          continue;
        }

        int checkItemNumber = Integer.parseInt(keyboard);
        boolean isItemNumber = checkItemNumber >= firstItem && checkItemNumber <= lastItem;

        if(!isItemNumber) {
          text("Digite um item válido");
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

  public static int inputOutputItemNumber(String message, List<Item> initialItems) {
    int number = 0;

    List<Integer> itemsIdListToApply = new ArrayList<>();

    initialItems.forEach(item -> {
      ItemNames itemIdentifier = item.getName(); 

      if (itemIdentifier.equals(ItemNames.CHAIR)) {
        itemsIdListToApply.add(1);

      } else if (itemIdentifier.equals(ItemNames.FREEZER)) {
        itemsIdListToApply.add(2);

      } else if (itemIdentifier.equals(ItemNames.LIGHTING)) {
        itemsIdListToApply.add(3);

      } else if (itemIdentifier.equals(ItemNames.REFRIGERATOR)) {
        itemsIdListToApply.add(4);

      } else if (itemIdentifier.equals(ItemNames.SMARTPHONE)) {
        itemsIdListToApply.add(5);

      } else if (itemIdentifier.equals(ItemNames.WASHING_MACHINE)) {
        itemsIdListToApply.add(6);
      }
    });

    boolean validInput = false;

    while (!validInput) {
      String keyboard = inputText(message);

      try {

        boolean isNumber = keyboard.matches("^[0-9]+$");

        if (!isNumber) {
          text("Digite um número válido");
          continue;
        }

        int checkItemNumber = Integer.parseInt(keyboard);
        boolean isItemNumber = itemsIdListToApply.contains(checkItemNumber);

        if(!isItemNumber) {
          text("Digite um item válido");
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

  public static void showItems() {
    IoUtils.space();
    IoUtils.text("1 - CADEIRA");
    IoUtils.text("2 - FREEZER");
    IoUtils.text("3 - LUMINARIA");
    IoUtils.text("4 - GELADEIRA");
    IoUtils.text("5 - CELULAR");
    IoUtils.text("6 - MAQUINA DE LAVAR ROUPA");
  }

  public static void showOutputItems(List<Item> outputItems) {
    outputItems.forEach(item -> {
      ItemNames itemIdentifier = item.getName(); 

      if (itemIdentifier.equals(ItemNames.CHAIR)) {
        IoUtils.text("1 - CADEIRA");

      } else if (itemIdentifier.equals(ItemNames.FREEZER)) {
        IoUtils.text("2 - FREEZER");

      } else if (itemIdentifier.equals(ItemNames.LIGHTING)) {
        IoUtils.text("3 - LUMINARIA");

      } else if (itemIdentifier.equals(ItemNames.REFRIGERATOR)) {
        IoUtils.text("4 - GELADEIRA");

      } else if (itemIdentifier.equals(ItemNames.SMARTPHONE)) {
        IoUtils.text("5 - CELULAR");

      } else if (itemIdentifier.equals(ItemNames.WASHING_MACHINE)) {
        IoUtils.text("6 - MAQUINA DE LAVAR ROUPA");
      }

    });

    IoUtils.space();
  }



  public static Item inputItem() {
    space();

    int selectedItem = inputItemNumber("");

    Item item = Item.getByIndex(selectedItem);

    textFormatted("selecionado: %s", Item.getStringName(item));

    return item;
  }

  public static Item inputOutputItem(List<Item> initialItems) {
    space();

    int selectedItem = inputOutputItemNumber("", initialItems);

    Item item = Item.getByIndex(selectedItem);

    textFormatted("selecionado: %s", Item.getStringName(item));

    return item;
  }
}
