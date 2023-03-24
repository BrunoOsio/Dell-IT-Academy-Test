package itacademy.model.cities;

import java.util.Optional;
import java.util.stream.Stream;

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

  private static final String UNDERSCORE ="_";
  private static final String BLANK_SPACE = " ";

  public final int value;

  Cities(int value) {
    this.value = value;
  }

  public int get() {
    return this.value;
  }

  public static Optional<Cities> getByIndex(int targetCityIndex) {

    Optional<Cities> result = null;

    Optional<Cities> optionalCity = Stream.of(Cities.values())
      .filter(city -> city.get() == targetCityIndex)
      .findFirst();

    if (optionalCity.isPresent()) {
      result = optionalCity;
    }

    return result;
  }

  public static String getByIndexStringName(int targetCityIndex) {

    Optional<Cities> result = null;

    Optional<Cities> optionalCity = Stream.of(Cities.values())
      .filter(city -> city.get() == targetCityIndex)
      .findFirst();

    if (optionalCity.isPresent()) {
      result = optionalCity;
    }

    String formattedResult = String.join(BLANK_SPACE, result.get().name().split(UNDERSCORE));;

    return formattedResult;
  }

  public static String getStringName(Cities city) {
    String result = String.join(BLANK_SPACE, city.name().split(UNDERSCORE));

    return result;
  }
}
