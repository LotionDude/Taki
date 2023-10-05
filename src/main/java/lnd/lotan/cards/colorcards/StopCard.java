package lnd.lotan.cards.colorcards;

import lnd.lotan.cards.Card;
import lnd.lotan.gamelogic.GameContext;
import lnd.lotan.gamelogic.TurnResult;
import lombok.Getter;

@Getter
public class StopCard extends ColorCard {
    public static final String NAME = "stopCard";

    public StopCard(String color) {
        super(color);
    }

    @Override
    public TurnResult play(GameContext gameContext) {
        return null;
    }

    @Override
    public boolean isPlayable(Card previousCard) {
        return false;
    }

}
