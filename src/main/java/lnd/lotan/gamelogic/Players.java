package lnd.lotan.gamelogic;

import lnd.lotan.exceptions.InvalidPlayerException;
import lnd.lotan.utility.Zipper;

import java.util.List;

public class Players {
    private static final int DEFAULT_STARTING_INDEX = 0;

    private final List<Player> players;
    private int playerIndexPointer;
    private TurnDirection turnDirection;

    public Players(List<String> playerIdentifiers, List<PlayerDeck> playerDecks) {
        this.players = Zipper.zipLists(playerIdentifiers, playerDecks, Player::new);
        this.playerIndexPointer = DEFAULT_STARTING_INDEX;
        this.turnDirection = TurnDirection.CLOCKWISE;
    }

    public Player getActivePlayer() {
        return this.players.get(playerIndexPointer);
    }

    public Player getPlayer(String userIdentifier) throws InvalidPlayerException {
        return this.players.stream()
                .filter(player -> player.getIdentifier().equals(userIdentifier))
                .findAny()
                .orElseThrow(() -> new InvalidPlayerException(userIdentifier));
    }

    public void reverseTurnOrder() {
        this.turnDirection = TurnDirection.reverseOrder(this.turnDirection);
    }

    public Player proceedTurn() {
        this.playerIndexPointer = this.evaluateNextPlayerTurn(1);
        return this.players.get(playerIndexPointer);
    }

    private int evaluateNextPlayerTurn(int proceedBy) {
        return ((proceedBy * turnDirection.getDirectionMultiplier()) + this.playerIndexPointer) % players.size();
    }
}
