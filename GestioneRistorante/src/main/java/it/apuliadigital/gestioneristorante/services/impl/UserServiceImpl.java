package it.apuliadigital.gestioneristorante.services.impl;

import it.apuliadigital.gestioneristorante.entities.User;
import it.apuliadigital.gestioneristorante.entitiesdto.UserDTO;
import it.apuliadigital.gestioneristorante.repositories.UserRepository;
import it.apuliadigital.gestioneristorante.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public boolean addUser(UserDTO userDTO) {
        try {
            User user = fromDTOToUser(userDTO);
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean getUsers(List<UserDTO> userDTOList) {
        try {
            List<User> users = userRepository.findAll();
            for (User user : users) {
                userDTOList.add(fromUserToDTO(user));
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean getUserById(Long id, UserDTO userDTO) {
        if (userRepository.existsById(id)) {
            try {
                User user = userRepository.findById(id).get();
                UserDTO dto = fromUserToDTO(user);
                userDTO.setName(dto.getName());
                userDTO.setSurname(dto.getSurname());
                userDTO.setPhone(dto.getPhone());
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean updateUser(Long id, UserDTO userDTO) {
        if (userRepository.existsById(id)) {
            try {
                User foundUser = userRepository.findById(id).get();
                foundUser = fromDTOToUser(userDTO);
                userRepository.save(foundUser);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            try {
                userRepository.deleteById(id);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    private UserDTO fromUserToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setPhone(user.getPhone());
        return userDTO;
    }

    private User fromDTOToUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setPhone(userDTO.getPhone());
        return user;
    }

}
