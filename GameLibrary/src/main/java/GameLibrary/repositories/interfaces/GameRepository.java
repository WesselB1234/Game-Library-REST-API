package GameLibrary.repositories.interfaces;

import java.util.List;

import GameLibrary.models.Game;

public interface GameRepository {
    
    public Game getGameByTitleAndPlatformExcludingId(Long id, String title, String platform);
    public List<Game> getAllGames();
    public Game getGameById(Long id);
    public void createNewGame(Game game);
    public void updateGame(Game game);
    public void deleteGameById(Long id);
}
