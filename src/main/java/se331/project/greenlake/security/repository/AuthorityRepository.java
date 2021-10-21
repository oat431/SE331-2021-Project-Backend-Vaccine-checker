package se331.project.greenlake.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import se331.project.greenlake.security.entity.Authority;
import se331.project.greenlake.security.entity.AuthorityName;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(AuthorityName input);
}
