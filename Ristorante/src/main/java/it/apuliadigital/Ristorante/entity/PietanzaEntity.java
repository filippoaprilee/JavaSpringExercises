package it.apuliadigital.Ristorante.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PietanzaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO: Aggiungi altri campi qui
    // TODO: Ricordati che puoi usare  @Enumerated(EnumType.STRING)

    // Getters e Setters
}
