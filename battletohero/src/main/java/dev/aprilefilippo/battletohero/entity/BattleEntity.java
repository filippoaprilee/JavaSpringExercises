package dev.aprilefilippo.battletohero.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class BattleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int hero1Id;
    private int hero2Id;
    private String winner;

    public BattleEntity() {

    }

    public BattleEntity(int hero1Id, int hero2Id, String winner) {
        this.hero1Id = hero1Id;
        this.hero2Id = hero2Id;
        this.winner = winner;
    }

    public BattleEntity(int id, int hero1Id, int hero2Id, String winner) {
        this.id = id;
        this.hero1Id = hero1Id;
        this.hero2Id = hero2Id;
        this.winner = winner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHero1Id() {
        return hero1Id;
    }

    public void setHero1Id(int hero1Id) {
        this.hero1Id = hero1Id;
    }

    public int getHero2Id() {
        return hero2Id;
    }

    public void setHero2Id(int hero2Id) {
        this.hero2Id = hero2Id;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BattleEntity that = (BattleEntity) o;
        return id == that.id && hero1Id == that.hero1Id && hero2Id == that.hero2Id && Objects.equals(winner, that.winner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hero1Id, hero2Id, winner);
    }

    @Override
    public String toString() {
        return "BattleEntity{" +
                "id=" + id +
                ", hero1=" + hero1Id +
                ", hero2=" + hero2Id +
                ", winner='" + winner + '\'' +
                '}';
    }
}
