package com.seabattle.seabattle.rest;

import com.seabattle.seabattle.DAO.UserDao;
import com.seabattle.seabattle.model.Player;
import com.seabattle.seabattle.model.User;
import com.seabattle.seabattle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class UsersRestController {
    @Autowired
    private UserDao userDao;

    @PostMapping("/regist")
    @PreAuthorize("hasAuthority('users:read')")
    public void saveUser(@RequestBody User user) {
        userDao.saveUser(user);
    }

    @PostMapping("/update/users/{id}")
    @PreAuthorize("hasAuthority('users:read')")
    public void updateUser(@RequestBody User user) {
        userDao.update(user);
    }

    @GetMapping("/remove/user/{id}")
    @PreAuthorize("hasAuthority('users:write')")
    public void removeUser(@PathVariable("id") int id) {
        userDao.delete(id);
    }

    @GetMapping("/find/by/{id}")
    @PreAuthorize("hasAuthority('users:write')")
    public User findById(@PathVariable("id") int id) {
        return userDao.findById(id);
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('users:write')")
    public List<User> findAll() {
        return userDao.findAll();
    }


}
