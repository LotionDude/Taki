package lnd.lotan.cards.colorcards;

import lnd.lotan.cards.Card;
import lnd.lotan.cards.visitor.CardVisitor;
import lnd.lotan.cards.visitor.NumberCardVisitor;
import lnd.lotan.gamelogic.GameContext;
import lnd.lotan.gamelogic.TurnResult;
import lombok.Getter;

@Getter
public class NumberCard extends ColorCard {
    public static final String NAME = "number";

    private final int number;

    public NumberCard(String color, int number) {
        super(color);
        this.number = number;
    }

    @Override
    public TurnResult play(GameContext gameContext) {
        return null;
    }

    @Override
    public boolean isPlayable(Card previousCard) {
        return previousCard.isPlayable(new NumberCardVisitor(this));
    }

    @Override
    public boolean isPlayable(CardVisitor cardVisitor) {
        return cardVisitor.isNumberCardPlayable(this);
    }

}
