package lnd.lotan.cards.colorcards;

import lnd.lotan.cards.Card;
import lombok.*;

@Getter
@Setter(AccessLevel.PROTECTED)
@RequiredArgsConstructor
public abstract class ColorCard implements Card {
  private final String color;
}
