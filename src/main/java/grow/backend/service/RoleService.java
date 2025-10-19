package grow.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grow.backend.exception.handler.RoleNotFoundException;
import grow.backend.model.Role;
import grow.backend.repository.RoleRepository;

@Service
public class RoleService {
    @Autowired
    private RoleRepository repository;

    public List<Role> getAll() {
        List<Role> roles = new ArrayList<>();
        repository.findAll().forEach(roles::add);
        return roles;
    }

    public Role get(String id) {
        Long indice = Long.parseLong(id);
        return repository.findById(indice)
                .orElseThrow(() -> new RoleNotFoundException(id));
    }

    public void add(Role role) {
        repository.save(role);
    }

    public void update(String id, Role role) {
        Long indice = Long.parseLong(id);
        repository.findById(indice)
                .orElseThrow(() -> new RoleNotFoundException(id));
        repository.save(role);
    }

    public void delete(String id) {
        Long indice = Long.parseLong(id);
        if (!repository.existsById(indice)) {
            throw new RoleNotFoundException(id);
        }
        repository.deleteById(indice);
    }
}
