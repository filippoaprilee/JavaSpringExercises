package it.apuliadigital.gestioneristorante.controllers;

import it.apuliadigital.gestioneristorante.entitiesdto.UserDTO;
import it.apuliadigital.gestioneristorante.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserDTO userDTO) {
        boolean success = userService.addUser(userDTO);
        if (success) {
            return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create user.");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        List<UserDTO> userDTOList = new ArrayList<>();
        boolean success = userService.getUsers(userDTOList);
        if (success && !userDTOList.isEmpty()) {
            return ResponseEntity.ok(userDTOList);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to get users.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        UserDTO userDTO = new UserDTO();
        boolean success = userService.getUserById(id, userDTO);
        if (success) {
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        boolean success = userService.updateUser(id, userDTO);
        if (success) {
            return ResponseEntity.ok("User updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed to update user.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        boolean success = userService.deleteUser(id);
        if (success) {
            return ResponseEntity.ok("User deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed to delete user.");
        }
    }
}
