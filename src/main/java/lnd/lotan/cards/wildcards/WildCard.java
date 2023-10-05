package lnd.lotan.cards.wildcards;

import lnd.lotan.cards.Card;
import lnd.lotan.cards.visitor.CardVisitor;
import lnd.lotan.cards.visitor.WildCardVisitor;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
@RequiredArgsConstructor
public abstract class WildCard extends Card {
    @Override
    public boolean isPlayable(Card previousCard) {
        return previousCard.isPlayable(new WildCardVisitor(this));
    }

    @Override
    public boolean isPlayable(CardVisitor cardVisitor) {
        return cardVisitor.isWildCardPlayable(this);
    }
}
