package se331.project.greenlake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.project.greenlake.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
