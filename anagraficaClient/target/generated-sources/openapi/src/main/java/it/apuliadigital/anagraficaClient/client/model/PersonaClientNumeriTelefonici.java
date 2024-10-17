package it.apuliadigital.anagraficaClient.client.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * I numeri telefonici della persona
 */

@Schema(name = "PersonaClient_numeriTelefonici", description = "I numeri telefonici della persona")
@JsonTypeName("PersonaClient_numeriTelefonici")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-15T22:59:29.338477800+02:00[Europe/Rome]", comments = "Generator version: 7.8.0")
public class PersonaClientNumeriTelefonici {

  private String cellulare;

  private String fisso;

  public PersonaClientNumeriTelefonici cellulare(String cellulare) {
    this.cellulare = cellulare;
    return this;
  }

  /**
   * Il numero di cellulare
   * @return cellulare
   */
  
  @Schema(name = "cellulare", example = "3331234567", description = "Il numero di cellulare", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cellulare")
  public String getCellulare() {
    return cellulare;
  }

  public void setCellulare(String cellulare) {
    this.cellulare = cellulare;
  }

  public PersonaClientNumeriTelefonici fisso(String fisso) {
    this.fisso = fisso;
    return this;
  }

  /**
   * Il numero di telefono fisso
   * @return fisso
   */
  
  @Schema(name = "fisso", example = "091123456", description = "Il numero di telefono fisso", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fisso")
  public String getFisso() {
    return fisso;
  }

  public void setFisso(String fisso) {
    this.fisso = fisso;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonaClientNumeriTelefonici personaClientNumeriTelefonici = (PersonaClientNumeriTelefonici) o;
    return Objects.equals(this.cellulare, personaClientNumeriTelefonici.cellulare) &&
        Objects.equals(this.fisso, personaClientNumeriTelefonici.fisso);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cellulare, fisso);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonaClientNumeriTelefonici {\n");
    sb.append("    cellulare: ").append(toIndentedString(cellulare)).append("\n");
    sb.append("    fisso: ").append(toIndentedString(fisso)).append("\n");
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

