package grow.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grow.backend.exception.handler.UserNotFoundException;
import grow.backend.model.User;
import grow.backend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        if (users.isEmpty()) {
            throw new UserNotFoundException(null);
        }
        return users;
    }

    public User get(String id) {
        Long indice = (long) Integer.parseInt(id);
        return userRepository.findById(indice)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public void add(User user) {
        userRepository.save(user);
    }

    public void update(String id, User user) {
        Long indice = (long) Integer.parseInt(id);
        if (userRepository.existsById(indice)) {
            userRepository.save(user);
        } else {
            throw new UserNotFoundException(id);
        }
    }

    public void delete(String id) {
        Long indice = (long) Integer.parseInt(id);
        if (userRepository.existsById(indice)) {
            userRepository.deleteById(indice);
        } else {
            throw new UserNotFoundException(id);
        }
    }

    public List<User> getUserByNom(String nom) {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        if (users.isEmpty()) {
            throw new UserNotFoundException(null);
        }
        return users;
    }

    
}
