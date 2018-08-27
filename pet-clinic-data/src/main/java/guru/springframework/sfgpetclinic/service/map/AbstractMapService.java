package guru.springframework.sfgpetclinic.service.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T, ID> {

    private Map<ID, T> mapStorage = new HashMap<>();

    public Set<T> findAll() {
        return new HashSet<>(mapStorage.values());
    }

    public T findById(ID id) {
        return mapStorage.get(id);
    }

    public T save(ID id, T object) {
        mapStorage.put(id, object);
        return object;
    }

    public void deleteById(ID id) {
        mapStorage.remove(id);
    }

    public void delete(T object) {
        mapStorage.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }
}
