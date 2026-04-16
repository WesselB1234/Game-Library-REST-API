package GameLibrary.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import GameLibrary.models.Game;
import GameLibrary.models.dto.GameDTO;
import GameLibrary.services.interfaces.GameService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping("/")
    public List<GameDTO> getAllGames() {

        List<Game> games = gameService.getAllGames();

        return games.stream().map(game -> new GameDTO(game.getId(), game.getTitle(), game.getGenre(), game.getPlatform())).toList(); 
    }

    @GetMapping("/{id}")
    public GameDTO getGameById(@PathVariable Long id) {
        
        Game game = gameService.getGameById(id);

        return new GameDTO(game.getId(), game.getTitle(), game.getGenre(), game.getPlatform());
    }

    @PostMapping("/")
    public String createNewGame(@RequestBody Game game) {
        
        long gameId = gameService.createNewGame(game);

        return "created new game with id: " + gameId;
    }

    @PutMapping("/{id}")
    public String updateGame(@RequestBody Game game, @PathVariable Long id) {

        game.setId(id);

        gameService.updateGame(game);

        return "update game " + id + " " + game.getGenre();
    }

    @DeleteMapping("/{id}")
    public String deleteGameById(@PathVariable Long id) {

        gameService.deleteGameById(id);

        return "delete";
    }
}