package lnd.lotan.gamemanagement;

import java.util.LinkedHashSet;
import java.util.Set;

public class TakiGameManagerBuilder {
  private final Set<String> playerIdentifierList;

  public TakiGameManagerBuilder() {
    this.playerIdentifierList = new LinkedHashSet<>();
  }

  public boolean addPlayer(String playerIdentifier) {
    return this.playerIdentifierList.add(playerIdentifier);
  }

  public boolean removePlayer(String playerIdentifier) {
    return playerIdentifierList.remove(playerIdentifier);
  }

  // TODO: Build the game manager
  public TakiGameManager build() {
    return null;
  }
}
