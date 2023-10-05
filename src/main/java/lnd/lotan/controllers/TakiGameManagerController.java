package lnd.lotan.controllers;

import lnd.lotan.cards.Card;
import lnd.lotan.dto.GameRequest;
import lnd.lotan.dto.PlayerCardRequest;
import lnd.lotan.dto.PlayerRequest;
import lnd.lotan.exceptions.CardNonExistentException;
import lnd.lotan.exceptions.GameNonExistentException;
import lnd.lotan.exceptions.IllegalCardPlayException;
import lnd.lotan.exceptions.InvalidPlayerException;
import lnd.lotan.gamelogic.PlayerDeck;
import lnd.lotan.gamelogic.TurnResult;
import lnd.lotan.services.TakiGameManagerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/taki/manager")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TakiGameManagerController {
    private final TakiGameManagerService takiGameManagerService;

    @GetMapping("/discard")
    public Card getTopDiscardCard(@RequestBody GameRequest gameRequest) throws GameNonExistentException {
        return this.takiGameManagerService.peekDiscardPile(gameRequest);
    }

    @GetMapping("/cards")
    public PlayerDeck getCards(@RequestBody PlayerRequest playerRequest) throws GameNonExistentException, InvalidPlayerException {
        return this.takiGameManagerService.getPlayerDeck(playerRequest);
    }

    // TODO: Still need to add card functionality
    @PostMapping("/card")
    public TurnResult playCard(@RequestBody PlayerCardRequest playerCardRequest) throws GameNonExistentException, InvalidPlayerException, CardNonExistentException, IllegalCardPlayException {
        return this.takiGameManagerService.playCard(playerCardRequest);
    }
}
