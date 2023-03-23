package itacademy.model.items;

public abstract class Item {
  private String name;
  private double weight;
  private int quantity;

  public Item(int quantity) {
    this.setQuantity(quantity);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
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

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getTotalWeight() {
    return this.weight * this.getQuantity();
  }

  @Override
  public String toString() {
    return "Item [name=" + name + ", weight=" + weight + ", quantity=" + quantity + "]";
  }
}
