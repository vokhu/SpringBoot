package com.vo3dyx.SpringBoot.service;


import com.vo3dyx.SpringBoot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();


    User getUserById(int id);

    void updUser(User upduser);

    void deleteUsr(int id);

    void addNewUser(User newUser);
}
