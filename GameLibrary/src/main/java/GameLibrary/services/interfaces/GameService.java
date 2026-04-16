package GameLibrary.services.interfaces;
import java.util.List;

import GameLibrary.exceptions.GameNotFoundException;
import GameLibrary.models.Game;

public interface GameService {
    
    public List<Game> getAllGames();
    public Game getGameById(long id);
    public long createNewGame(Game game) throws IllegalArgumentException;
    public void updateGame(Game game) throws GameNotFoundException;
    public void deleteGameById(long id);
}
