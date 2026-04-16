package GameLibrary.services;

import java.util.List;

import org.springframework.stereotype.Service;

import GameLibrary.models.Game;
import GameLibrary.repositories.interfaces.GameRepository;
import GameLibrary.services.interfaces.GameService;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    private void throwIfDuplicateGameExists(Game game) throws Exception {
        
    }

    @Override
    public List<Game> getAllGames() {
        return this.gameRepository.getAllGames();
    }

    @Override
    public Game getGameById(Long id) {
        return this.gameRepository.getGameById(id);
    }

    @Override
    public long createNewGame(Game game) {
        return this.gameRepository.createNewGame(game);
    }

    @Override
    public void updateGame(Game game) {
        this.gameRepository.updateGame(game);
    }

    @Override
    public void deleteGameById(Long id) {
        this.gameRepository.deleteGameById(id);
    }
}
