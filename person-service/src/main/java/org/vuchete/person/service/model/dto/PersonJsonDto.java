package org.vuchete.person.service.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Optional;
import java.util.Set;
import lombok.ToString;
import org.vuchete.person.service.model.records.Contact;

/**
 * Jsonizable POJO.
 */
@ToString
public class PersonJsonDto {

  @JsonProperty("first_name")
  public String firstName;

  @JsonProperty("second_name")
  public String secondName;

  @JsonProperty("middle_name")
  public Optional<String> middleName;

  @JsonProperty("documents")
  public Set<DocumentJsonDto> documents;

  @JsonProperty("registration_address")
  public AddressJsonDto registrationAddress;

  @JsonProperty("residence_address")
  public Set<AddressJsonDto> residenceAddresses;

  @JsonProperty("contacts")
  public Set<Contact> contacts;

  @JsonProperty("is_hidden")
  public boolean isHidden = false;

  /**
   * Jsonify POJO.
   *
   * @param firstName           Имя
   * @param secondName          Фамилия
   * @param middleName          Отчество (может отсутствовать)
   * @param documents           Документы
   * @param registrationAddress Место регистрации (постоянная / временная)
   * @param residenceAddresses  Место проживания (единственное по ГК РФ ст. 20)
   * @param contacts            Контакты
   * @param isHidden            Отображать ли пользователя в общем списке
   */
  @JsonCreator
  public PersonJsonDto(@JsonProperty("first_name") String firstName,
      @JsonProperty("second_name") String secondName,
      @JsonProperty("middle_name") Optional<String> middleName,
      @JsonProperty("documents") Set<DocumentJsonDto> documents,
      @JsonProperty("registration_address") AddressJsonDto registrationAddress,
      @JsonProperty("residence_address") Set<AddressJsonDto> residenceAddresses,
      @JsonProperty("contacts") Set<Contact> contacts,
      @JsonProperty("is_hidden") boolean isHidden) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.middleName = middleName;
    this.documents = documents;
    this.registrationAddress = registrationAddress;
    this.residenceAddresses = residenceAddresses;
    this.contacts = contacts;
    this.isHidden = isHidden;
  }
}
