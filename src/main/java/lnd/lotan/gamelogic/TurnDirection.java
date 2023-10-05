package lnd.lotan.gamelogic;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TurnDirection {
    CLOCKWISE(1),
    COUNTER_CLOCKWISE(-1);
    private final int directionMultiplier;

    public static TurnDirection reverseOrder(TurnDirection turnDirection) {
        return turnDirection.equals(CLOCKWISE) ? COUNTER_CLOCKWISE : CLOCKWISE;
    }
}
