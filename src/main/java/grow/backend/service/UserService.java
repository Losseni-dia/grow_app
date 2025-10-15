package grow.backend.service;

import java.util.ArrayList;
import java.util.List;

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
            throw new UserNotFoundException(-1L);
        }
        return users;
    }

    public User getUser(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(long id, User user) {
        if (userRepository.existsById(id)) {
            userRepository.save(user);
        } else {
            throw new UserNotFoundException(id);
        }
    }

    public void deleteUser(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException(id);
        }
    }
}
