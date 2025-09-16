package com.tapan.controller;

import com.tapan.entity.User;
import com.tapan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;
    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAll()
    {
        
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getByUserId( @PathVariable String id)
    {
        
        return ResponseEntity.ok(service.getById(id));
    }
    @PostMapping("/create")
    public ResponseEntity<User> addUser(@RequestBody User user)
    {
        User user1 = service.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
        User updatedUser = service.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }


}
