package se331.project.greenlake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.project.greenlake.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
