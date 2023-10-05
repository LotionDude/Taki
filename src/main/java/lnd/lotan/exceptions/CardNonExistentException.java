package lnd.lotan.exceptions;

public class CardNonExistentException extends Exception {
    public CardNonExistentException(String cardIdentifier) {
        super(cardIdentifier);
    }
}
