package lnd.lotan;

import lnd.lotan.cards.colorcards.ColorCard;
import lnd.lotan.cards.colorcards.NumberCard;
import lnd.lotan.configuration.GameConfiguration;
import lnd.lotan.gamelogic.TakiGameManager;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Data
@SpringBootApplication
public class Main {
  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
    GameConfiguration gameConfiguration = context.getBean(GameConfiguration.class);
  }
}
