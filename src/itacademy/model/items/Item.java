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
      case 0:
        item = new Chair();
        break;
      case 1:
        item = new Freezer();
        break;
      case 2:
        item = new Lighting();
        break;
      case 3:
        item = new Refrigerator();
        break;
      case 4:
        item = new SmartPhone();
        break;
      case 5:
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
    return "Item [name=" + name + "quantity=" + quantity + "]\n";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    long temp;
    temp = Double.doubleToLongBits(weight);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + quantity;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Item other = (Item) obj;
    if (name != other.name)
      return false;
    if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
      return false;
    if (quantity != other.quantity)
      return false;
    return true;
  }
}
