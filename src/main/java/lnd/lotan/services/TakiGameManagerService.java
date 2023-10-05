package lnd.lotan.services;

import lnd.lotan.cards.Card;
import lnd.lotan.dto.GameRequest;
import lnd.lotan.dto.PlayerCardRequest;
import lnd.lotan.dto.PlayerRequest;
import lnd.lotan.exceptions.CardNonExistentException;
import lnd.lotan.exceptions.GameNonExistentException;
import lnd.lotan.exceptions.IllegalCardPlayException;
import lnd.lotan.exceptions.InvalidPlayerException;
import lnd.lotan.gamelogic.GameContext;
import lnd.lotan.gamelogic.Player;
import lnd.lotan.gamelogic.PlayerDeck;
import lnd.lotan.gamelogic.TurnResult;
import lnd.lotan.gamemanagement.GameInstances;
import lnd.lotan.gamemanagement.TakiGameManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TakiGameManagerService {
    private final GameInstances gameInstances;

    private TakiGameManager extractGameInstance(GameRequest gameRequest) throws GameNonExistentException {
        return this.gameInstances.getGameManager(gameRequest.getGameIdentifier());
    }

    public Card peekDiscardPile(GameRequest gameRequest) throws GameNonExistentException {
        return this.extractGameInstance(gameRequest).getGameContext().getDiscardDeck().peek();
    }

    public PlayerDeck getPlayerDeck(PlayerRequest playerRequest) throws InvalidPlayerException, GameNonExistentException {
        return this.extractGameInstance(playerRequest)
                .getGameContext()
                .getPlayers()
                .getPlayer(playerRequest.getUserIdentifier())
                .getDeck();
    }

    public TurnResult playCard(PlayerCardRequest playerCardRequest) throws InvalidPlayerException, CardNonExistentException, IllegalCardPlayException, GameNonExistentException {
        GameContext gameContext = this.extractGameInstance(playerCardRequest).getGameContext();
        Player currentPlayer = gameContext.getPlayers().getActivePlayer();

        if (!currentPlayer.getIdentifier().equals(playerCardRequest.getUserIdentifier())) {
            throw new InvalidPlayerException(playerCardRequest.getUserIdentifier());
        }

        Card card = currentPlayer.getDeck().getCard(playerCardRequest.getCardIdentifier());

        if (!card.isPlayable(gameContext.getDiscardDeck().peek())) {
            throw new IllegalCardPlayException();
        } else {
            return card.play(gameContext);
        }
    }
}
