package it.apuliadigital.prenotazioni.prenotazioni.services;

import java.util.List;

import it.apuliadigital.prenotazioni.prenotazioni.entities.User;
import it.apuliadigital.prenotazioni.prenotazioni.entitiesDTO.UserDTO;

public interface UserService {
    public boolean addUser(UserDTO userDTO);
    public boolean removeUser(long id);
    public UserDTO getUser(long id);
    public List<UserDTO> getUsers();
    public boolean updateUser(long id, UserDTO userDTO);
    public UserDTO fromUsertoDTO(User user, UserDTO userDTO);
    public User fromDTOtoUser(UserDTO userDTO, User user);
}
