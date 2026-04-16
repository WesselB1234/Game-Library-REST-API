package GameLibrary.services.interfaces;

import java.util.List;

import GameLibrary.models.Game;

public interface GameService {
    
    public List<Game> getAllGames();
    public Game getGameById(Long id);
    public void createNewGame(Game game);
    public void updateGame(Game game);
    public void deleteGameById(Long id);
}
