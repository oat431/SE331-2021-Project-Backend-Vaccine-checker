package se331.project.greenlake.entity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Doctor extends NormalUser {
    String hospital;

    // todo mapping patient : one to many
    @OneToMany(mappedBy = "take_care_by")
    List<Patient> patients_in_care;

    @OneToMany(mappedBy = "comment_by")
    List<Comment> comment_to_patient;

}
