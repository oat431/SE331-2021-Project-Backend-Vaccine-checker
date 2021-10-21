package se331.project.greenlake.entity;
import lombok.*;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Patient extends NormalUser {
    Integer vaccinated_status;

    // todo doctor mapping : many to one
    @ManyToOne
    Doctor take_care_by;

    // todo vaccine mapping : many to many
    @OneToMany(mappedBy = "vaccinated_patient")
    List<VaccinatedList> vaccinated_list;

    @OneToMany(mappedBy = "comment_to")
    List<Comment> doctor_suggestion;

    @ManyToMany
    List<Comment> comment_from_doctor;

}
