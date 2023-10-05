package lnd.lotan.gamelogic;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Player {
    private final String identifier;
    private final PlayerDeck deck;
}
