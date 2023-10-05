package lnd.lotan.gamelogic;

import com.fasterxml.jackson.annotation.JsonGetter;
import lnd.lotan.cards.Card;
import lnd.lotan.exceptions.CardNonExistentException;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PlayerDeck {
    private final Map<String, Card> cardMap;

    public PlayerDeck() {
        this.cardMap = new HashMap<>();
    }

    public PlayerDeck(List<Card> cards) {
        this.cardMap = cards.stream().collect(Collectors.toMap(Card::getID, Function.identity()));
    }

    public void drawCards(Deck deck, int drawAmount) {
        deck.drawCards(drawAmount).forEach(card -> cardMap.put(card.getID(), card));
    }

    public Card getCard(String cardIdentifier) throws CardNonExistentException {
        return Optional.ofNullable(this.cardMap.get(cardIdentifier)).orElseThrow(() -> new CardNonExistentException(cardIdentifier));
    }

    @JsonGetter
    public Set<Card> getCards() {
        return new HashSet<>(this.cardMap.values());
    }
}
