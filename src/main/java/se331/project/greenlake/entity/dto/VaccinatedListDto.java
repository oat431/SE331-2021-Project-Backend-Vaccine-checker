package se331.project.greenlake.entity.dto;

import lombok.*;
import se331.project.greenlake.entity.Patient;
import se331.project.greenlake.entity.Vaccine;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VaccinatedListDto {
    VaccineDto injected_vaccine;
    Date vaccinated_when;
}