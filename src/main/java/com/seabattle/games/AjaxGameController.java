package com.seabattle.games;

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

    @GetMapping("/add/{id}")
    public int[][] add_ships(@PathVariable ("id") int id) {
        return game.add_ships(id);
    }

    @GetMapping("/search_game/{id}")
    public int[] Id_gamers(@PathVariable ("id") int id) {
        return game.Id_gamers(id);
    }

    @GetMapping("/game_start/{id}")
    public int Game_Start(@PathVariable ("id") int id) {
        return game.Game_Start(id);
    }

    @GetMapping("/motion/{motion}")
    public int Motion(@PathVariable ("motion") int motion) {
        return game.Motion(motion);
    }

    @GetMapping("/motion_update/{motion}")
    public int Motion_Update(@PathVariable ("motion") int motion) {
        return game.Motion_Update(motion);
    }

    @GetMapping("/winner/{score}")
    public int Winner(@PathVariable ("score") int score) {
        return game.Winner(score);
    }

    @GetMapping("/chek_id")
    public int Chek_id() {
        return game.Chek_id();
    }

    @GetMapping("/cheking/{id}")
    public int[][] Cheking(@PathVariable ("id") int id) {
        return game.Cheking(id);
    }
}
