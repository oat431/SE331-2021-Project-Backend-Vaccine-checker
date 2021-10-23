package se331.project.greenlake.dao.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.project.greenlake.dao.UserDao;
import se331.project.greenlake.security.entity.Authority;
import se331.project.greenlake.security.entity.User;
import se331.project.greenlake.security.repository.UserRepository;

import java.util.Collection;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserRepository userRepository;

    @Override
    public Integer getUserSize() {
        return Math.toIntExact(userRepository.count());
    }

    @Override
    public Page<User> getUsers(Integer pageSize, Integer page) {
        return userRepository.findAll(PageRequest.of(page-1,pageSize));
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Page<User> getUsers(String username, Pageable pageable) {
        return userRepository.findByUsernameIgnoreCaseContainingOrFirstnameIgnoreCaseContaining(username,username,pageable);
    }

    @Override
    public Page<User> getUnVerifyUsers(Pageable pageable) {
        return userRepository.findByVerifyIsFalse(pageable);
    }
}
