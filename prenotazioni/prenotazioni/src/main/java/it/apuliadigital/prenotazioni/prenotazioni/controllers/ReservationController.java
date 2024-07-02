package it.apuliadigital.prenotazioni.prenotazioni.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import it.apuliadigital.prenotazioni.prenotazioni.entitiesDTO.ReservationDTO;
import it.apuliadigital.prenotazioni.prenotazioni.services.ReservationService;

@Controller
@RequestMapping("/api/controller/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping("/add")
    public ResponseEntity<?> addReservation(@RequestBody ReservationDTO reservationDTO) {
        try {
            if (reservationService.addReservation(reservationDTO)) {
                return new ResponseEntity<>("Reservation added successfully", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Unexpected Error", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Internal Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> removeReservation(@PathVariable int id) {
        if (reservationService.removeReservation(id)) {
            return new ResponseEntity<>("Reservation with id " + id + " removed successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Reservation with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getReservation(@PathVariable int id) {
        ReservationDTO reservationDTO = reservationService.getReservation(id);
        if (reservationDTO != null) {
            return new ResponseEntity<>(reservationDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Reservation with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getReservations() {
        List<ReservationDTO> listReservationsDTO = reservationService.getReservations();
        if (listReservationsDTO != null) {
            return new ResponseEntity<>(listReservationsDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Unexpected Error Occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateReservation(@PathVariable int id, @RequestBody ReservationDTO reservationDTO) {
        if (reservationService.updateReservation(id, reservationDTO)) {
            return new ResponseEntity<>("Reservation updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Reservation with id " + id + " not found", HttpStatus.NOT_FOUND);
        }

    }

}
