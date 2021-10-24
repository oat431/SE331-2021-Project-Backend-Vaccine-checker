package se331.project.greenlake.entity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long vaccine_id;
    String title;
    String short_title;

    // todo mapping patient :many to many
    @OneToMany(mappedBy = "injected_vaccine")
    List<VaccinatedList> patient_list;

}