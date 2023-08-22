package lnd.lotan.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@Configuration
@ConfigurationProperties(prefix = "cards")
public class CardConfiguration {
  private Integer duplicateCards;
  private Range<Integer> normalCardRange;
  private List<String> colors;
}
