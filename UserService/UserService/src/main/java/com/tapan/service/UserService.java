package com.tapan.service;

import com.tapan.entity.User;

import java.util.List;

public interface UserService {

     List<User> getAll();
    User getById(String id);
     User createUser(User user);
     User updateUser(String id,User user);
     boolean deleteUser(String id);

}
