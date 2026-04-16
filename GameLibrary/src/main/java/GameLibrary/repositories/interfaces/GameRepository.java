package GameLibrary.repositories.interfaces;
import java.util.List;

import GameLibrary.models.Game;

public interface GameRepository {
    
    public Game getGameByTitleAndPlatformExcludingId(long id, String title, String platform);
    public List<Game> getAllGames();
    public Game getGameById(long id);
    public long createNewGame(Game game);
    public void updateGame(Game game);
    public void deleteGameById(long id);
}
