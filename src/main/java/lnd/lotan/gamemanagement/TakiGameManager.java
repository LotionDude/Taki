package lnd.lotan.gamemanagement;

import lnd.lotan.configuration.GameConfiguration;
import lnd.lotan.gamelogic.GameContext;
import lnd.lotan.gamelogic.GameHistory;
import lombok.Getter;

import java.util.List;

@Getter
public class TakiGameManager {
    private final GameHistory gameHistory;
    private final GameContext gameContext;
    private final GameConfiguration gameConfiguration;

    public TakiGameManager(List<String> playerIdentifiers, GameConfiguration gameConfiguration) {
        this.gameContext = new GameContext(playerIdentifiers, gameConfiguration.getCardConfiguration());
        this.gameHistory = new GameHistory();
        this.gameConfiguration = gameConfiguration;

        playerIdentifiers.forEach(System.out::println);
    }
}
