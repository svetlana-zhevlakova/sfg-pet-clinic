package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.service.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetMapServiceImpl extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Pet save(Pet object) {
        return save(object.getId(), object);
    }
}
