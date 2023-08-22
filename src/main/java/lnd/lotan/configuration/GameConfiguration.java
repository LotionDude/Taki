package lnd.lotan.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@Configuration
@EnableConfigurationProperties
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GameConfiguration {
  private CardConfiguration cardConfiguration;
}
