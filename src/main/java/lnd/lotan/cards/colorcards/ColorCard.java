package lnd.lotan.cards.colorcards;

import lnd.lotan.cards.Card;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
@RequiredArgsConstructor
public abstract class ColorCard implements Card {
  private final String color;
}
