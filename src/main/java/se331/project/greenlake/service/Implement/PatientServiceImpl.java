package se331.project.greenlake.service.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.project.greenlake.dao.DoctorDao;
import se331.project.greenlake.dao.PatientDao;
import se331.project.greenlake.entity.Doctor;
import se331.project.greenlake.entity.Patient;
import se331.project.greenlake.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientDao patientDao;

    @Autowired
    DoctorDao doctorDao;

    @Override
    public Integer getPatientSize() {
        return patientDao.getPatientSize();
    }

    @Override
    public Page<Patient> getPatients(Integer pageSize, Integer page) {
        return patientDao.getPatients(pageSize,page);
    }

    @Override
    public Patient getPatient(Long id) {
        return patientDao.getPatient(id);
    }

    @Override
    public Patient save(Patient patient) {
        return patientDao.save(patient);
    }

    @Override
    public Patient getDoctorToTakeCare(Long doctor_id, Long patient_id) {
        Patient patient = patientDao.getPatient(patient_id);
        Doctor doctor = doctorDao.getDoctor(doctor_id);
        return patientDao.getDoctorToTakeCare(doctor,patient);
    }

//    @Override
//    public Page<Patient> getPatient(String username, Pageable pageable) {
//        return patientDao.getPatient(username,pageable);
//    }

//    @Override
//    public Page<Patient> getDoctorInCare(Doctor doctor, Pageable pageable) {
//        return patientDao.getDoctorInCare(doctor,pageable);
//    }
//
//    @Override
//    public Page<Patient> getPatientVaccineStatus(Integer dose, Pageable pageable) {
//        return patientDao.getPatientVaccineStatus(dose,pageable);
//    }
}
