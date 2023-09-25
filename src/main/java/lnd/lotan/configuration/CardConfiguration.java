package lnd.lotan.configuration;

import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Set;

@Data
@Component
@Configuration
@NoArgsConstructor
@ConfigurationProperties(prefix = "cards")
public class CardConfiguration {
    //bro fix this wrtfd wrong ewith yu
    private Long seed;
    private Integer duplicateCards;
    private Range<Integer> cardRange;
    private Set<String> colors;
    @Min(1)
    private Integer startingAmount;

    public CardConfiguration(CardConfiguration cardConfiguration) {
        this.seed = cardConfiguration.seed;
        this.duplicateCards = cardConfiguration.duplicateCards;
        this.cardRange = cardConfiguration.cardRange;
        this.colors = cardConfiguration.colors;
        this.startingAmount = cardConfiguration.startingAmount;
    }
}
