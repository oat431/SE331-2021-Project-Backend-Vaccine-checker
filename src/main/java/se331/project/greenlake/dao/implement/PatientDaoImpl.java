package se331.project.greenlake.dao.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.project.greenlake.dao.PatientDao;
import se331.project.greenlake.entity.Doctor;
import se331.project.greenlake.entity.Patient;
import se331.project.greenlake.repository.PatientRepository;
import se331.project.greenlake.security.repository.UserRepository;

@Repository
public class PatientDaoImpl implements PatientDao {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Integer getPatientSize() {
        return Math.toIntExact(patientRepository.count());
    }

    @Override
    public Page<Patient> getPatients(Integer pageSize, Integer page) {
        return patientRepository.findAll(PageRequest.of(page-1,pageSize));
    }

    @Override
    public Patient getPatient(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient getDoctorToTakeCare(Doctor doctor, Patient patient) {
        patient.setTake_care_by(doctor);
        return patientRepository.save(patient);
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

//    @Override
//    public Page<Patient> getPatient(String username, Pageable pageable) {
//        return userRepository.findByUsernameIgnoreCaseContainingOrFirstnameIgnoreCaseContaining(username,username,pageable);
//    }

//    @Override
//    public Page<Patient> getDoctorInCare(Doctor doctor, Pageable pageable) {
//        return patientRepository.findByTake_care_by(doctor,pageable);
//    }
//
//    @Override
//    public Page<Patient> getPatientVaccineStatus(Integer dose, Pageable pageable) {
//        return patientRepository.findByVaccinated_status(dose,pageable);
//    }
}
