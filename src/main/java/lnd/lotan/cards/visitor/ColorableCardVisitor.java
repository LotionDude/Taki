package lnd.lotan.cards.visitor;

import lnd.lotan.cards.ColorableCard;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter(AccessLevel.PROTECTED)
public class ColorableCardVisitor extends CardVisitor {
    private ColorableCard colorableCard;

    @Override
    public boolean isColorableCardPlayable(ColorableCard previousCard) {
        return this.colorableCard.getColor().equals(previousCard.getColor());
    }
}
