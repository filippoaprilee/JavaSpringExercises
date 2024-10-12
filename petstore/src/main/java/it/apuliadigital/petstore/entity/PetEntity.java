package it.apuliadigital.petstore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "Pet")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
  
    private String tag;


    public PetEntity() {
    }

    public PetEntity(Long id, String name, String tag) {
        this.id = id;
        this.name = name;
        this.tag = tag;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public PetEntity id(Long id) {
        setId(id);
        return this;
    }

    public PetEntity name(String name) {
        setName(name);
        return this;
    }

    public PetEntity tag(String tag) {
        setTag(tag);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PetEntity)) {
            return false;
        }
        PetEntity petEntity = (PetEntity) o;
        return Objects.equals(id, petEntity.id) && Objects.equals(name, petEntity.name) && Objects.equals(tag, petEntity.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, tag);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", tag='" + getTag() + "'" +
            "}";
    }
    
}
