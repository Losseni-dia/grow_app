package grow.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import grow.backend.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByLogin(String login);

    List<User> findByLastname(String lastname);
    
    Optional<User> findById(long id);
}
