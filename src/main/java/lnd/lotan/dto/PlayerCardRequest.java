package lnd.lotan.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PlayerCardRequest extends PlayerRequest{
    private String cardIdentifier;
}
