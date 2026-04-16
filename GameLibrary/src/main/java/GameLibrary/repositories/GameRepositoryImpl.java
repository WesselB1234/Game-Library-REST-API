package GameLibrary.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import GameLibrary.exceptions.GameNotFoundException;
import GameLibrary.models.Game;
import GameLibrary.repositories.interfaces.GameRepository;

@Repository
public class GameRepositoryImpl implements GameRepository {

    private List<Game> gamesDatabase = new ArrayList<>();

    @Override
    public Game getGameByTitleAndPlatformExcludingId(Long id, String title, String platform) {

        for (Game game : gamesDatabase) {
            if (game.getId() != id && game.getTitle().equals(title) && game.getPlatform().equals(platform)) {
                return game;
            }
        }

        return null;
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

        return null;
    }

    @Override
    public void createNewGame(Game game) {

        Long gameId = gamesDatabase.size() + 1L;
        game.setId(gameId);

        gamesDatabase.add(game);
    }

    @Override
    public void updateGame(Game game) {

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
