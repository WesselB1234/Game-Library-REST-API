package GameLibrary.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import GameLibrary.models.Game;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/games")
public class GameController {

    @GetMapping("/")
    public String getAllGames() {
        return "get All games";
    }

    @GetMapping("/{id}")
    public String getGameById(@PathVariable Long id) {
        return "get game by id: " + id;
    }

    @PostMapping("/")
    public String createNewGame(@RequestBody Game game) {
        return game.getGenre();
    }

    @PutMapping("/{id}")
    public String updateGame(@RequestBody Game game, @PathVariable Long id) {
        return "update game " + id + " " + game.getGenre();
    }

    @DeleteMapping("/{id}")
    public String deleteGameById(@PathVariable Long id) {
        return "delete";
    }
}