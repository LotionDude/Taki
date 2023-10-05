package lnd.lotan.cards.dynamiccards;

import lnd.lotan.cards.Card;
import lnd.lotan.gamelogic.GameContext;
import lnd.lotan.gamelogic.TurnResult;
import lombok.Getter;

@Getter
public class UniversalTakiCard extends DynamicCard {
    public static final String NAME = "universalTaki";

    public UniversalTakiCard(String color) {
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
