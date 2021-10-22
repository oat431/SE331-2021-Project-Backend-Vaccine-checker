package se331.project.greenlake.security.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.project.greenlake.security.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    Page<User> findByUsernameIgnoreCaseContainingOrFirstnameIgnoreCaseContaining(String username, String firstname, Pageable pageable);
    List<User> findAll();
}
