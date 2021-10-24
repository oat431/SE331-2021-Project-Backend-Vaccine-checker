package se331.project.greenlake.util.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TempPatientDoctor {
    Long patient_id;
    Long doctor_id;
}
