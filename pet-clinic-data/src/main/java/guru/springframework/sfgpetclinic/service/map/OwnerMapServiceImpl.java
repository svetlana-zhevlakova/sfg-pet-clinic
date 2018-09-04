package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.service.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapServiceImpl extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(), owner);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
