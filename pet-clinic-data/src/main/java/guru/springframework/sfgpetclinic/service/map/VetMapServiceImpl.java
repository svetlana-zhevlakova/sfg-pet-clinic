package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.service.SpecialityService;
import guru.springframework.sfgpetclinic.service.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMapServiceImpl extends AbstractMapService<Vet, Long> implements VetService {

    private SpecialityService specialityService;

    public VetMapServiceImpl(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet save(Vet object) {
        if(!object.getSpecialities().isEmpty()){
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }
}
