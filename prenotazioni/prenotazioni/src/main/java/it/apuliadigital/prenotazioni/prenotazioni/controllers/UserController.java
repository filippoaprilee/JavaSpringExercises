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

import it.apuliadigital.prenotazioni.prenotazioni.entitiesDTO.UserDTO;
import it.apuliadigital.prenotazioni.prenotazioni.services.UserService;

@Controller
@RequestMapping("/api/controller/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody UserDTO userDTO) {
        if (userService.addUser(userDTO)) {
            return new ResponseEntity<>("User added successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Phone number already registered. Please use a different number",
                    HttpStatus.BAD_REQUEST);
            // TODO BAD_REQUEST o INTERNAL_SERVER_ERROR?
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> removeUser(@PathVariable int id) {
        if (userService.removeUser(id)) {
            return new ResponseEntity<>("User with id " + id + " removed successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id) {
        UserDTO userDTO = userService.getUser(id);
        if (userDTO != null) {
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getUsers() {
        List<UserDTO> listUsersDTO = userService.getUsers();
        if (listUsersDTO != null) {
            return new ResponseEntity<>(listUsersDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Unexpected Error Occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        if (userService.updateUser(id, userDTO)) {
            return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User with id " + id + " not found", HttpStatus.NOT_FOUND);
        }

    }
}
