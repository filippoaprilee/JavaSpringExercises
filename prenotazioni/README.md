public RestaurantTable freeTable(List<RestaurantTable> elegibleTables, LocalDate reservationDate,
        LocalTime reservationStartTime, LocalTime reservationEndTime) {

    // Cerca il primo tavolo elegibile che sia libero durante l'intervallo richiesto
    return elegibleTables.stream()
            .filter(table -> reservationRepository.findAll().stream()
                    .noneMatch(reservation ->
                            reservation.getRestaurantTable().getId() == table.getId() &&
                                    reservation.getReservationDate().equals(reservationDate) &&
                                    ((reservationStartTime.isAfter(reservation.getReservationStartTime()) && reservationStartTime.isBefore(reservation.getReservationEndTime())) ||
                                     (reservationEndTime.isAfter(reservation.getReservationStartTime()) && reservationEndTime.isBefore(reservation.getReservationEndTime())))
                    )
            )
            .findFirst()
            .orElse(null); // Ritorna null se non trova un tavolo libero
}