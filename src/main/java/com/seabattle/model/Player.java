package com.seabattle.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private Long id;
    private String nickname;
    private String login;
}
