package se331.project.greenlake.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.project.greenlake.security.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
