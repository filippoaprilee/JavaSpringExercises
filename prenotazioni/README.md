public RestaurantTable freeTable(List<RestaurantTable> eligibleTables, LocalDate reservationDate,
        LocalTime reservationStartTime, LocalTime reservationEndTime) {

    // Trova tutte le prenotazioni che si sovrappongono nel tempo con la nuova prenotazione
    List<Reservation> overlappingReservations = reservationRepository.findAll().stream()
            .filter(reservation ->
                reservation.getReservationDate().isEqual(reservationDate) &&
                (
                    (reservationStartTime.isAfter(reservation.getReservationStartTime()) && reservationStartTime.isBefore(reservation.getReservationEndTime())) ||
                    (reservationEndTime.isAfter(reservation.getReservationStartTime()) && reservationEndTime.isBefore(reservation.getReservationEndTime())) ||
                    (reservationStartTime.isBefore(reservation.getReservationStartTime()) && reservationEndTime.isAfter(reservation.getReservationEndTime()))
                )
            )
            .collect(Collectors.toList());

    // Costruisci un set di tavoli già prenotati
    Set<RestaurantTable> bookedTables = overlappingReservations.stream()
            .map(Reservation::getRestaurantTable)
            .collect(Collectors.toSet());

    // Trova il primo tavolo tra quelli elegibili che non è già prenotato
    Optional<RestaurantTable> availableTable = eligibleTables.stream()
            .filter(table -> !bookedTables.contains(table))
            .findFirst();

    return availableTable.orElse(null);
}