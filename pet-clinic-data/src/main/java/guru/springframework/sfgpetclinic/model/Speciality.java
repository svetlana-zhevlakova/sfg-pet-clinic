package guru.springframework.sfgpetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Speciality extends BaseEntity {

    private String description;

    @Builder
    public Speciality(Long id, String description) {
        super(id);
        this.description = description;
    }
}
