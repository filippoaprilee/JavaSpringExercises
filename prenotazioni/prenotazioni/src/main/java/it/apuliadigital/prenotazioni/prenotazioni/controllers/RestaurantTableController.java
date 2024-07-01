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

import it.apuliadigital.prenotazioni.prenotazioni.entitiesDTO.RestaurantTableDTO;
import it.apuliadigital.prenotazioni.prenotazioni.services.RestaurantTableService;

@Controller
@RequestMapping("/api/controller/table")
public class RestaurantTableController {

    @Autowired
    private RestaurantTableService tableService;

    @PostMapping("/add")
    public ResponseEntity<?> addTable(@RequestBody RestaurantTableDTO tableDTO) {
        if (tableService.addTable(tableDTO)) {
            return new ResponseEntity<>("Table added successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Unexpected Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> removeTable(@PathVariable int id) {
        if (tableService.removeTable(id)) {
            return new ResponseEntity<>("Table with id " + id + " removed successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Table with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getTable(@PathVariable int id) {
        RestaurantTableDTO tableDTO = tableService.getTable(id);
        if (tableDTO != null) {
            return new ResponseEntity<>(tableDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Table with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getTables() {
        List<RestaurantTableDTO> listTablesDTO = tableService.getTables();
        if (listTablesDTO != null) {
            return new ResponseEntity<>(listTablesDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Unexpected Error Occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTable(@PathVariable int id, @RequestBody RestaurantTableDTO tableDTO) {
        if (tableService.updateTable(id, tableDTO)) {
            return new ResponseEntity<>("Table updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Table with id " + id + " not found", HttpStatus.NOT_FOUND);
        }

    }

}
