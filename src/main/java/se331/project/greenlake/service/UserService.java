package se331.project.greenlake.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.project.greenlake.security.entity.Authority;
import se331.project.greenlake.security.entity.User;

import java.util.Collection;
import java.util.List;

public interface UserService {
    Integer getUserSize();
    Page<User> getUsers(Integer pageSize, Integer page);
    User getUser(Long id);
    User save(User user);
    Page<User> getUsers(String username, Pageable pageable);
    Page<User> getUnVerifyUsers(Pageable pageable);
}
