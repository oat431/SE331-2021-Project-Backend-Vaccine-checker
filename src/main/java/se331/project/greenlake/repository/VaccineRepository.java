package se331.project.greenlake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.project.greenlake.entity.Vaccine;

public interface VaccineRepository extends JpaRepository<Vaccine,Long> {
}
