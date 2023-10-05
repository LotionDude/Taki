package lnd.lotan.cards.visitor;

import lnd.lotan.cards.colorcards.NumberCard;

public class NumberCardVisitor extends ColorableCardVisitor {
    public NumberCardVisitor(NumberCard numberCard) {
        super(numberCard);
    }

    @Override
    public boolean isNumberCardPlayable(NumberCard previousCard) {
        return super.isColorableCardPlayable(previousCard) && ((NumberCard) super.getColorableCard()).getNumber() == previousCard.getNumber();
    }
}
