package se331.project.greenlake.entity;
import lombok.*;
import se331.project.greenlake.security.entity.User;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Doctor extends User {
    String hospital;

    // todo mapping patient : one to many
    @OneToMany(mappedBy = "takeCare")
    List<Patient> patients_in_care;

    @OneToMany(mappedBy = "comment_by")
    List<Comment> comment_to_patient;

}
