package lnd.lotan.gamelogic;

import lnd.lotan.cards.Deck;
import lnd.lotan.utility.Zipper;

import java.util.List;

public class Players {
    private static final int DEFAULT_STARTING_INDEX = 0;

    private final List<Player> players;
    private int playerIndexPointer;

    public Players(List<String> playerIdentifiers, List<Deck> playerDecks) {
        this.players = Zipper.zipLists(playerIdentifiers, playerDecks, Player::new);
        this.playerIndexPointer = DEFAULT_STARTING_INDEX;
    }

    public Player proceedTurn() {
        this.playerIndexPointer = this.evaluateNextPlayerTurn(1);
        return this.players.get(playerIndexPointer);
    }

    private int evaluateNextPlayerTurn(int proceedBy) {
        return (playerIndexPointer + proceedBy) % players.size();
    }
}
