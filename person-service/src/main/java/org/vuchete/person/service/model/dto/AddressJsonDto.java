package org.vuchete.person.service.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Jsonizable POJO: адрес в формате ФИАС.
 */
public class AddressJsonDto {

  @JsonProperty("country")
  public String country;

  @JsonProperty("region")
  public String region;

  @JsonProperty("locality")
  public String locality;

  @JsonProperty("street")
  public String street;

  @JsonProperty("house")
  public String house;

  /**
   * @param country Страна
   * @param region Регион
   * @param locality Город / поселок
   * @param street Улица
   * @param house Здание (с учетом корпуса и строения)
   */
  @JsonCreator
  public AddressJsonDto(
      @JsonProperty("country") String country,
      @JsonProperty("region") String region, @JsonProperty("locality") String locality,
      @JsonProperty("street") String street, @JsonProperty("house") String house) {
    this.country = country;
    this.region = region;
    this.locality = locality;
    this.street = street;
    this.house = house;
  }
}
