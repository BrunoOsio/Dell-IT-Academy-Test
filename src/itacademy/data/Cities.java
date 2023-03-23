package itacademy.data;

public enum Cities {
    ARACAJU(0), 
    BELEM(1), 
    BELO_HORIZONTE(2),
    BRASILIA(3),
    CAMPO_GRANDE(4);

    public final int value;
    
    Cities(int value) {
      this.value = value;
    }

    public int get() {
      return this.value;
    }
}
