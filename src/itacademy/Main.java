package itacademy;

import java.util.ArrayList;
import java.util.List;


import itacademy.io.IoUtils;
import itacademy.model.cities.Cities;
import itacademy.model.items.Item;
import itacademy.model.travel.FullTravel;
import itacademy.model.travel.Setpoint;
import itacademy.model.travel.SingleTravel;
import itacademy.model.trucks.BigTruck;
import itacademy.model.trucks.MediumTruck;
import itacademy.model.trucks.SmallTruck;
import itacademy.model.trucks.Truck;

public class Main {

  private static final boolean IS_NEXT_ROUTE = true;
  private static final boolean IS_NEXT_ITEM = true;

  private static final boolean IS_LAST_ROUTE = false;
  private static final boolean IS_LAST_ITEM = false;

  static List<FullTravel> history = new ArrayList<>();

  private static String username;

  private static boolean isProgramFinished = false;

  private static int currentChoose;
  public static void main(String[] args) {
    startup();

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
    IoUtils.text("1 - Simular uma viagem ponto a ponto");
    IoUtils.text("2 - Criar uma rota de entrega");
    IoUtils.text("3 - Ver histórico");
    IoUtils.text("4 - Sair");

    currentChoose = IoUtils.inputMenuChoose("");
    
    redirect(currentChoose);
  }

  public static void redirect(int choose) {
    switch(choose) {
      case 1:
        simulateTravel();
        break;
      case 2:
        createRoute();
        break;
      case 3:
        viewHistory();
        break;
      case 4:
        exit();
        break;
      default:
        IoUtils.text("Erro");
    }
  }

  public static void simulateTravel() {
    IoUtils.clearTerminal();

    IoUtils.text("Selecione a rota inicial");
    IoUtils.showCities();
    Cities sourceCity = IoUtils.inputCity();

    IoUtils.space();
    IoUtils.text("Selecione a rota final");
    IoUtils.showCities();

    Cities destinationCity = IoUtils.inputCity();

    boolean isRepeatedPlaces = destinationCity.equals(sourceCity);

    if (isRepeatedPlaces) {
      IoUtils.clearTerminal();
      IoUtils.text("Não é possível o destino ser na mesma cidade de partida");
      IoUtils.waitForEnterPress();
    } else {
      IoUtils.clearTerminal();
      System.out.println("Viagem de " + Cities.getStringName(sourceCity) + " até " + Cities.getStringName(destinationCity));
      IoUtils.waitForEnterPress();

      Setpoint newSetpoint = new Setpoint(sourceCity, destinationCity);

      IoUtils.clearTerminal();
      IoUtils.text("Selecione um caminhão: ");
      IoUtils.text("1 - Pequeno");
      IoUtils.text("2 - Médio");
      IoUtils.text("3 - Grande");

      Truck truck = IoUtils.inputTruck();

      printResults(newSetpoint, truck);
    }
  }

  public static void createRoute() {
    List<SingleTravel> singleTravels = new ArrayList<>();

    //City
    Cities nextTravelSourceCity = null;
    
    //Item
    List<Item> initialItems = new ArrayList<>();
    List<Item> nextTravelInitialItems = new ArrayList<>();

    List<Item> outputItems = new ArrayList<>();

    //City
    IoUtils.clearTerminal();

    IoUtils.text("Selecione a rota inicial");
    IoUtils.showCities();
    Cities sourceCity = IoUtils.inputCity();

    //Item
    IoUtils.clearTerminal();

    boolean isNextInitialItem = IS_NEXT_ITEM;

    while (isNextInitialItem) {
      IoUtils.clearTerminal();
      IoUtils.text("Selecione os produtos iniciais");
      IoUtils.showItems();

      Item initialItem = IoUtils.inputItem();
      int initialItemQuantity = IoUtils.inputQuantity("Sua quantidade");

      initialItem.setQuantity(initialItemQuantity);

      initialItems.add(initialItem);

      boolean isMoreInitialItemsDecision = IoUtils.inputDecision("Há mais itens que irão entrar? [S/N]");

      if (!isMoreInitialItemsDecision) {
        isNextInitialItem = IS_LAST_ITEM;
      }
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
        IoUtils.waitForEnterPress();

        continue;
      }

      Setpoint newSetpoint;

      if (nextTravelSourceCity != null) {
        newSetpoint = new Setpoint(nextTravelSourceCity, destinationCity);
      } else {
        newSetpoint = new Setpoint(sourceCity, destinationCity);
      }
      
      sourceCity = null;
      nextTravelSourceCity = destinationCity;

      //Item
      boolean outputItemsDecision = IoUtils.inputDecision("Você deseja retirar itens nessa parada? [S/N]");

      if (outputItemsDecision) {
        IoUtils.clearTerminal();
        
        boolean isNextOutputItem = IS_NEXT_ITEM;
    
        while (isNextOutputItem) {
          IoUtils.clearTerminal();
          
          IoUtils.text("Selecione os produtos que irão sair");
          IoUtils.showOutputItems(initialItems);

          Item outputItem = IoUtils.inputOutputItem(initialItems);

          int outputItemQuantity = IoUtils.inputQuantity("Sua quantidade");

          outputItem.setQuantity(outputItemQuantity);
    
          outputItems.add(outputItem);

          boolean isMoreOutputItemsDecision = IoUtils.inputDecision("Há mais itens que irão sair? [S/N]");

          if (!isMoreOutputItemsDecision) {
            isNextOutputItem = IS_LAST_ITEM;
          }
        }
      }

      boolean isOutputItems = outputItems.size() > 0;

      boolean isOtherTravel = !nextTravelInitialItems.isEmpty();

      SingleTravel newSingleTravel = new SingleTravel(newSetpoint, initialItems);

      if (!isOutputItems) {
        newSingleTravel = new SingleTravel(newSetpoint, initialItems);

        if (isOtherTravel) {
          newSingleTravel = new SingleTravel(newSetpoint, nextTravelInitialItems);
        }
      }

      if (isOutputItems) {
        newSingleTravel = new SingleTravel(newSetpoint, initialItems, outputItems);

        if (isOtherTravel) {
          newSingleTravel = new SingleTravel(newSetpoint, nextTravelInitialItems, outputItems);
        }
      }

      singleTravels.add(newSingleTravel);

      nextTravelInitialItems = newSingleTravel.getFinalItems();

      boolean decision = IoUtils.inputDecision("Você deseja adicionar mais uma parada? [S/N]");

      if (!decision) {
        isNextRoute = IS_LAST_ROUTE;
      }
    }

    IoUtils.clearTerminal();
    IoUtils.line();
    IoUtils.text("Resultados da viagem");
    IoUtils.line();
    IoUtils.space();
    IoUtils.waitForEnterPress();

    FullTravel fullTravel = new FullTravel(singleTravels);

    printResults(fullTravel);
    history.add(fullTravel);
  }

  public static void printResults(Setpoint setpoint, Truck truck) {
    double price = setpoint.getDistance() * truck.getPricePerKilometer();

    IoUtils.line();
    IoUtils.space();
    System.out.printf("Viagem de %s para %s\n\n", setpoint.getSourceCity(), setpoint.getDestinationCity());
    System.out.printf("Distância: %.2f km\n", setpoint.getDistance());
    System.out.printf("Preço: R$%.2f\n", price);
    
    double truckMaxWeight = truck.getMaxLoadWeight();
    if (truckMaxWeight == SmallTruck.MAX_KG_LOAD_WEIGHT) {
      System.out.println("Caminhão: pequeno");
    } else if (truckMaxWeight == MediumTruck.MAX_KG_LOAD_WEIGHT) {
      System.out.println("Caminhão: médio");
    } else {
      System.out.println("Caminhão: grande");
    }

    IoUtils.space();
    IoUtils.waitForEnterPress();
  }

  public static void printResults(FullTravel fullTravel) {

    fullTravel.getTravels().forEach(travel -> {
      IoUtils.line();
      IoUtils.space();
      System.out.printf("Viagem de %s para %s\n\n", travel.getSourceCity(), travel.getDestinationCity());
      System.out.printf("Distância: %.2f km\n", travel.getDistance());
      System.out.printf("Preço: R$%.2f\n", travel.getPrice());
      System.out.printf("Custo médio por km: R$%.2f\n", travel.getAveragePricePerKilometer());
      System.out.println("Peso: " + travel.getWeight() + "kg");
      IoUtils.space();

      System.out.println("Produtos carregados: ");
      travel.getInitialItems().stream().forEach(initial -> {
        System.out.println(initial.getName().get() + " - " + initial.getQuantity() + "x");
      });

      System.out.printf("Preço unitário médio: R$%.2f \n", travel.getItemUnitaryPrice());

      IoUtils.space();
      System.out.println("Produtos descarregados: ");

      if (travel.getOutputItems().isEmpty()) {
        System.out.println("- Nenhum -");
      }

      travel.getOutputItems().stream().forEach(output -> {
        System.out.println(output.getName().get() + " - " + output.getQuantity() + "x");
      });

      IoUtils.space();

      System.out.println("Transportes utilizados: ");
      List<Truck> trucks = travel.getTrucks();
      
      long smallTruckCount = trucks.stream()
        .filter(SmallTruck.class::isInstance)
        .count();

      long mediumTruckCount = trucks.stream()
        .filter(MediumTruck.class::isInstance)
        .count();

      long bigTruckCount = trucks.stream()
        .filter(BigTruck.class::isInstance)
        .count();

      if (smallTruckCount > 0) {
        System.out.printf("Caminhões pequenos: %d\n", smallTruckCount);
      }

      if (mediumTruckCount > 0) {
        System.out.printf("Caminhões médios: %d\n", mediumTruckCount);
      }

      if (bigTruckCount > 0) {
        System.out.printf("Caminhões grandes: %d\n", bigTruckCount);
      }
      
      IoUtils.space();
      IoUtils.waitForEnterPress();
    });
    
    IoUtils.space();
    IoUtils.waitForEnterPress();

    IoUtils.text("Resultado final das viagens: ");
    System.out.printf("Preço Total: R$%.2f\n", fullTravel.getPrice());
    System.out.printf("Distância Total: %.2f km\n", fullTravel.getDistance());

    IoUtils.space();
    IoUtils.waitForEnterPress();
  }

  public static void viewHistory() {
    history.forEach(h -> {
      h.getTravels().forEach(travel -> {
        IoUtils.line();
        IoUtils.space();
        System.out.printf("Viagem de %s para %s\n\n", travel.getSourceCity(), travel.getDestinationCity());
        System.out.println("Distância: " + travel.getDistance() + "km");
        System.out.printf("Preço: R$%.2f\n", travel.getPrice());
        System.out.printf("Custo médio por km: R$%.2f\n", travel.getAveragePricePerKilometer());

        System.out.println("Peso: " + travel.getWeight() + "kg");
        IoUtils.space();
  
        System.out.println("Produtos carregados: ");
        travel.getInitialItems().stream().forEach(initial -> {
          System.out.println(initial.getName().get() + " - " + initial.getQuantity() + "x");
        });
  
        System.out.printf("Preço unitário médio: R$%.2f \n", travel.getItemUnitaryPrice());
  
        IoUtils.space();
        System.out.println("Produtos descarregados: ");
  
        if (travel.getOutputItems().isEmpty()) {
          System.out.println("- Nenhum -");
        }
  
        travel.getOutputItems().stream().forEach(output -> {
          System.out.println(output.getName().get() + " - " + output.getQuantity() + "x");
        });
  
        IoUtils.space();
  
        System.out.println("Transportes utilizados: ");
        List<Truck> trucks = travel.getTrucks();
        
        long smallTruckCount = trucks.stream()
          .filter(SmallTruck.class::isInstance)
          .count();
  
        long mediumTruckCount = trucks.stream()
          .filter(MediumTruck.class::isInstance)
          .count();
  
        long bigTruckCount = trucks.stream()
          .filter(BigTruck.class::isInstance)
          .count();
  
        if (smallTruckCount > 0) {
          System.out.printf("Caminhões pequenos: %d\n", smallTruckCount);
        }
  
        if (mediumTruckCount > 0) {
          System.out.printf("Caminhões médios: %d\n", mediumTruckCount);
        }
  
        if (bigTruckCount > 0) {
          System.out.printf("Caminhões grandes: %d\n", bigTruckCount);
        }
        
        IoUtils.space();
      });
      
      IoUtils.space();
      IoUtils.waitForEnterPress();
      IoUtils.line();

      IoUtils.text("Resultado final das viagens: ");
      System.out.printf("Preço Total: R$%.2f\n", h.getPrice());
      System.out.printf("Distância Total: %.2f km\n", h.getDistance());
      IoUtils.line();

      IoUtils.space();
      IoUtils.waitForEnterPress();
    });
  }

  public static void exit() {
    IoUtils.clearTerminal();
    IoUtils.text("Obrigado por utilizar nossos serviços, " + username + "!");
    System.exit(0);
  }
}