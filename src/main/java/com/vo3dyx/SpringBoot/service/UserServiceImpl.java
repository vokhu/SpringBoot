package com.vo3dyx.SpringBoot.service;


import com.vo3dyx.SpringBoot.dao.UserDAO;
import com.vo3dyx.SpringBoot.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    final UserDAO userDAO;

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
    public void updUser(User upduser) {
        userDAO.updUser(upduser);
    }

    @Override
    public void deleteUsr(int id) {
        userDAO.deleteUsr(id);
    }

    @Override
    public void addNewUser(User newUser) {
        userDAO.addNewUser(newUser);
    }
}


