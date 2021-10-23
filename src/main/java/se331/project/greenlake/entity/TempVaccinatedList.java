package se331.project.greenlake.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TempVaccinatedList {
    Long patient_id;
    Long vaccine_id;
    Date vaccinated_when;
}
