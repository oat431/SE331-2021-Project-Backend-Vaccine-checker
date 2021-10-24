package se331.project.greenlake.entity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class VaccinatedList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long vaccinated_list_id;

    @ManyToOne
    Patient vaccinated_patient;

    @ManyToOne
    Vaccine injected_vaccine;

    Date vaccinated_when;
}
