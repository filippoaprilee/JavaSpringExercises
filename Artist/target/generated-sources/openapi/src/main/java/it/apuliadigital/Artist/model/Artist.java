package it.apuliadigital.Artist.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Artist
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-13T13:53:22.197198400+02:00[Europe/Rome]", comments = "Generator version: 7.8.0")
public class Artist {

  private Long id;

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    SOLO("solo"),
    
    GROUP("group");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private TypeEnum type;

  private String name;

  private String surname;

  private String stageName;

  private Integer birthYear;

  private String biography;

  /**
   * Gets or Sets genre
   */
  public enum GenreEnum {
    POP("pop"),
    
    ROCK("rock"),
    
    JAZZ("jazz");

    private String value;

    GenreEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static GenreEnum fromValue(String value) {
      for (GenreEnum b : GenreEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private GenreEnum genre;

  private String nationality;

  public Artist() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Artist(String name, String surname, String stageName, Integer birthYear, String biography, GenreEnum genre, String nationality) {
    this.name = name;
    this.surname = surname;
    this.stageName = stageName;
    this.birthYear = birthYear;
    this.biography = biography;
    this.genre = genre;
    this.nationality = nationality;
  }

  public Artist id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", accessMode = Schema.AccessMode.READ_ONLY, requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Artist type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   */
  
  @Schema(name = "type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("type")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public Artist name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Artist surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Get surname
   * @return surname
   */
  @NotNull 
  @Schema(name = "surname", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("surname")
  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Artist stageName(String stageName) {
    this.stageName = stageName;
    return this;
  }

  /**
   * Get stageName
   * @return stageName
   */
  @NotNull 
  @Schema(name = "stageName", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("stageName")
  public String getStageName() {
    return stageName;
  }

  public void setStageName(String stageName) {
    this.stageName = stageName;
  }

  public Artist birthYear(Integer birthYear) {
    this.birthYear = birthYear;
    return this;
  }

  /**
   * Get birthYear
   * @return birthYear
   */
  @NotNull 
  @Schema(name = "birthYear", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("birthYear")
  public Integer getBirthYear() {
    return birthYear;
  }

  public void setBirthYear(Integer birthYear) {
    this.birthYear = birthYear;
  }

  public Artist biography(String biography) {
    this.biography = biography;
    return this;
  }

  /**
   * Get biography
   * @return biography
   */
  @NotNull 
  @Schema(name = "biography", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("biography")
  public String getBiography() {
    return biography;
  }

  public void setBiography(String biography) {
    this.biography = biography;
  }

  public Artist genre(GenreEnum genre) {
    this.genre = genre;
    return this;
  }

  /**
   * Get genre
   * @return genre
   */
  @NotNull 
  @Schema(name = "genre", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("genre")
  public GenreEnum getGenre() {
    return genre;
  }

  public void setGenre(GenreEnum genre) {
    this.genre = genre;
  }

  public Artist nationality(String nationality) {
    this.nationality = nationality;
    return this;
  }

  /**
   * Get nationality
   * @return nationality
   */
  @NotNull 
  @Schema(name = "nationality", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nationality")
  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Artist artist = (Artist) o;
    return Objects.equals(this.id, artist.id) &&
        Objects.equals(this.type, artist.type) &&
        Objects.equals(this.name, artist.name) &&
        Objects.equals(this.surname, artist.surname) &&
        Objects.equals(this.stageName, artist.stageName) &&
        Objects.equals(this.birthYear, artist.birthYear) &&
        Objects.equals(this.biography, artist.biography) &&
        Objects.equals(this.genre, artist.genre) &&
        Objects.equals(this.nationality, artist.nationality);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, name, surname, stageName, birthYear, biography, genre, nationality);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Artist {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    stageName: ").append(toIndentedString(stageName)).append("\n");
    sb.append("    birthYear: ").append(toIndentedString(birthYear)).append("\n");
    sb.append("    biography: ").append(toIndentedString(biography)).append("\n");
    sb.append("    genre: ").append(toIndentedString(genre)).append("\n");
    sb.append("    nationality: ").append(toIndentedString(nationality)).append("\n");
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

