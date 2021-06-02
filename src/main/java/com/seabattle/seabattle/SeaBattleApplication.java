package com.seabattle.seabattle;

import com.seabattle.seabattle.DAO.UserDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SeaBattleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeaBattleApplication.class, args);
        System.out.println("Main");
    }

}
