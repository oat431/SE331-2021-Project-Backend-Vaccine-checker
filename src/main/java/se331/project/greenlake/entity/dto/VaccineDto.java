package se331.project.greenlake.entity.dto;

import lombok.*;
import se331.project.greenlake.entity.VaccinatedList;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VaccineDto {
    Long vaccine_id;
    String title;
    String short_title;
}
