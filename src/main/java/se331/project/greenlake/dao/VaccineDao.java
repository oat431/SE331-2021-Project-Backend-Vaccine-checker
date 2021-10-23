package se331.project.greenlake.dao;

import se331.project.greenlake.entity.Patient;
import se331.project.greenlake.entity.Vaccine;

import java.util.Date;

public interface VaccineDao {
    Patient addUpdateVaccineToPatient(Date vaccinatedWhen, Patient patient, Vaccine vaccine);
    Vaccine getVaccine(Long id);
}
