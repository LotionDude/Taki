package lnd.lotan.cards.colorcards;

import lnd.lotan.cards.Card;
import lnd.lotan.cards.ColorableCard;
import lnd.lotan.cards.visitor.CardVisitor;
import lnd.lotan.cards.visitor.ColorableCardVisitor;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
@RequiredArgsConstructor
public abstract class ColorCard extends Card implements ColorableCard {
    private final String color;

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean isPlayable(Card previousCard) {
        return previousCard.isPlayable(new ColorableCardVisitor(this));
    }

    @Override
    public boolean isPlayable(CardVisitor cardVisitor) {
        return cardVisitor.isColorableCardPlayable(this);
    }
}
