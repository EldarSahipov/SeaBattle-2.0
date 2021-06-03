package com.seabattle.seabattle.rest;

import com.seabattle.seabattle.DAO.ProfileDao;
import com.seabattle.seabattle.DAO.UserDao;
import com.seabattle.seabattle.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileDao profileDao;

    @Autowired
    private UserDao userDao;

    @GetMapping
    @PreAuthorize("hasAuthority('users:read')")
    public Profile myProfile() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        int user_id = userDao.findIdByLogin(auth.getName());
        return profileDao.findByUsers_Id(user_id);
    }

    @PostMapping("/reg/profile")
    @PreAuthorize("permitAll()")
    public void saveProfile(@RequestBody Profile profile) {
        profileDao.saveProfile(profile);
    }

//    @GetMapping
//    public String profile() {
//        return "profile";
//    }

//    @GetMapping("/{id}")
//    @PreAuthorize("hasAuthority('users:read')")
//    public Profile myProfile(@PathVariable("id") int users_id) {
//        return profileDao.findByUsers_Id(users_id);
//    }
}
