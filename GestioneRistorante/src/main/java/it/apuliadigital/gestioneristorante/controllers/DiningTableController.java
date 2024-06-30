package it.apuliadigital.gestioneristorante.controllers;

import it.apuliadigital.gestioneristorante.entitiesdto.DiningTableDTO;
import it.apuliadigital.gestioneristorante.services.DiningTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tables")
public class DiningTableController {

    @Autowired
    private DiningTableService tableService;

    @PostMapping("/add")
    public ResponseEntity<String> addTable(@RequestBody DiningTableDTO tableDTO) {
        boolean success = tableService.addTable(tableDTO);
        if (success) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Table created successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create table.");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getTables() {
        List<DiningTableDTO> tableDTOList = new ArrayList<>();
        boolean success = tableService.getTables(tableDTOList);
        if (success) {
            return ResponseEntity.ok(tableDTOList);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTableById(@PathVariable Long id) {
        DiningTableDTO tableDTO = new DiningTableDTO();
        boolean success = tableService.getTableById(id, tableDTO);
        if (success) {
            return ResponseEntity.ok(tableDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateTable(@PathVariable Long id, @RequestBody DiningTableDTO tableDTO) {
        boolean success = tableService.updateTable(id, tableDTO);
        if (success) {
            return ResponseEntity.ok("Table updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed to update table.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTable(@PathVariable Long id) {
        boolean success = tableService.deleteTable(id);
        if (success) {
            return ResponseEntity.ok("Table deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed to delete table.");
        }
    }
}
