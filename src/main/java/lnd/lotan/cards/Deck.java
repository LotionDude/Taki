package lnd.lotan.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
  private final List<Card> cards;

  public Deck() {
    this.cards = new ArrayList<>();
  }

  /* TODO: Generate an instance of the Random object with a randomized seed at the start of every
  new game. Additionally, have the configuration allow you to manually select a seed. */
  public void shuffle() {
    Collections.shuffle(this.cards, new Random());
  }
}
