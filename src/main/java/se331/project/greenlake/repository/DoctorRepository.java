package se331.project.greenlake.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.project.greenlake.entity.Doctor;
import se331.project.greenlake.entity.Patient;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    List<Doctor> findAll();
    //Page<Patient> findAllByPatients_in_care(Pageable pageable);
}
