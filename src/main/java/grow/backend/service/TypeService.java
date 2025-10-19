package grow.backend.service;

import grow.backend.exception.handler.TypeNotFoundException;
import grow.backend.model.Type;
import grow.backend.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeService {

    @Autowired
    private TypeRepository repository;

    public List<Type> getAll() {
        List<Type> types = new ArrayList<>();
        repository.findAll().forEach(types::add);
        return types;
    }

    public Type get(String id) {
        Long indice = Long.parseLong(id);
        return repository.findById(indice)
                .orElseThrow(() -> new TypeNotFoundException(id));
    }

    public void add(Type type) {
        repository.save(type);
    }

    public void update(String id, Type type) {
        Long indice = Long.parseLong(id);
        repository.findById(indice)
                .orElseThrow(() -> new TypeNotFoundException(id));
        repository.save(type);
    }

    public void delete(String id) {
        Long indice = Long.parseLong(id);
        if (!repository.existsById(indice)) {
            throw new TypeNotFoundException(id);
        }
        repository.deleteById(indice);
    }
}
