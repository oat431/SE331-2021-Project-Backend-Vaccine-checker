package se331.project.greenlake.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.project.greenlake.entity.Doctor;
import se331.project.greenlake.entity.Patient;

public interface PatientService {
    Integer getPatientSize();
    Page<Patient> getPatients(Integer pageSize, Integer page);
    Patient getPatient(Long id);
    Patient save(Patient patient);
    Patient getDoctorToTakeCare(Long doctor_id, Long patient_id);
//    Page<Patient> getPatient(String username, Pageable pageable);
//    Page<Patient> getDoctorInCare(Doctor doctor, Pageable pageable);
//    Page<Patient> getPatientVaccineStatus(Integer dose,Pageable pageable);
}
