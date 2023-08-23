package lnd.lotan.gamemanagement;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Component
public class GameInstances {
  private final Map<String, TakiGameManager> gameInstances;
  private final Map<String, TakiGameManagerBuilder> gameBuilderInstances;

  public GameInstances() {
    this.gameInstances = new HashMap<>();
    this.gameBuilderInstances = new HashMap<>();
  }

  public String createGameInstanceBuilder() {
    String gameInstanceIdentifier = UUID.randomUUID().toString();
    this.gameBuilderInstances.putIfAbsent(gameInstanceIdentifier, new TakiGameManagerBuilder());

    return gameInstanceIdentifier;
  }

  public boolean addPlayer(String gameInstanceIdentifier, String playerIdentifier) {
    return Optional.ofNullable(this.gameBuilderInstances.get(gameInstanceIdentifier))
        .map(gameInstance -> gameInstance.addPlayer(playerIdentifier))
        .orElse(false);
  }

  // TODO: Add conditions for if a game can be initialized, such as player count, etc.
  public boolean createGameInstance(String gameInstanceIdentifier) {
    return Optional.ofNullable(this.gameBuilderInstances.get(gameInstanceIdentifier))
        .map(
            gameInstance -> {
              this.gameInstances.put(gameInstanceIdentifier, gameInstance.build());
              this.gameBuilderInstances.remove(gameInstanceIdentifier);

              return true;
            })
        .orElse(false);
  }

  // TODO: add conditions for if an instance can be deleted
  public boolean removeGameInstance(String gameInstanceIdentifier) {
    return Optional.ofNullable(this.gameInstances.remove(gameInstanceIdentifier)).isPresent()
        || Optional.ofNullable(this.gameBuilderInstances.remove(gameInstanceIdentifier))
            .isPresent();
  }
}
