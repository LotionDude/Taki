package lnd.lotan.exceptions;

public class GameNonExistentException extends Exception {
    public GameNonExistentException(String gameIdentifier) {
        super(gameIdentifier);
    }
}
