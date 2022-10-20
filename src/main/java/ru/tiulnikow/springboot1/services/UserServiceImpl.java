package ru.tiulnikow.springboot1.services;

import org.springframework.stereotype.Service;
import ru.tiulnikow.springboot1.dao.UserDao;
import ru.tiulnikow.springboot1.model.User;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDaoImpl;

    @Autowired
    public UserServiceImpl(UserDao userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Override
    public void addUser(User user) {
        userDaoImpl.save(user);
    }

    @Override
    public void updateUser(int id,User user) {
        User us = userDaoImpl.getReferenceById(id);
        us.setUserName(user.getUserName());
        us.setUserLastname(user.getUserLastname());
        us.setUserMail(user.getUserMail());
        us.setUserAge(user.getUserAge());
        userDaoImpl.save(us);
    }

    @Override
    public void removeUser(int id) {
        userDaoImpl.deleteById(id);
    }

    @Override
    public User getUserById(int id) {
        return userDaoImpl.getReferenceById(id);
    }

    @Override
    public List<User> listUser() {
        return userDaoImpl.findAll();
    }
}
