public RestaurantTable freeTable(List<RestaurantTable> eligibleTables, LocalDate reservationDate,
        LocalTime reservationStartTime, LocalTime reservationEndTime) {
    // Trova una prenotazione che si sovrappone nel tempo
    Optional<Reservation> overlappingReservation = reservationRepository.findAll().stream()
            .filter(reservation ->
                reservation.getReservationDate().isEqual(reservationDate) &&
                (
                    (reservationStartTime.isAfter(reservation.getReservationStartTime()) && reservationStartTime.isBefore(reservation.getReservationEndTime())) ||
                    (reservationEndTime.isAfter(reservation.getReservationStartTime()) && reservationEndTime.isBefore(reservation.getReservationEndTime())) ||
                    (reservationStartTime.isBefore(reservation.getReservationStartTime()) && reservationEndTime.isAfter(reservation.getReservationEndTime()))
                )
            )
            .findFirst();

    // Se non ci sono prenotazioni sovrapposte, restituisci il primo tavolo disponibile
    if (overlappingReservation.isEmpty()) {
        return eligibleTables.stream().findFirst().orElse(null);
    } else {
        // Escludi i tavoli già prenotati
        Set<RestaurantTable> bookedTables = overlappingReservation.stream()
            .map(Reservation::getRestaurantTable)
            .collect(Collectors.toSet());

        // Trova il primo tavolo tra quelli elegibili che non è già prenotato
        return eligibleTables.stream()
            .filter(table -> !bookedTables.contains(table))
            .findFirst()
            .orElse(null);
    }
}