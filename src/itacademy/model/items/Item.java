package itacademy.model.items;

public abstract class Item {
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

  @Override
  public String toString() {
    return "Item [name=" + name + ", weight=" + weight + ", quantity=" + quantity + "]\n";
  }
}
