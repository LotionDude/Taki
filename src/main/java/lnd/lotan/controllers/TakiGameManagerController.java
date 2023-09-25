package lnd.lotan.controllers;

import lnd.lotan.gamemanagement.GameInstances;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/taki/manager")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TakiGameManagerController {
    private GameInstances gameInstances;
}
