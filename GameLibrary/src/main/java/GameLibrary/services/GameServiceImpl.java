package GameLibrary.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import GameLibrary.exceptions.GameNotFoundException;
import GameLibrary.models.Game;
import GameLibrary.services.interfaces.GameService;

@Service
public class GameServiceImpl implements GameService {

    private List<Game> gamesDatabase = new ArrayList<>();

    private Game getGameByTitleAndPlatformExcludingId(Long id, String title, String platform) {

        for (Game game : gamesDatabase) {
            if (game.getId() != id && game.getTitle().equals(title) && game.getPlatform().equals(platform)) {
                return game;
            }
        }

        return null;
    }

    private void throwIfDuplicateGameExists(Game game) {
        if (getGameByTitleAndPlatformExcludingId(game.getId(), game.getTitle(), game.getPlatform()) != null){
            throw new IllegalArgumentException(String.format("Game with title: %s and platform: %s already exists.", game.getTitle(), game.getPlatform()));
        }
    }

    @Override
    public List<Game> getAllGames() {
        return gamesDatabase;
    }

    @Override
    public Game getGameById(Long id) {

        for (Game game : gamesDatabase) {
            if (game.getId() == id) {
                return game;
            }
        }

        throw new GameNotFoundException(String.format("Game with id: %s does not exist.", id));
    }

    @Override
    public void createNewGame(Game game) {

        throwIfDuplicateGameExists(game);

        Long gameId = gamesDatabase.size() + 1L;
        game.setId(gameId);

        gamesDatabase.add(game);
    }

    @Override
    public void updateGame(Game game) {

        throwIfDuplicateGameExists(game);

        for (int i = 0; i < gamesDatabase.size(); i++) {
            if (gamesDatabase.get(i).getId() == game.getId()) {
                gamesDatabase.set(i, game);
                return;
            }
        }

        throw new GameNotFoundException(String.format( "Cannot update game with id: %s does not exist.", game.getId()));
    }

    @Override
    public void deleteGameById(Long id) {

        for (int i = 0; i < gamesDatabase.size(); i++) {
            if (gamesDatabase.get(i).getId() == id) {
                gamesDatabase.remove(i);
                return;
            }
        }

        throw new GameNotFoundException(String.format( "Cannot delete game with id: %s because it not exist.", id));
    }
}
