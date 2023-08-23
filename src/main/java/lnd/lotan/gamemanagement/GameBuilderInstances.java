package lnd.lotan.gamemanagement;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class GameBuilderInstances {
  private final Map<String, TakiGameManagerBuilder> gameBuilderInstances;

  public GameBuilderInstances() {
    this.gameBuilderInstances = new HashMap<>();
  }

  public String createGameBuilderInstance() {
    String gameInstanceIdentifier = UUID.randomUUID().toString();
    this.gameBuilderInstances.putIfAbsent(gameInstanceIdentifier, new TakiGameManagerBuilder());

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
    return Optional.ofNullable(this.gameBuilderInstances.get(gameInstanceIdentifier))
        .map(TakiGameManagerBuilder::build);
  }
}
