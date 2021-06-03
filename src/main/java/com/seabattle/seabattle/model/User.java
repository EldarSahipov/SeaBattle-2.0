package com.seabattle.seabattle.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname")
    private String nickname;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "regist_date")
    private Date regist_date;

    @Column(name = "expire_date")
    private Date expire_date;

    @Column(name = "is_deleted")
    private Date is_deleted;

    @Column(name = "is_banned")
    private Date is_banned;
}
