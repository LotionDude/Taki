package lnd.lotan.gamelogic;

import lnd.lotan.cards.Deck;
import lnd.lotan.configuration.CardConfiguration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameContext {
    private final Players players;
    private final Deck discardDeck;
    private final Deck drawDeck;

    public GameContext(List<String> playerIdentifiers, CardConfiguration cardConfiguration) {
        this.drawDeck = new Deck(cardConfiguration);
        this.discardDeck = this.drawDeck.drawCards(1);
        this.players = new Players(playerIdentifiers, this.distributeCards(cardConfiguration, playerIdentifiers.size()));
    }

    private List<Deck> distributeCards(CardConfiguration cardConfiguration, int playerCount) {
        return IntStream.range(0, playerCount).mapToObj(i -> drawDeck.drawCards(cardConfiguration.getStartingAmount())).collect(Collectors.toList());
    }
}
