package lnd.lotan.cards;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lnd.lotan.cards.colorcards.*;
import lnd.lotan.cards.dynamiccards.SwitchColorCard;
import lnd.lotan.cards.dynamiccards.UniversalTakiCard;
import lnd.lotan.cards.visitor.CardVisitor;
import lnd.lotan.cards.wildcards.KingCard;
import lnd.lotan.cards.wildcards.PlusThreeCard;
import lnd.lotan.gamelogic.GameContext;
import lnd.lotan.gamelogic.TurnResult;
import lombok.Getter;

import java.util.UUID;

@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "card")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ColorTakiCard.class, name = ColorTakiCard.NAME),
        @JsonSubTypes.Type(value = NumberCard.class, name = NumberCard.NAME),
        @JsonSubTypes.Type(value = PlusTwoCard.class, name = PlusTwoCard.NAME),
        @JsonSubTypes.Type(value = ReverseCard.class, name = ReverseCard.NAME),
        @JsonSubTypes.Type(value = StopCard.class, name = StopCard.NAME),
        @JsonSubTypes.Type(value = SwitchColorCard.class, name = SwitchColorCard.NAME),
        @JsonSubTypes.Type(value = UniversalTakiCard.class, name = UniversalTakiCard.NAME),
        @JsonSubTypes.Type(value = KingCard.class, name = KingCard.NAME),
        @JsonSubTypes.Type(value = PlusThreeCard.class, name = PlusThreeCard.NAME),
})
public abstract class Card {
    private final String ID;

    public Card() {
        this.ID = UUID.randomUUID().toString();
    }

    public abstract TurnResult play(GameContext gameContext);

    public abstract boolean isPlayable(Card previousCard);

    public abstract boolean isPlayable(CardVisitor cardVisitor);
}
