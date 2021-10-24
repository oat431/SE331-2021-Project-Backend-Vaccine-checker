package se331.project.greenlake.dao.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se331.project.greenlake.dao.VaccineDao;
import se331.project.greenlake.entity.Patient;
import se331.project.greenlake.entity.VaccinatedList;
import se331.project.greenlake.entity.Vaccine;
import se331.project.greenlake.repository.PatientRepository;
import se331.project.greenlake.repository.VaccinatedListRepository;
import se331.project.greenlake.repository.VaccineRepository;

import java.util.Date;

@Repository
public class VaccineDaoImpl implements VaccineDao {
    @Autowired
    VaccinatedListRepository vaccinatedListRepository;

    @Autowired
    VaccineRepository vaccineRepository;

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Patient addUpdateVaccineToPatient(Date vaccinatedWhen, Patient patient, Vaccine vaccine) {
        vaccinatedListRepository.save(
                VaccinatedList.builder()
                        .vaccinated_when(vaccinatedWhen)
                        .injected_vaccine(vaccine)
                        .vaccinated_patient(patient)
                        .build()
        );
        patient.setVaccinated_status(patient.getVaccinated_status() == null ? 1 : patient.getVaccinated_status() + 1);
        return patientRepository.save(patient);
    }

    @Override
    public Vaccine getVaccine(Long id) {
        return vaccineRepository.getById(id);
    }
}
