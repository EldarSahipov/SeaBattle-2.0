package com.seabattle.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Friends {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user1")
    private int user1;

    @Column(name = "user2")
    private int user2;

    @Column(name = "relation")
    private int relation;
}
