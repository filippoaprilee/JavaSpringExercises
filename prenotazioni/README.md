public RestaurantTable freeTable(List<RestaurantTable> elegibleTables, LocalDate reservationDate,
        LocalTime reservationStartTime, LocalTime reservationEndTime) {

    // Cerca il primo tavolo elegibile che sia libero durante l'intervallo richiesto
    return elegibleTables.stream()
            .filter(table -> reservationRepository.findAll().stream()
                    .noneMatch(reservation ->
                            reservation.getRestaurantTable().getId() == table.getId() &&
                                    reservation.getReservationDate().equals(reservationDate) &&
                                    (
                                        // Controlla se c'è sovrapposizione di orari
                                        (reservationStartTime.isBefore(reservation.getReservationEndTime()) &&
                                         reservationEndTime.isAfter(reservation.getReservationStartTime()))
                                    )
                    )
            )
            .findFirst()
            .orElse(null); // Ritorna null se non trova un tavolo libero
}