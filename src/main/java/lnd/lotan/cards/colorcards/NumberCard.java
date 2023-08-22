package lnd.lotan.cards.colorcards;

import lnd.lotan.gamelogic.GameContext;
import lnd.lotan.TurnResult;
import lnd.lotan.cards.Card;
import lombok.Getter;

@Getter
public class NumberCard extends ColorCard{
  private final int number;

  public NumberCard(String color, int number) {
    super(color);
    this.number = number;
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
