package lnd.lotan.gamelogic;

import lnd.lotan.cards.Deck;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Player {
    private final String identifier;
    private final Deck deck;
}
