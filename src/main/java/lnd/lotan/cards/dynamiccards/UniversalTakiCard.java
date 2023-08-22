package lnd.lotan.cards.dynamiccards;

import lnd.lotan.gamelogic.GameContext;
import lnd.lotan.TurnResult;
import lnd.lotan.cards.Card;
import lombok.Getter;

@Getter
public class UniversalTakiCard extends DynamicCard {

  public UniversalTakiCard(String color) {
    super(color);
  }

  @Override
  public TurnResult play(GameContext gameContext) {
    return null;
  }

  @Override
  public boolean isPlayable(Card previousCard) {
    return false;
  }

  @Override
  public String getRepresentation() {
    return null;
  }
}
