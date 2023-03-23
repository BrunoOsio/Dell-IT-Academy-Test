package itacademy.model.cities;

public enum Cities {
  ARACAJU(0),
  BELEM(1),
  BELO_HORIZONTE(2),
  BRASILIA(3),
  CAMPO_GRANDE(4),
  CUIABA(5),
  CURITIBA(6),
  FLORIANOPOLIS(7),
  FORTALEZA(8),
  GOIANIA(9),
  JOAO_PESSOA(10),
  MACEIO(11),
  MANAUS(12),
  NATAL(13),
  PORTO_ALEGRE(14),
  PORTO_VELHO(15),
  RECIFE(16),
  RIO_BRANCO(17),
  RIO_DE_JANEIRO(18),
  SALVADOR(19),
  SAO_LUIS(20),
  SAO_PAULO(21),
  TERESINA(22),
  VITORIA(23);

  public final int value;

  Cities(int value) {
    this.value = value;
  }

  public int get() {
    return this.value;
  }
}
