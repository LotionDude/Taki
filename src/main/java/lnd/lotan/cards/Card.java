package lnd.lotan.cards;

import lnd.lotan.gamelogic.GameContext;
import lnd.lotan.gamelogic.TurnResult;

public interface Card {
  TurnResult play(GameContext gameContext);

  boolean isPlayable(Card previousCard);

  String getRepresentation();
}
