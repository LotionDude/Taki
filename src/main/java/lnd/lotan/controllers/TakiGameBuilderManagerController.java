package lnd.lotan.controllers;

import lnd.lotan.gamemanagement.GameBuilderInstances;
import lnd.lotan.gamemanagement.GameInstances;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/taki/builder")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TakiGameBuilderManagerController {
    private GameInstances gameInstances;
    private GameBuilderInstances gameBuilderInstances;

    // TODO: Most of the functions implemented should return objects stating if something has
    // succeeded or not,and if not, give a valid reason

    // TODO: Most of these requests should have request body models

    @PostMapping("/instance/builder")
    public String createGameBuilderInstance() {
        return this.gameBuilderInstances.createGameBuilderInstance();
    }

    @PostMapping("/instance")
    public void createGameInstance(@RequestParam String gameInstanceIdentifier) {
        this.gameBuilderInstances
                .buildGameInstance(gameInstanceIdentifier)
                .ifPresent(
                        gameInstance ->
                                this.gameInstances.addGameManager(gameInstanceIdentifier, gameInstance));
    }

    @PostMapping("/player")
    public boolean addPlayerToGameInstance(
            @RequestParam String gameInstanceIdentifier, @RequestParam String playerIdentifier) {
        System.out.println("adding player...");
        return this.gameBuilderInstances.addPlayer(gameInstanceIdentifier, playerIdentifier);
    }

    @DeleteMapping("/instance")
    public boolean removeGameInstance(@RequestParam String gameInstanceIdentifier) {
        return this.gameInstances.removeGameInstance(gameInstanceIdentifier);
    }
}
