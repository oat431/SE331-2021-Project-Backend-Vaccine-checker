package se331.project.greenlake.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.project.greenlake.entity.Doctor;
import se331.project.greenlake.entity.Patient;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient> findAll();
//    Page<Patient> findByVaccinated_status(Integer dose,Pageable pageable);
//    Page<Patient> findByTake_care_by(Doctor doctor, Pageable pageable);
}
