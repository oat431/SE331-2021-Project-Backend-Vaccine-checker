package se331.project.greenlake.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.project.greenlake.entity.Doctor;
import se331.project.greenlake.entity.Patient;

public interface PatientDao {
    Integer getPatientSize();
    Page<Patient> getPatients(Integer pageSize,Integer page);
    Patient getPatient(Long id);
    Patient getDoctorToTakeCare(Doctor doctor, Patient patient);
    Patient save(Patient patient);
//    Page<Patient> getPatient(String username, Pageable pageable);
//    Page<Patient> getDoctorInCare(Doctor doctor, Pageable pageable);
//    Page<Patient> getPatientVaccineStatus(Integer dose,Pageable pageable);
}
