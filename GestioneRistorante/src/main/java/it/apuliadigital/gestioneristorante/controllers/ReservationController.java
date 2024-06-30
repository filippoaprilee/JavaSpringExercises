package it.apuliadigital.gestioneristorante.controllers;

import it.apuliadigital.gestioneristorante.entitiesdto.ReservationDTO;
import it.apuliadigital.gestioneristorante.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/add")
    public ResponseEntity<String> addReservation(@RequestBody ReservationDTO reservationDTO) {
        boolean success = reservationService.addReservation(reservationDTO);
        if (success) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Reservation created successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create reservation.");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllReservations() {
        List<ReservationDTO> reservationDTOList = new ArrayList<>();
        boolean success = reservationService.getReservations(reservationDTOList);
        if (success && !reservationDTOList.isEmpty()) {
            return ResponseEntity.ok(reservationDTOList);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to get reservations.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReservationById(@PathVariable Long id) {
        ReservationDTO reservationDTO = new ReservationDTO();
        boolean success = reservationService.getReservationById(id, reservationDTO);
        if (success) {
            return ResponseEntity.ok(reservationDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reservation not found.");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateReservation(@PathVariable Long id, @RequestBody ReservationDTO reservationDTO) {
        boolean success = reservationService.updateReservation(id, reservationDTO);
        if (success) {
            return ResponseEntity.ok("Reservation updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed to update reservation.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable Long id) {
        boolean success = reservationService.deleteReservation(id);
        if (success) {
            return ResponseEntity.ok("Reservation deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed to delete reservation.");
        }
    }
}
