package it.apuliadigital.EsercitazionePetStore.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "animale")
public class AnimaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String razza;

    public AnimaleEntity() {
    }

    public AnimaleEntity(Long id, String nome, String razza) {
        this.id = id;
        this.nome = nome;
        this.razza = razza;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazza() {
        return razza;
    }

    public void setRazza(String razza) {
        this.razza = razza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimaleEntity that = (AnimaleEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(razza, that.razza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, razza);
    }

    @Override
    public String toString() {
        return "AnimaleEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", razza='" + razza + '\'' +
                '}';
    }
}
