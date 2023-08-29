package com.vo3dyx.SpringBoot.service;


import com.vo3dyx.SpringBoot.dao.UserDAO;
import com.vo3dyx.SpringBoot.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    @Transactional
    public void updUser(User upduser) {
        userDAO.updUser(upduser);
    }

    @Override
    @Transactional
    public void deleteUsr(int id) {
        userDAO.deleteUsr(id);
    }

    @Override
    @Transactional
    public void addNewUser(User newUser) {
        userDAO.addNewUser(newUser);
    }
}


