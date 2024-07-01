    // Trova tutte le prenotazioni che si sovrappongono nel tempo con la nuova prenotazione
    List<Reservation> overlappingReservations = reservationRepository.findAll().stream()
            .filter(reservation ->
                    reservation.getReservationDate().isEqual(reservationDate) &&
                            (
                                    (reservationStartTime.isBefore(reservation.getReservationEndTime()) && reservation.getReservationStartTime().isBefore(reservationEndTime)) &&
                                    (reservationEndTime.isAfter(reservation.getReservationStartTime()) && reservation.getReservationEndTime().isAfter(reservationStartTime))
                            )
            )
            .collect(Collectors.toList());

    // Ottieni l'elenco dei tavoli già prenotati
    List<RestaurantTable> reservedTables = overlappingReservations.stream()
            .map(Reservation::getRestaurantTable)
            .collect(Collectors.toList());

    // Filtra i tavoli elegibili per prenotazione escludendo quelli già prenotati
    List<RestaurantTable> availableTables = eligibleTables.stream()
            .filter(table -> !reservedTables.contains(table))
            .collect(Collectors.toList());

    // Se ci sono tavoli disponibili, restituisci il primo della lista
    if (!availableTables.isEmpty()) {
        return availableTables.get(0);
    } else {
        return null; // Se non ci sono tavoli disponibili
    }
}