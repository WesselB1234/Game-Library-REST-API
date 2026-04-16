package GameLibrary.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import GameLibrary.exceptions.GameNotFoundException;
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

    @GetMapping
    public ResponseEntity<List<GameDTO>> getAllGames() {

        List<Game> games = gameService.getAllGames();

        return ResponseEntity.status(200).body(
            games.stream().map(game -> new GameDTO(game.getId(), game.getTitle(), game.getGenre(), game.getPlatform()))
            .toList()
        ); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGameById(@PathVariable Long id) {
        
        try{
            Game game = gameService.getGameById(id);
            GameDTO gameDTO = new GameDTO(game.getId(), game.getTitle(), game.getGenre(), game.getPlatform());
            
            return ResponseEntity.status(200).body(gameDTO);
        }
        catch (GameNotFoundException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createNewGame(@RequestBody Game game) {

        try{
            gameService.createNewGame(game);
            GameDTO gameDTO = new GameDTO(game.getId(), game.getTitle(), game.getGenre(), game.getPlatform());

            return ResponseEntity.status(201).body(gameDTO);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public String updateGame(@RequestBody Game game, @PathVariable Long id) {
        try{
            game.setId(id);
            gameService.updateGame(game);

            return "update game " + id + " " + game.getGenre();
        }
        catch (IllegalArgumentException e){
            return e.getMessage();
        }
        catch (GameNotFoundException e){
            return e.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    public String deleteGameById(@PathVariable Long id) {

        try{
            gameService.deleteGameById(id);

            return "delete";       
        }
        catch (GameNotFoundException e){
            return e.getMessage();
        }
    }
}