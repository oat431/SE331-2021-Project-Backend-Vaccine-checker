package se331.project.greenlake.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientInCareDto {
    Long id;
    String sex;
    String firstname;
    String lastname;
    Date date_of_birth;
    String hometown;
    Integer vaccinated_status;
    List<VaccinatedListDto> vaccinated_list;
    List<String> imageUrls;
}
