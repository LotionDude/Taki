package lnd.lotan.cards.visitor;

import lnd.lotan.cards.ColorableCard;
import lnd.lotan.cards.colorcards.NumberCard;
import lnd.lotan.cards.wildcards.WildCard;

public abstract class CardVisitor {
    public abstract boolean isColorableCardPlayable(ColorableCard previousCard);

    public boolean isNumberCardPlayable(NumberCard previousCard) {
        return this.isColorableCardPlayable(previousCard);
    }

    public boolean isWildCardPlayable(WildCard previousCard) {
        return true;
    }
}
