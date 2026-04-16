package GameLibrary.repositories;

import org.springframework.stereotype.Repository;

import GameLibrary.models.Game;
import GameLibrary.repositories.interfaces.GameRepository;

@Repository
public class GameRepositoryImpl implements GameRepository {

    @Override
    public String getGameByTitleAndPlatform(String title, String platform) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGameByTitleAndPlatform'");
    }

    @Override
    public String getAllGames() {
        return "ALL OF THEM";
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
