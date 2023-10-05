package lnd.lotan.cards.visitor;

import lnd.lotan.cards.ColorableCard;
import lnd.lotan.cards.wildcards.WildCard;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter(AccessLevel.PROTECTED)
public class WildCardVisitor extends CardVisitor {
    private WildCard wildCard;

    @Override
    public boolean isColorableCardPlayable(ColorableCard previousCard) {
        return true;
    }
}
