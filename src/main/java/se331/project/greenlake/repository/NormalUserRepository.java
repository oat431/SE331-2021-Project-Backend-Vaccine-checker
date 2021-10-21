package se331.project.greenlake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.project.greenlake.entity.NormalUser;

import java.util.List;

public interface NormalUserRepository extends JpaRepository<NormalUser,Long> {
    List findAll();
}
