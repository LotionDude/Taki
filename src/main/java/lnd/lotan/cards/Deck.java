package lnd.lotan.cards;

import lnd.lotan.cards.colorcards.*;
import lnd.lotan.configuration.CardConfiguration;
import lnd.lotan.configuration.Range;
import lnd.lotan.utility.ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Deck {
    private final List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public Deck(CardConfiguration cardConfiguration) {
        this.cards = new ArrayList<>();
        this.mergeDeck(this.createDeck(cardConfiguration)).shuffle(cardConfiguration.getSeed());
    }

    public Deck drawCards(int drawAmount) {
        return new Deck(ListUtilities.flushToNewList(this.cards, drawAmount));
    }

    /* TODO: Generate an instance of the Random object with a randomized seed at the start of every new game. */
    private void shuffle(Long seed) {
        Collections.shuffle(this.cards, new Random(seed));
    }

    private Deck mergeDeck(Deck deck) {
        this.cards.addAll(deck.cards);
        return this;
    }

    // TODO: Add non-color & dynamic-color cards to the deck
    private Deck createDeck(CardConfiguration cardConfiguration) {
        Deck deck = new Deck();
        IntStream.range(0, cardConfiguration.getDuplicateCards())
                .forEach(i -> deck.mergeDeck(this.createNumberCardDeck(cardConfiguration)).mergeDeck(this.createColorCardDeck(cardConfiguration)));
        return deck;
    }

    private Deck createNumberCardDeck(CardConfiguration cardConfiguration) {
        Range<Integer> cardRange = cardConfiguration.getCardRange();
        Deck deck = new Deck();

        cardConfiguration.getColors().forEach(color -> deck.mergeDeck(new Deck(
                IntStream.rangeClosed(cardRange.getFrom(), cardRange.getTo())
                        .<Card>mapToObj(number -> new NumberCard(color, number))
                        .collect(Collectors.toList())))
        );

        return deck;
    }

    //TODO: do not make code this hardcoded this hard wtf
    private Deck createColorCardDeck(CardConfiguration cardConfiguration) {
        Deck deck = new Deck();

        cardConfiguration.getColors().forEach(color -> deck.mergeDeck(new Deck(new ArrayList<>() {{
            this.add(new ColorTakiCard(color));
            this.add(new PlusTwoCard(color));
            this.add(new ReverseCard(color));
            this.add(new StopCard(color));
        }})));

        return deck;
    }
}
