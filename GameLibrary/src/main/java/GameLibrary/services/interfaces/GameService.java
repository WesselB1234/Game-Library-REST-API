package GameLibrary.services.interfaces;
import GameLibrary.models.Game;

public interface GameService {
    
    public String getAllGames();
    public String getGameById(Long id);
    public String createNewGame(Game game);
    public String updateGame(Game game);
    public String deleteGameById(Long id);
}
