package lnd.lotan.gamemanagement;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class GameInstances {
    private final Map<String, TakiGameManager> gameInstances;

    public GameInstances() {
        this.gameInstances = new HashMap<>();
    }

    public void addGameManager(String gameInstanceIdentifier, TakiGameManager takiGameManager) {
        this.gameInstances.put(gameInstanceIdentifier, takiGameManager);
    }

    // TODO: add conditions for if an instance can be deleted
    public boolean removeGameInstance(String gameInstanceIdentifier) {
        return Optional.ofNullable(this.gameInstances.remove(gameInstanceIdentifier)).isPresent();
    }
}
