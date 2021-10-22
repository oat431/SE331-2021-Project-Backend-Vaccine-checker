package se331.project.greenlake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.project.greenlake.entity.VaccinatedList;

public interface VaccinatedListRepository extends JpaRepository<VaccinatedList,Long> {
}
