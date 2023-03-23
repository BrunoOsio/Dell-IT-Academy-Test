package itacademy.model.items;


public enum ItemNames {
  CHAIR("CADEIRA"),
  FREEZER("FREEZER"),
  LIGHTING("LUMINARIA"),
  REFRIGERATOR("GELADEIRA"),
  SMARTPHONE("CELULAR"),
  WASHING_MACHINE("MAQUINA_LAVAR_ROUPA");

  public final String value;

  ItemNames(String value) {
    this.value = value;
  }

  public String get() {
    return this.value;
  }
}
