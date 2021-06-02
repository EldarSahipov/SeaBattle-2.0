package com.seabattle.seabattle.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user1")
    private int user1;

    @Column(name = "user2")
    private int user2;

    @Column(name = "winner")
    private int winner;

    @Column(name = "start_date")
    private Date start_date;


    @Column(name = "end_date")
    private Date end_date;
}
