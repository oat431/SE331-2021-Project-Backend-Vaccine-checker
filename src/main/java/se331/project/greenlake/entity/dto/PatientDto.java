package se331.project.greenlake.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.project.greenlake.entity.Comment;
import se331.project.greenlake.entity.Doctor;
import se331.project.greenlake.entity.VaccinatedList;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    Long id;
    String sex;
    String firstname;
    String lastname;
    Date date_of_birth;
    String hometown;
    Integer vaccinated_status;
    DoctorDto takeCare;
    List<CommentDto> doctor_suggestion;
    List<VaccinatedListDto> vaccinated_list;
    List<String> imageUrls;
}
