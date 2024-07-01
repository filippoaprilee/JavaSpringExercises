package it.apuliadigital.prenotazioni.prenotazioni.services.impls;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.apuliadigital.prenotazioni.prenotazioni.entities.User;
import it.apuliadigital.prenotazioni.prenotazioni.entitiesDTO.UserDTO;
import it.apuliadigital.prenotazioni.prenotazioni.repositories.UserRepository;
import it.apuliadigital.prenotazioni.prenotazioni.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean addUser(UserDTO userDTO) {
        try {
            userRepository.save(fromDTOtoUser(userDTO, new User()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean removeUser(long id) {
        try {
            userRepository.findById(id).get(); // risolto ma bruttino
            userRepository.deleteById(id); // TODO torna sempre true perchè ignora se non trova l'entità 
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public UserDTO getUser(long id) {
        try {
            return fromUsertoDTO(userRepository.findById(id).get(), new UserDTO());
        } catch (Exception e) {
            return null;
        }        
    }

    @Override
    public List<UserDTO> getUsers() {
        try {

            List<User> listUsers = userRepository.findAll();
            List<UserDTO> listUsersDTO = new ArrayList<UserDTO>();
            for (User x : listUsers) {
                listUsersDTO.add(fromUsertoDTO(x, new UserDTO()));
            }
            return listUsersDTO;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean updateUser(long id, UserDTO userDTO) {

        try {
            // TODO
            // Optional<User> optUser = userRepository.findById(id);
            // User user = optUser.get()
            // user = fromDTOtoUser(userDTO, user);
            // userRepository.save(user);            
            userRepository.save(fromDTOtoUser(userDTO, userRepository.findById(id).get()));
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public UserDTO fromUsertoDTO(User user, UserDTO userDTO) {
        userDTO.setName(user.getName());
        userDTO.setPhone(user.getPhone());
        userDTO.setSurname(user.getSurname());
        return userDTO;
    }

    public User fromDTOtoUser(UserDTO userDTO, User user) {
        user.setName(userDTO.getName());
        user.setPhone(userDTO.getPhone());
        user.setSurname(userDTO.getSurname());
        return user;
    }

}
