package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    private Map<Long, T> mapStorage = new HashMap<>();

    public Set<T> findAll() {
        return new HashSet<>(mapStorage.values());
    }

    public T findById(ID id) {
        return mapStorage.get(id);
    }

    public T save(T object) {
        if(object != null){
            if(object.getId() == null){
                object.setId(getNextId());
            }
            mapStorage.put(object.getId(), object);
        }else{
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    public void deleteById(ID id) {
        mapStorage.remove(id);
    }

    public void delete(T object) {
        mapStorage.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId(){
        long nextId;
        if(mapStorage.keySet().isEmpty()){
            nextId = 1L;
        }else{
            nextId = Collections.max(mapStorage.keySet()) + 1;
        }
        return nextId;
    }
}
