package org.vuchete.person.service.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Optional;
import lombok.Data;

/**
 * Jsonizable POJO.
 */
@Data
public class PersonJsonDto {

  @JsonProperty("first_name")
  public String firstName;

  @JsonProperty("second_name")
  public String secondName;

  @JsonProperty("middle_name")
  public String middleName;

  @JsonProperty("is_hidden")
  public boolean isHidden = false;

  /**
   * Jsonify POJO.
   *
   * @param firstName           Имя
   * @param secondName          Фамилия
   * @param middleName          Отчество (может отсутствовать)
   * @param isHidden            Отображать ли пользователя в общем списке
   */
  @JsonCreator
  public PersonJsonDto(@JsonProperty("first_name") String firstName,
      @JsonProperty("second_name") String secondName,
      @JsonProperty("middle_name") String middleName,
      @JsonProperty("is_hidden") boolean isHidden) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.middleName = middleName;
    this.isHidden = isHidden;
  }
}
