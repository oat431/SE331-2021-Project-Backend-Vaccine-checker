package se331.project.greenlake.service.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se331.project.greenlake.dao.PatientDao;
import se331.project.greenlake.dao.VaccineDao;
import se331.project.greenlake.entity.Patient;
import se331.project.greenlake.entity.Vaccine;
import se331.project.greenlake.service.VaccineService;

import java.util.Date;

@Service
public class VaccineServiceImpl implements VaccineService {

    @Autowired
    VaccineDao vaccineDao;

    @Autowired
    PatientDao patientDao;

    @Override
    public Patient addUpdateVaccineToPatient(Date vaccinatedWhen, Long patient_ID, Long vaccine_ID) {
        Patient patient = patientDao.getPatient(patient_ID);
        Vaccine vaccine = vaccineDao.getVaccine(vaccine_ID);
        Patient output = vaccineDao.addUpdateVaccineToPatient(vaccinatedWhen,patient,vaccine);
        return output;
    }
}
