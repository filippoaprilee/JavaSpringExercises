package it.apuliadigital.provageneratorivano.entity;


@Entity
public class GroceryItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO: Aggiungi altri campi qui
    // TODO: Ricordati che puoi usare  @Enumerated(EnumType.STRING)

    // Getters e Setters
}
