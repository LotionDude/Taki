package lnd.lotan.controllers;

import lnd.lotan.gamemanagement.GameInstances;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/taki/manager")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TakiGameManagerController {
  private GameInstances gameInstances;

  // TODO: Most of the functions implemented should return objects stating if something has
  // succeeded or not,and if not, give a valid reason

  // TODO: Most of these requests should have request body models

  @PostMapping("/instance")
  public String createGameInstance() {
    return gameInstances.createGameInstanceBuilder();
  }

  @PostMapping("/player")
  public boolean addPlayerToGameInstance(
          @RequestBody String gameInstanceIdentifier, @RequestParam String playerIdentifier) {
    return this.gameInstances.addPlayer(gameInstanceIdentifier, gameInstanceIdentifier);
  }

  @DeleteMapping("/instance")
  public boolean removeGameInstance(@RequestParam String gameInstanceIdentifier) {
    return this.gameInstances.removeGameInstance(gameInstanceIdentifier);
  }
}
