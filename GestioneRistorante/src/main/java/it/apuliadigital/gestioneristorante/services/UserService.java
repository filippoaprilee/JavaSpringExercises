package it.apuliadigital.gestioneristorante.services;

import it.apuliadigital.gestioneristorante.entitiesdto.UserDTO;

import java.util.List;

public interface UserService {
    boolean addUser(UserDTO userDTO);
    boolean getUsers(List<UserDTO> userDTOList);
    boolean getUserById(Long id, UserDTO userDTO);
    boolean updateUser(Long id, UserDTO userDTO);
    boolean deleteUser(Long id);
}
