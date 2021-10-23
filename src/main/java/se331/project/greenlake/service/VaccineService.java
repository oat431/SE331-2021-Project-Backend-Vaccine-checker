package se331.project.greenlake.service;

import se331.project.greenlake.entity.Patient;

import java.util.Date;

public interface VaccineService {
    Patient addUpdateVaccineToPatient(Date vaccinatedWhen, Long patient_ID, Long vaccine_ID);
}
