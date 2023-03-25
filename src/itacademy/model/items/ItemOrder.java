package itacademy.model.items;

public class ItemOrder {
  private Item item;
  private int quantity;

  public ItemOrder(Item item, int quantity) {
    this.item = item;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
