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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @Operation(summary = "Get all games", description = "Returns a list of all games.")
    @ApiResponse(responseCode = "200", description = "Games retrieved successfully")
    @GetMapping
    public ResponseEntity<List<GameDTO>> getAllGames() {

        List<Game> games = gameService.getAllGames();

        return ResponseEntity.status(200).body(
            games.stream().map(game -> new GameDTO(game.getId(), game.getTitle(), game.getGenre(), game.getPlatform()))
            .toList()
        ); 
    }

    @Operation(summary = "Get a game by ID", description = "Returns a single game if it exists.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Game found"),
        @ApiResponse(responseCode = "404", description = "Game not found")
    })
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

    @Operation(summary = "Create a new game", description = "Adds a new game to the library.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Game created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid game data")
    })
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

    @Operation(summary = "Update an existing game", description = "Updates a game by ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Game updated successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid game data"),
        @ApiResponse(responseCode = "404", description = "Game not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<?> updateGame(@RequestBody Game game, @PathVariable Long id) {
        
        try{
            game.setId(id);
            gameService.updateGame(game);

            GameDTO gameDTO = new GameDTO(game.getId(), game.getTitle(), game.getGenre(), game.getPlatform());

            return ResponseEntity.status(200).body(gameDTO);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
        catch (GameNotFoundException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @Operation(summary = "Delete a game", description = "Deletes a game by ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Game deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Game not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGameById(@PathVariable Long id) {
        
        try {
            gameService.deleteGameById(id);
            return ResponseEntity.status(204).body(null);
        } 
        catch (GameNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}