package com.seabattle.rest;

import com.seabattle.DAO.ProfileDao;
import com.seabattle.DAO.UserDao;
import com.seabattle.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileDao profileDao;

    @Autowired
    private UserDao userDao;

    @GetMapping
    @PreAuthorize("hasAuthority('users:read')")
    public List<Profile> Profile() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        int user_id = userDao.findIdByLogin(auth.getName());
        return profileDao.findByUsers_Id(user_id);
    }

    @GetMapping("/my")
    @PreAuthorize("hasAuthority('users:read')")
    public String myProfile() {
        return "profile";
    }

    @PostMapping("/reg_profile")
    @PreAuthorize("permitAll()")
    public void saveProfile(@RequestBody Profile profile) {
        profileDao.saveProfile(profile);
    }
}
