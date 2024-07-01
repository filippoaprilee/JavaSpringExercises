Per ottenere i tavoli disponibili per le prenotazioni senza sovrapposizioni, possiamo modificare il codice eliminando i metodi `elegibleTables` e `freeTable`, e sostituendoli con i seguenti metodi:

1. **Metodo per ottenere tavoli disponibili**: Questo metodo restituirà una lista di tavoli disponibili per una data prenotazione, considerando la durata fissa di 2 ore.

```java
public List<RestaurantTable> findAvailableTables(ReservationDTO reservationDTO) {
    LocalDate reservationDate = reservationDTO.getReservationDate();
    LocalTime reservationStartTime = reservationDTO.getReservationStartTime();
    LocalTime reservationEndTime = reservationStartTime.plusHours(2);
    
    List<Reservation> overlappingReservations = reservationRepository.findAll().stream()
        .filter(r -> r.getReservationDate().equals(reservationDate))
        .filter(r -> r.getRestaurantTable().getSeats() == reservationDTO.getNumberOfGuests())
        .filter(r -> r.getReservationStartTime().isBefore(reservationEndTime) && r.getReservationEndTime().isAfter(reservationStartTime))
        .collect(Collectors.toList());
    
    List<RestaurantTable> allTables = tableRepository.findAll();
    
    List<RestaurantTable> availableTables = allTables.stream()
        .filter(t -> !overlappingReservations.stream()
            .map(Reservation::getRestaurantTable)
            .collect(Collectors.toList())
            .contains(t))
        .collect(Collectors.toList());
    
    return availableTables;
}
```

2. **Metodo per controllare sovrapposizioni**: Questo metodo verifica se esistono prenotazioni sovrapposte per un tavolo specifico in una data e ora specificate.

```java
public boolean isTableAvailable(RestaurantTable table, LocalDate reservationDate, LocalTime reservationStartTime, LocalTime reservationEndTime) {
    List<Reservation> overlappingReservations = reservationRepository.findAll().stream()
        .filter(r -> r.getRestaurantTable().equals(table))
        .filter(r -> r.getReservationDate().equals(reservationDate))
        .filter(r -> r.getReservationStartTime().isBefore(reservationEndTime) && r.getReservationEndTime().isAfter(reservationStartTime))
        .collect(Collectors.toList());
    
    return overlappingReservations.isEmpty();
}
```

Nella prima funzione (`findAvailableTables`):
- Recupero tutte le prenotazioni che si sovrappongono con la nuova prenotazione.
- Filtraggio dei tavoli disponibili escludendo quelli che sono già prenotati negli orari desiderati.

Nella seconda funzione (`isTableAvailable`):
- Verifica se un tavolo specifico è disponibile per una data e un intervallo di tempo specificati.

Questi metodi ti consentiranno di gestire meglio la logica di prenotazione e di verifica dei tavoli disponibili senza sovrapposizioni nel tuo servizio di prenotazioni.