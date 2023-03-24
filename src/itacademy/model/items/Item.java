package itacademy.model.items;

import itacademy.io.IoUtils;

public abstract class Item {
  private static final String UNDERSCORE ="_";
  private static final String BLANK_SPACE = " ";

  private ItemNames name;
  private double weight;
  private int quantity;

  public Item(int quantity) {
    this.setQuantity(quantity);
  }

  public ItemNames getName() {
    return name;
  }

  public void setName(ItemNames name) {
    this.name = name;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public int getQuantity() {
    return quantity;
  }

  public boolean hasQuantity() {
    return this.quantity > 0;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getTotalWeight() {
    return this.weight * this.getQuantity();
  }

  public static Item getByIndex(int index) {
    Item item = null;

    switch (index) {
      case 1:
        item = new Chair();
        break;
      case 2:
        item = new Freezer();
        break;
      case 3:
        item = new Lighting();
        break;
      case 4:
        item = new Refrigerator();
        break;
      case 5:
        item = new SmartPhone();
        break;
      case 6:
        item = new WashingMachine();
        break;
    
      default:
        IoUtils.text("Erro");
        break;
    }

    return item;
  }

  public static String getStringName(Item item) {
    String result = String.join(BLANK_SPACE, item.getName().get().split(UNDERSCORE));

    return result;
  }

  @Override
  public String toString() {
    return "Item [name=" + name + ", weight=" + weight + ", quantity=" + quantity + "]\n";
  }
}
