package com.seabattle.model;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.*;


@Entity
@Data
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "rang")
    private String rang;

    @Column(name = "matches")
    private int matches;

    @Column(name = "wins")
    private String wins;

    @Column(name = "wins_streak")
    private String wins_streak;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "is_playing")
    private int is_playing;

    @Column(name = "is_searching")
    private int is_searching;

}
