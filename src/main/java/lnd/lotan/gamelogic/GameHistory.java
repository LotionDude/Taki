package lnd.lotan.gamelogic;

import java.util.ArrayList;
import java.util.List;

public class GameHistory {
    private final List<TurnResult> turnResults;

    public GameHistory() {
        this.turnResults = new ArrayList<>();
    }
}
