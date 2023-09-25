package lnd.lotan.gamemanagement;

import lnd.lotan.configuration.GameConfiguration;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class TakiGameManagerBuilder {
    private final Set<String> playerIdentifierList;
    private final GameConfiguration gameConfiguration;

    public TakiGameManagerBuilder(GameConfiguration gameConfiguration) {
        this.playerIdentifierList = new LinkedHashSet<>();
        this.gameConfiguration = gameConfiguration;
    }

    public boolean addPlayer(String playerIdentifier) {
        return this.playerIdentifierList.add(playerIdentifier);
    }

    public boolean removePlayer(String playerIdentifier) {
        return playerIdentifierList.remove(playerIdentifier);
    }

    public TakiGameManager build() {
        return new TakiGameManager(new ArrayList<>(playerIdentifierList), gameConfiguration);
    }
}
