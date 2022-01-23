package com.cursor.hibernate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cursor.hibernate.dao.UserDao;
import com.cursor.hibernate.dmo.User;

import java.util.List;


@Service
public class UserService {
    @Autowired
    UserDao userDao;

    @Transactional
    public void add(User user) {
        userDao.saveUser(user);
    }

    @Transactional
    public void remove(User user) {
        userDao.deleteUser(user);
    }

    @Transactional(readOnly = true)
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Transactional(readOnly = true)
    public List<User> listUsers() {
        return userDao.showAllUsers();
    }
}
