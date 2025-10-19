package grow.backend.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import grow.backend.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);

    Optional<Role> findById(String id);
}
