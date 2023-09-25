package lnd.lotan.gamemanagement;

import lnd.lotan.configuration.GameConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Component
public class GameBuilderInstances {
    private final GameConfiguration defaultGameConfiguration;
    private final Map<String, TakiGameManagerBuilder> gameBuilderInstances;

    public GameBuilderInstances(@Autowired GameConfiguration gameConfiguration) {
        this.defaultGameConfiguration = gameConfiguration;
        this.gameBuilderInstances = new HashMap<>();
    }

    public String createGameBuilderInstance() {
        String gameInstanceIdentifier = UUID.randomUUID().toString();

        GameConfiguration gameConfiguration = new GameConfiguration(defaultGameConfiguration);
        gameConfiguration.getCardConfiguration().setSeed(System.currentTimeMillis());
        this.gameBuilderInstances.putIfAbsent(gameInstanceIdentifier, new TakiGameManagerBuilder(gameConfiguration));

        return gameInstanceIdentifier;
    }

    public boolean addPlayer(String gameInstanceIdentifier, String playerIdentifier) {
        return Optional.ofNullable(this.gameBuilderInstances.get(gameInstanceIdentifier))
                .map(gameInstance -> gameInstance.addPlayer(playerIdentifier))
                .orElse(false);
    }

    public boolean removeGameInstance(String gameInstanceIdentifier) {
        return Optional.ofNullable(this.gameBuilderInstances.remove(gameInstanceIdentifier))
                .isPresent();
    }

    // TODO: Add conditions for if a game can be initialized, such as player count, etc. and also
    // return invalid initialization reasons
    public Optional<TakiGameManager> buildGameInstance(String gameInstanceIdentifier) {
        return Optional.ofNullable(this.gameBuilderInstances.remove(gameInstanceIdentifier)).map(TakiGameManagerBuilder::build);
    }
}
