package com.seabattle.rest;

import com.seabattle.DAO.UserDao;
import com.seabattle.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersRestController {
    @Autowired
    private UserDao userDao;

    @PostMapping("/regist")
    @PreAuthorize("permitAll()")
    public int saveUser(@RequestBody User user) {
        userDao.saveUser(user);
        return userDao.findIdByLogin(user.getLogin());
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
