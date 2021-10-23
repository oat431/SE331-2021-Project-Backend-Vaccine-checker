package se331.project.greenlake.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorAuthPatientInCareDto {
    List<PatientInCareDto> patients_in_care;
}
