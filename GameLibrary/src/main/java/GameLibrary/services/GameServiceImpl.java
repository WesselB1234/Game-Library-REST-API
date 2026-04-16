package GameLibrary.services;

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
    public String getAllGames() {
        return gameRepository.getAllGames();
    }

    @Override
    public String getGameById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGameById'");
    }

    @Override
    public String createNewGame(Game game) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createNewGame'");
    }

    @Override
    public String updateGame(Game game) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateGame'");
    }

    @Override
    public String deleteGameById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteGameById'");
    }
}
