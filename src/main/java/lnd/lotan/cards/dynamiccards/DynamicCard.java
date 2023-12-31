package lnd.lotan.cards.dynamiccards;

import lnd.lotan.cards.Card;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
@RequiredArgsConstructor
public abstract class DynamicCard implements Card {
  private final String previousColor;
}
