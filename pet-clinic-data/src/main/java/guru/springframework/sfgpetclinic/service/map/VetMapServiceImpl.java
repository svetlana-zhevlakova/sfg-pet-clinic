package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.service.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMapServiceImpl extends AbstractMapService<Vet, Long> implements VetService {

}
