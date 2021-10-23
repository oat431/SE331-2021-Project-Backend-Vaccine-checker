package se331.project.greenlake.service.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.project.greenlake.dao.UserDao;
import se331.project.greenlake.security.entity.Authority;
import se331.project.greenlake.security.entity.User;
import se331.project.greenlake.service.UserService;

import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public Integer getUserSize() {
        return userDao.getUserSize();
    }

    @Override
    public Page<User> getUsers(Integer pageSize, Integer page) {
        return userDao.getUsers(pageSize,page);
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public Page<User> getUsers(String username, Pageable pageable) {
        return userDao.getUsers(username,pageable);
    }

    @Override
    public Page<User> getUnVerifyUsers(Pageable pageable) {
        return userDao.getUnVerifyUsers(pageable);
    }
}
