package it.apuliadigital.anagraficaClient.client.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import it.apuliadigital.anagraficaClient.client.model.PersonaClientNumeriTelefonici;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PersonaClient
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-15T22:59:29.338477800+02:00[Europe/Rome]", comments = "Generator version: 7.8.0")
public class PersonaClient {

  private Long idAnagrafica;

  private String nome;

  private String cognome;

  private PersonaClientNumeriTelefonici numeriTelefonici;

  @Valid
  private List<String> elencoIndirizziEmail = new ArrayList<>();

  private String dataNascita;

  public PersonaClient idAnagrafica(Long idAnagrafica) {
    this.idAnagrafica = idAnagrafica;
    return this;
  }

  /**
   * L'ID dell'anagrafica
   * @return idAnagrafica
   */
  
  @Schema(name = "idAnagrafica", accessMode = Schema.AccessMode.READ_ONLY, example = "1", description = "L'ID dell'anagrafica", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("idAnagrafica")
  public Long getIdAnagrafica() {
    return idAnagrafica;
  }

  public void setIdAnagrafica(Long idAnagrafica) {
    this.idAnagrafica = idAnagrafica;
  }

  public PersonaClient nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Il nome della persona
   * @return nome
   */
  
  @Schema(name = "nome", example = "Franco", description = "Il nome della persona", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nome")
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public PersonaClient cognome(String cognome) {
    this.cognome = cognome;
    return this;
  }

  /**
   * Il cognome della persona
   * @return cognome
   */
  
  @Schema(name = "cognome", example = "Calogero", description = "Il cognome della persona", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cognome")
  public String getCognome() {
    return cognome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public PersonaClient numeriTelefonici(PersonaClientNumeriTelefonici numeriTelefonici) {
    this.numeriTelefonici = numeriTelefonici;
    return this;
  }

  /**
   * Get numeriTelefonici
   * @return numeriTelefonici
   */
  @Valid 
  @Schema(name = "numeriTelefonici", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("numeriTelefonici")
  public PersonaClientNumeriTelefonici getNumeriTelefonici() {
    return numeriTelefonici;
  }

  public void setNumeriTelefonici(PersonaClientNumeriTelefonici numeriTelefonici) {
    this.numeriTelefonici = numeriTelefonici;
  }

  public PersonaClient elencoIndirizziEmail(List<String> elencoIndirizziEmail) {
    this.elencoIndirizziEmail = elencoIndirizziEmail;
    return this;
  }

  public PersonaClient addElencoIndirizziEmailItem(String elencoIndirizziEmailItem) {
    if (this.elencoIndirizziEmail == null) {
      this.elencoIndirizziEmail = new ArrayList<>();
    }
    this.elencoIndirizziEmail.add(elencoIndirizziEmailItem);
    return this;
  }

  /**
   * L'elenco degli indirizzi email della persona
   * @return elencoIndirizziEmail
   */
  
  @Schema(name = "elencoIndirizziEmail", example = "[\"email1@email.com\",\"email2@email.com\"]", description = "L'elenco degli indirizzi email della persona", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("elencoIndirizziEmail")
  public List<String> getElencoIndirizziEmail() {
    return elencoIndirizziEmail;
  }

  public void setElencoIndirizziEmail(List<String> elencoIndirizziEmail) {
    this.elencoIndirizziEmail = elencoIndirizziEmail;
  }

  public PersonaClient dataNascita(String dataNascita) {
    this.dataNascita = dataNascita;
    return this;
  }

  /**
   * La data di nascita della persona
   * @return dataNascita
   */
  
  @Schema(name = "dataNascita", example = "1990-01-01", description = "La data di nascita della persona", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dataNascita")
  public String getDataNascita() {
    return dataNascita;
  }

  public void setDataNascita(String dataNascita) {
    this.dataNascita = dataNascita;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonaClient personaClient = (PersonaClient) o;
    return Objects.equals(this.idAnagrafica, personaClient.idAnagrafica) &&
        Objects.equals(this.nome, personaClient.nome) &&
        Objects.equals(this.cognome, personaClient.cognome) &&
        Objects.equals(this.numeriTelefonici, personaClient.numeriTelefonici) &&
        Objects.equals(this.elencoIndirizziEmail, personaClient.elencoIndirizziEmail) &&
        Objects.equals(this.dataNascita, personaClient.dataNascita);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idAnagrafica, nome, cognome, numeriTelefonici, elencoIndirizziEmail, dataNascita);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonaClient {\n");
    sb.append("    idAnagrafica: ").append(toIndentedString(idAnagrafica)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    cognome: ").append(toIndentedString(cognome)).append("\n");
    sb.append("    numeriTelefonici: ").append(toIndentedString(numeriTelefonici)).append("\n");
    sb.append("    elencoIndirizziEmail: ").append(toIndentedString(elencoIndirizziEmail)).append("\n");
    sb.append("    dataNascita: ").append(toIndentedString(dataNascita)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

