package lnd.lotan.cards.uniquecards;

import lnd.lotan.cards.Card;
import lnd.lotan.gamelogic.GameContext;
import lnd.lotan.TurnResult;
import lombok.Getter;

@Getter
public class PlusThreeCard implements Card {

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
