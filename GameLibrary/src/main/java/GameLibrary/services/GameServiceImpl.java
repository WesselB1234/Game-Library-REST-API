package GameLibrary.services;

import java.util.List;

import org.springframework.stereotype.Service;

import GameLibrary.exceptions.GameNotFoundException;
import GameLibrary.models.Game;
import GameLibrary.repositories.interfaces.GameRepository;
import GameLibrary.services.interfaces.GameService;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    private void throwIfDuplicateGameExists(Game game) throws IllegalArgumentException  {
        if (this.gameRepository.getGameByTitleAndPlatformExcludingId(game.getId(), game.getTitle(), game.getPlatform()) != null){
            throw new IllegalArgumentException(String.format("Game with title: %s and platform: %s already exists.", game.getTitle(), game.getPlatform()));
        }
    }

    @Override
    public List<Game> getAllGames() {
        return this.gameRepository.getAllGames();
    }

    @Override
    public Game getGameById(long id) {

        Game game = this.gameRepository.getGameById(id);

        if (game == null){
            throw new GameNotFoundException(String.format("Game with id: %s does not exist.", id));
        }

        return game;
    }

    @Override
    public long createNewGame(Game game) {

        throwIfDuplicateGameExists(game);

        return this.gameRepository.createNewGame(game);
    }

    @Override
    public void updateGame(Game game) {

        throwIfDuplicateGameExists(game);

        this.gameRepository.updateGame(game);
    }

    @Override
    public void deleteGameById(long id) {
        this.gameRepository.deleteGameById(id);
    }
}
