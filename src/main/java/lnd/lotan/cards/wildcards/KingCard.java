package lnd.lotan.cards.wildcards;

import lnd.lotan.cards.Card;
import lnd.lotan.gamelogic.GameContext;
import lnd.lotan.gamelogic.TurnResult;
import lombok.Getter;

@Getter
public class KingCard extends WildCard {
    public static final String NAME = "king";

    @Override
    public TurnResult play(GameContext gameContext) {
        return null;
    }

    @Override
    public boolean isPlayable(Card previousCard) {
        return false;
    }

}
