package GameLibrary.repositories.interfaces;
import GameLibrary.models.Game;

public interface GameRepository {
    
    public String getGameByTitleAndPlatform(String title, String platform);
    public String getAllGames();
    public String getGameById(Long id);
    public String createNewGame(Game game);
    public String updateGame(Game game);
    public String deleteGameById(Long id);
}
