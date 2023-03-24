package itacademy;

import java.util.ArrayList;
import java.util.List;

import itacademy.io.IoUtils;
import itacademy.model.cities.Cities;
import itacademy.model.items.Item;
import itacademy.model.travel.Setpoint;

public class Main {

  private static final boolean IS_NEXT_ROUTE = true;
  private static final boolean IS_NEXT_ITEM = true;

  private static final boolean IS_LAST_ROUTE = false;
  private static final boolean IS_LAST_ITEM = false;

  private static String username;

  private static boolean isProgramFinished = false;

  private static int currentChoose;
  public static void main(String[] args) {
    // startup();

    while(!isProgramFinished) {
      execute();
    }
  }

  public static void startup() {
    IoUtils.clearTerminal();
    IoUtils.line();
    IoUtils.text("Bem vindo à logistica Osio´s");
    IoUtils.line();

    username = IoUtils.inputText("Qual o nome de sua empresa?");

    IoUtils.space();
    IoUtils.textFormatted("Olá %s, muito bem ver você utilizando nossos serviços. Vamos inicializar...", username);
    IoUtils.waitForEnterPress();
  }

  public static void execute() {
    IoUtils.clearTerminal();

    IoUtils.text("Pressione a tecla do serviço que você deseja: ");
    IoUtils.space();
    IoUtils.text("1 - Criar uma rota de entrega");

    currentChoose = IoUtils.inputNumber("");
    
    redirect(currentChoose);
  }

  public static void redirect(int choose) {
    switch(choose) {
      case 1:
        createRoute();
        break;
      default:
        IoUtils.text("Erro");
    }
  }

  public static void createRoute() {
    List<Setpoint> setpoints = new ArrayList<>();

    //City
    Cities nextTravelSourceCity = null;

    IoUtils.clearTerminal();

    IoUtils.text("Selecione a rota inicial");
    IoUtils.showCities();
    Cities sourceCity = IoUtils.inputCity();

    //Item

    IoUtils.clearTerminal();
    boolean isNextItem = IS_NEXT_ITEM;

    while (isNextItem) {
      IoUtils.text("Selecione os produtos iniciais");
      IoUtils.showItems();
      Item initialItem = IoUtils.inputItem();
    }

    boolean isNextRoute = IS_NEXT_ROUTE;

    while (isNextRoute) {
      //City
      IoUtils.space();
      IoUtils.text("Selecione a próxima rota");
      IoUtils.showCities();
      Cities destinationCity = IoUtils.inputCity();

      boolean isRepeatedPlaces = destinationCity.equals(sourceCity) || (destinationCity.equals(nextTravelSourceCity));
      if (isRepeatedPlaces) {
        IoUtils.clearTerminal();
        IoUtils.text("Não é possível o destino ser na mesma cidade de partida");
        continue;
      }

      Setpoint newSetpoint;
      if (nextTravelSourceCity != null) {
        newSetpoint = new Setpoint(nextTravelSourceCity, destinationCity);
      } else {
        newSetpoint = new Setpoint(sourceCity, destinationCity);
      }
      
      setpoints.add(newSetpoint);

      sourceCity = null;
      nextTravelSourceCity = destinationCity;

      //Item



      boolean decision = IoUtils.inputDecision("Você deseja adicionar mais uma parada? [S/N]");

      if (!decision) {
        isNextRoute = IS_LAST_ROUTE;
      }
    }

    System.out.println(setpoints);
  }
}