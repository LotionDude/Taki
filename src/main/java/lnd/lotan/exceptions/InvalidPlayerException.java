package lnd.lotan.exceptions;

public class InvalidPlayerException extends Exception {
    public InvalidPlayerException(String userIdentifier) {
        super(userIdentifier);
    }
}
