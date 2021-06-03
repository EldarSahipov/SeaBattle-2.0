package com.seabattle.seabattle.games;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxGameController {

    @Autowired
    private Game game;

    @GetMapping("/check_field/{str}")
    public int Game_Check(@PathVariable("str") String str) {
        return game.Check(str);
    }

    @GetMapping("/add")
    public int[][] add_ships() {
        return game.add_ships();
    }

}
