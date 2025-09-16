package com.tapan.service;

import com.tapan.entity.User;
import com.tapan.exception.DataNotFoundException;
import com.tapan.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo repo;
    @Override
    public List<User> getAll() {

        List<User> all = repo.findAll();
        if(all==null)
        {
            throw new DataNotFoundException("Invalid Url");
        }
        return all;
    }

    @Override
    public User getById(String id) {
        return repo.findById(id)
                .orElseThrow(()->new DataNotFoundException
                        ("Records Not Found On Server with id "+id));
    }

    @Override
    public User createUser(User user) {

        User save = repo.save(user);
        if(save==null)
            throw new DataNotFoundException("User not found On server "+user);
        return save;
    }

    @Override
    public User updateUser(String id, User user) {
        User user1 = repo.findById(id).orElseThrow
                (() -> new DataNotFoundException("Records Updated with id "+id));
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        return repo.save(user1);
    }

    @Override
    public boolean deleteUser(String id) {
        User byId = getById(id);
        if(byId==null)
            throw  new DataNotFoundException("User not found with this "+byId);
        repo.deleteById(id);
        return true;
    }
}
