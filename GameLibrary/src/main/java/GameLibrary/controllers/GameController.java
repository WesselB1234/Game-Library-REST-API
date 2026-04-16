package GameLibrary.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/games")
public class GameController {

    @GetMapping("/")
    public String getAllGames() {
        return "get All games";
    }

    @GetMapping("/{id}")
    public String getGameById() {
        return "get game by id";
    }

    @PostMapping("/")
    public String createNewGame() {
        return "create new game";
    }

    @PutMapping("/{id}")
    public String updateGame() {
        return "update game";
    }

    @DeleteMapping("/{id}")
    public String deleteGameById() {
        return "delete";
    }
}